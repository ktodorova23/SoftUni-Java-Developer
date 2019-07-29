//package Problem03UniversitySystem.entities;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.ManyToMany;
//import javax.persistence.Table;
//import java.util.Set;
//
//@Entity
//@Table(name = "students")
//public class Student extends Person {
//    @Column(name = "average_grade")
//    private double averageGrade;
//    private String attendance;
//
//    @ManyToMany
//    private Set<Course> courses;
//
//    public Student() {}
//
//    public double getAverageGrade() {
//        return this.averageGrade;
//    }
//
//    public void setAverageGrade(double averageGrade) {
//        this.averageGrade = averageGrade;
//    }
//
//    public String getAttendance() {
//        return this.attendance;
//    }
//
//    public void setAttendance(String attendance) {
//        this.attendance = attendance;
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
