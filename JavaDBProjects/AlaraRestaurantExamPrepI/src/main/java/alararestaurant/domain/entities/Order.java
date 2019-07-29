package alararestaurant.domain.entities;

import alararestaurant.domain.enums.OrderType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    @NotNull(message = "Customer cannot be null!")
    private String customer;
    @NotNull(message = "Each order must have date and time defined!")
    private String dateTime;
    @Enumerated(EnumType.STRING)
    private OrderType type;
    @NotNull(message = "Each order must have an assigned employee!")
    @ManyToOne(targetEntity = Employee.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Employee employee;
    @OneToMany(targetEntity = OrderItem.class, mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    public Order() {
        this.type = OrderType.ForHere;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
