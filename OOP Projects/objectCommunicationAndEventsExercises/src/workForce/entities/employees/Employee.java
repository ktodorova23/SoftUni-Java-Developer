package workForce.entities.employees;

public abstract class Employee {
    private String name;
    private int workHoursPerWeek;

    public Employee(String name, int workHoursPerWeek) {
        this.name = name;
        this.workHoursPerWeek = workHoursPerWeek;
    }

    public String getName() {
        return this.name;
    }

    public int getWorkHoursPerWeek() {
        return this.workHoursPerWeek;
    }
}
