//package Problem02SalesDatabase.entities;
//
//import javax.persistence.Entity;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//import java.util.Date;
//
//@Entity
//@Table(name = "sales")
//public class Sale extends BaseEntity {
//    @ManyToOne(targetEntity = Product.class)
//    private Product product;
//    @ManyToOne(targetEntity = Customer.class)
//    private Customer customer;
//    @ManyToOne(targetEntity = StoreLocation.class)
//    private StoreLocation storeLocation;
//    private Date date;
//
//    public Sale() {}
//
//    public Product getProduct() {
//        return this.product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//
//    public Customer getCustomer() {
//        return this.customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//
//    public StoreLocation getStoreLocation() {
//        return this.storeLocation;
//    }
//
//    public void setStoreLocation(StoreLocation storeLocation) {
//        this.storeLocation = storeLocation;
//    }
//
//    public Date getDate() {
//        return this.date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//}
