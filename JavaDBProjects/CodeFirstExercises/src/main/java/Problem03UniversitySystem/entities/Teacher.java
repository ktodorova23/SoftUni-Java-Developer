//package Problem03UniversitySystem.entities;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import java.math.BigDecimal;
//import java.util.Set;
//
//@Entity
//@Table(name = "teachers")
//public class Teacher extends Person {
//    private String email;
//    @Column(name = "salary_per_hour")
//    private BigDecimal salaryPerHour;
//
//    @OneToMany
//    private Set<Course> courses;
//
//    public Teacher() {}
//
//    public String getEmail() {
//        return this.email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public BigDecimal getSalaryPerHour() {
//        return this.salaryPerHour;
//    }
//
//    public void setSalaryPerHour(BigDecimal salaryPerHour) {
//        this.salaryPerHour = salaryPerHour;
//    }
//
//    public Set<Course> getCourses() {
//        return this.courses;
//    }
//
//    public void setCourses(Set<Course> courses) {
//        this.courses = courses;
//    }
//}
