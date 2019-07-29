//package Problem05BillsPaymentSystem;
//
//import javax.persistence.*;
//import java.util.Set;
//
//@Entity
//@Table(name = "users")
//public class User extends BaseEntity{
//    @Column(name = "first_name")
//    private String firstName;
//    @Column(name = "last_name")
//    private String lastName;
//    private String email;
//    private String password;
//
//    @OneToMany(mappedBy = "owner")
//    private Set<BillingDetail> billingDetails;
//
//    public User() {}
//
//    public String getFirstName() {
//        return this.firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return this.lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
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
//    public String getPassword() {
//        return this.password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Set<BillingDetail> getBillingDetails() {
//        return this.billingDetails;
//    }
//
//    public void setBillingDetails(Set<BillingDetail> billingDetails) {
//        this.billingDetails = billingDetails;
//    }
//}
