package alararestaurant.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "positions")
public class Position extends BaseEntity {
    @NotNull(message = "Position's name cannot be null!")
    @Column(unique = true)
    @Size(min = 3, max = 30, message = "Position's name must be between 3 and 30 symbols long!")
    private String name;
    @OneToMany(targetEntity = Employee.class, mappedBy = "position", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Employee> employees;

    public Position() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
