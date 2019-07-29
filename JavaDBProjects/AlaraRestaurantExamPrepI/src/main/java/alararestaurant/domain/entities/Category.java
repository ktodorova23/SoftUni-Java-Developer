package alararestaurant.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    @NotNull(message = "Category's name cannot be null!")
    @Size(min = 3, max = 30, message = "Category's name should be between 3 and 30 symbols long!")
    private String name;
    @OneToMany(targetEntity = Item.class, mappedBy = "category", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Item> items;

    public Category() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
