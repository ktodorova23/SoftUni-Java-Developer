package alararestaurant.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "items")
public class Item extends BaseEntity {
    @NotNull(message = "Item's name cannot be null!")
    @Column(unique = true)
    @Size(min = 3, max = 30, message = "Item's name must be between 3 and 30 symbols long!")
    private String name;
    @NotNull(message = "Each item must have defined category!")
    @ManyToOne(targetEntity = Category.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Category category;
    @NotNull(message = "Price cannot be null!")
    @DecimalMin(value = "0.1", message = "Price cannot be negative!")
    private BigDecimal price;
    @OneToMany(targetEntity = OrderItem.class, mappedBy = "item", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    public Item() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
