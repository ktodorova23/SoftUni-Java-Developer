package app.ccb.services;

import app.ccb.domain.dtos.importDtos.EmployeeSeedDto;
import app.ccb.domain.entities.Branch;
import app.ccb.domain.entities.Client;
import app.ccb.domain.entities.Employee;
import app.ccb.repositories.BranchRepository;
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
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final BranchRepository branchRepository;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, BranchRepository branchRepository, FileUtil fileUtil, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.employeeRepository = employeeRepository;
        this.branchRepository = branchRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public Boolean employeesAreImported() {
        return this.employeeRepository.count() != 0;
    }

    @Override
    public String readEmployeesJsonFile() throws IOException {
        return this.fileUtil.readFile(Constants.EMPLOYEES_IMPORT_JSON_FILE_PATH);
    }

    @Override
    public String importEmployees(String employees) throws IOException {
        StringBuilder sb = new StringBuilder();

        EmployeeSeedDto[] employeeSeedDtos = this.gson.fromJson(this.readEmployeesJsonFile(), EmployeeSeedDto[].class);

        for (EmployeeSeedDto dto : employeeSeedDtos) {
            Employee entity = this.modelMapper.map(dto, Employee.class);
            entity.setFirstName(dto.getFullName().split("\\s+")[0]);
            entity.setLastName(dto.getFullName().split("\\s+")[1]);
            Branch branch = this.branchRepository.findBranchByName(dto.getBranchName());
            entity.setBranch(branch);

            if (!this.validationUtil.isValid(entity)) {
                sb.append(Constants.INCORECT_DATA_MESSAGE).append(System.lineSeparator());
            } else {
                this.employeeRepository.saveAndFlush(entity);
                sb.append(String.format(Constants.SUCCESSFUL_DATA_IMPORT_MESSAGE, entity.getClass().getSimpleName(), dto.getFullName()))
                        .append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }

    @Override
    public String exportTopEmployees() {
        StringBuilder sb = new StringBuilder();

        Set<Employee> employees = this.employeeRepository.findAllByClientsNotNullOrderByClientsDescIdAsc();

        for (Employee employee : employees) {
            sb.append(String.format("Employee name: %s %s%n  Salary: %s%n  Clients: %d%n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getSalary(),
                    employee.getClients().size()));

            for (Client client : employee.getClients()) {
                sb.append(String.format("\tName: %s,%n\tAge: %d%n%n",
                        client.getFullName(),
                        client.getAge()));
            }
        }

        return sb.toString().trim();
    }
}
