package alararestaurant.service;

import alararestaurant.domain.dtos.importDtos.jsons.EmployeeSeedDto;
import alararestaurant.domain.entities.Employee;
import alararestaurant.domain.entities.Position;
import alararestaurant.repository.EmployeeRepository;
import alararestaurant.repository.PositionRepository;
import alararestaurant.util.Constants;
import alararestaurant.util.FileUtil;
import alararestaurant.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PositionRepository positionRepository;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, PositionRepository positionRepository, FileUtil fileUtil, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.employeeRepository = employeeRepository;
        this.positionRepository = positionRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public Boolean employeesAreImported() {
        return this.employeeRepository.count() > 0;
    }

    @Override
    public String readEmployeesJsonFile() throws IOException {
        return fileUtil.readFile(Constants.EMPLOYEES_INPUT_JSON_FILE_PATH);
    }

    @Override
    public String importEmployees(String employees) throws IOException {
        StringBuilder result = new StringBuilder();
        String employeesJsonFile = readEmployeesJsonFile();
        EmployeeSeedDto[] employeeSeedDtos = this.gson.fromJson(employeesJsonFile, EmployeeSeedDto[].class);

        for (EmployeeSeedDto dto : employeeSeedDtos) {
            Employee entity = this.modelMapper.map(dto, Employee.class);
            Position position = positionRepository.findPositionByName(dto.getPosition());

            if (position == null) {
                position = new Position();
                position.setName(dto.getPosition());

                if (!validationUtil.isValid(position)) {
                    validationUtil.validate(position).forEach(v -> System.out.println(v.getMessage()));
                    continue;
                }

                entity.setPosition(position);

                if (!validationUtil.isValid(entity)) {
                    validationUtil.validate(entity).forEach(v -> System.out.println(v.getMessage()));
                    continue;
                }

                positionRepository.saveAndFlush(position);
                result.append(String.format("Record %s successfully imported", entity.getName())).append(System.lineSeparator());
                employeeRepository.saveAndFlush(entity);
            } else {
                entity.setPosition(position);
                if (!validationUtil.isValid(entity)) {
                    validationUtil.validate(entity).forEach(v -> System.out.println(v.getMessage()));
                    continue;
                }

                result.append(String.format("Record %s successfully imported", entity.getName())).append(System.lineSeparator());
                employeeRepository.saveAndFlush(entity);
            }

        }
        return result.toString().trim();
    }
}
