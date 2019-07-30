package app.ccb.services;

import app.ccb.domain.dtos.importDtos.ClientSeedDto;
import app.ccb.domain.entities.Client;
import app.ccb.domain.entities.Employee;
import app.ccb.repositories.ClientRepository;
import app.ccb.repositories.EmployeeRepository;
import app.ccb.util.Constants;
import app.ccb.util.FileUtil;
import app.ccb.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final EmployeeRepository employeeRepository;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, EmployeeRepository employeeRepository, FileUtil fileUtil, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.clientRepository = clientRepository;
        this.employeeRepository = employeeRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public Boolean clientsAreImported() {
        return this.clientRepository.count() != 0;
    }

    @Override
    public String readClientsJsonFile() throws IOException {
        return this.fileUtil.readFile(Constants.CLIENTS_IMPORT_JSON_FILE_PATH);
    }

    @Override
    public String importClients(String clients) throws IOException {
        StringBuilder sb = new StringBuilder();

        ClientSeedDto[] clientSeedDtos = this.gson.fromJson(this.readClientsJsonFile(), ClientSeedDto[].class);

        for (ClientSeedDto dto : clientSeedDtos) {
            Client entity = this.modelMapper.map(dto, Client.class);
            entity.setFullName(dto.getFirstName() + " " + dto.getLastName());

            String[] employeeData = dto.getAppointedEmployee().split("\\s+");
            Employee employee = this.employeeRepository.findEmployeeByFirstNameAndLastName(employeeData[0], employeeData[1]);
            List<Employee> employees = entity.getEmployees();
            if (employees == null) {
                employees = new ArrayList<>();
            }
            employees.add(employee);
            entity.setEmployees(employees);

            Client client = this.clientRepository.findClientByFullName(entity.getFullName());

            if (client == null) {
                if (!this.validationUtil.isValid(entity)) {
                    sb.append(Constants.INCORECT_DATA_MESSAGE).append(System.lineSeparator());
                } else {
                    this.clientRepository.saveAndFlush(entity);
                    sb.append(String.format(Constants.SUCCESSFUL_DATA_IMPORT_MESSAGE, entity.getClass().getSimpleName(), entity.getFullName()))
                            .append(System.lineSeparator());
                }
            }
        }

        return sb.toString().trim();
    }

    @Override
    public String exportFamilyGuy() {
        StringBuilder sb = new StringBuilder();

        Set<Client> clients = this.clientRepository.findAll().stream().filter(c -> c.getBankAccount() != null).collect(Collectors.toSet());

        Client client = clients.stream()
                .filter(c -> c.getBankAccount().getCards().size() > 0)
                .sorted((a, b) -> Integer.compare(b.getBankAccount().getCards().size(), a.getBankAccount().getCards().size()))
                .collect(Collectors.toList()).get(0);

        sb.append(String.format("Client name: %s%n" +
                "Age: %d%n" +
                "Bank account: %n" +
                        "\tAccount number: %s%n" +
                        "\tBalance: %s%n" +
                "Cards: %d%n",
                client.getFullName(),
                client.getAge(),
                client.getBankAccount().getAccountNumber(),
                client.getBankAccount().getBalance(),
                client.getBankAccount().getCards().size()));

        client.getBankAccount().getCards()
                .forEach(c -> sb.append(String.format("\tCard number: %s%n" +
                "\tStatus: %s%n%n",
                        c.getCardNumber(),
                        c.getCardStatus())));

        return sb.toString().trim();
    }
}
