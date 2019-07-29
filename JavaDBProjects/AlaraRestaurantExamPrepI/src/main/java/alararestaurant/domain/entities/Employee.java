package alararestaurant.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee extends BaseEntity {
    @NotNull(message = "Employee's name cannot be null!")
    @Size(min = 3, max = 30, message = "Employee's name should be between 3 and 30 symbols long!")
    private String name;
    @NotNull(message = "Employee must have age defined!")
    @Min(value = 15,message = "Employee cannot be under 15-years-old!")
    @Max(value = 80, message = "Employee cannot be above 80-years-old!")
    private int age;
    @NotNull(message = "Employee must have position defined!")
    @ManyToOne(targetEntity = Position.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Position position;
    @OneToMany(targetEntity = Order.class, mappedBy = "employee" , fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Order> orders;

    public Employee() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
