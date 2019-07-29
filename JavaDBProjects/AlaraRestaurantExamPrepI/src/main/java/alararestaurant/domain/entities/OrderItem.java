package alararestaurant.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "order_items")
public class OrderItem extends BaseEntity {
    @NotNull(message = "Each item must be a part of an order!")
    @ManyToOne(targetEntity = Order.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Order order;
    @NotNull(message = "There must be an item for an order to occur!")
    @ManyToOne(targetEntity = Item.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Item item;
    @NotNull(message = "Item quantity cannot be null!")
    @Min(value = 1,message = "Quantity cannot be negative or zero!")
    private int quantity;

    public OrderItem() {}

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
