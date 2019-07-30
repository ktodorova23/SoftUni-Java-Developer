package workForce.entities.employees;

import workForce.utils.Constants;

public class StandartEmployee extends Employee {
    public StandartEmployee(String name) {
        super(name, Constants.STANDART_EMPLOYEE_WORKING_HOURS);
    }
}
