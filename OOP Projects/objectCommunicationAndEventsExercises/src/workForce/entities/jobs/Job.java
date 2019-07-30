package workForce.entities.jobs;

import workForce.entities.employees.Employee;
import workForce.utils.Constants;

public class Job {
    private String name;
    private int hoursOfWorkRequired;
    private String status;

    public Job(String name, int hoursOfWorkRequired, Employee employee) {
        this.name = name;
        this.hoursOfWorkRequired = hoursOfWorkRequired;
        this.status = Constants.JOB_NOT_COMPLETED;
        this.update(employee);
    }

    public void setHoursOfWorkRequired(int hoursOfWorkRequired) {
        this.hoursOfWorkRequired = hoursOfWorkRequired;
    }

    private void update(Employee employee) {
        this.setHoursOfWorkRequired(this.hoursOfWorkRequired - employee.getWorkHoursPerWeek());

        if (this.hoursOfWorkRequired <= 0) {
            this.changeStatus();
        }
    }

    private void changeStatus() {
        this.status = Constants.JOB_COMPLETED;
    }

    public String getName() {
        return this.name;
    }

    public String getStatus() {
        return this.status;
    }
}
