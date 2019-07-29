//package Problem02SalesDatabase.entities;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import java.util.Set;
//
//@Entity
//@Table(name = "customers")
//public class Customer extends BaseEntity {
//    private String name;
//    private String email;
//    @Column(name = "credit_card_number")
//    private String creditCardNumber;
//
//    @OneToMany(targetEntity = Sale.class, mappedBy = "customer")
//    private Set<Sale> sales;
//
//    public Customer() {}
//
//    public String getName() {
//        return this.name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return this.email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getCreditCardNumber() {
//        return this.creditCardNumber;
//    }
//
//    public void setCreditCardNumber(String creditCardNumber) {
//        this.creditCardNumber = creditCardNumber;
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
