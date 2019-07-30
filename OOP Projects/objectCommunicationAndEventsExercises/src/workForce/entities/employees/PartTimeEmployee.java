package workForce.entities.employees;

import workForce.utils.Constants;

public class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name) {
        super(name, Constants.PART_TIME_EMPLOYEE_WORKING_HOURS);
    }
}
