//package Problem02SalesDatabase.entities;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import java.util.Set;
//
//@Entity
//@Table(name = "store_location")
//public class StoreLocation extends BaseEntity {
//    @Column(name = "location_name")
//    private String locationName;
//
//    @OneToMany(targetEntity = Sale.class, mappedBy = "storeLocation")
//    private Set<Sale> sales;
//
//    public StoreLocation() {}
//
//    public String getLocationName() {
//        return this.locationName;
//    }
//
//    public void setLocationName(String locationName) {
//        this.locationName = locationName;
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
