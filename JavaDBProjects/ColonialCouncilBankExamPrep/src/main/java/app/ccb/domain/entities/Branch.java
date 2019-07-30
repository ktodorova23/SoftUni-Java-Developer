package app.ccb.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "branches")
public class Branch extends BaseEntity {
    @NotNull
    private String name;
    @OneToMany(targetEntity = Employee.class, mappedBy = "branch", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Employee> employees;

    public Branch() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
