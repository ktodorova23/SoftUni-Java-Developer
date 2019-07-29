//package Problem02SalesDatabase.entities;
//
//import javax.persistence.Entity;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import javax.persistence.Transient;
//import java.math.BigDecimal;
//import java.util.Set;
//
//@Entity
//@Table(name = "products")
//public class Product extends BaseEntity {
//    private String name;
//    private Double quantity;
//    private BigDecimal price;
//
//    @OneToMany(targetEntity = Sale.class, mappedBy = "product")
//    private Set<Sale> sales;
//
//    public Product() {}
//
//    public String getName() {
//        return this.name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Double getQuantity() {
//        return this.quantity;
//    }
//
//    public void setQuantity(Double quantity) {
//        this.quantity = quantity;
//    }
//
//    public BigDecimal getPrice() {
//        return this.price;
//    }
//
//    public void setPrice(BigDecimal price) {
//        this.price = price;
//    }
//
//    public Set<Sale> getSales() {
//        return this.sales;
//    }
//
//    public void setSales(Set<Sale> sales) {
//        this.sales = sales;
//    }
//}
