//package Problem03UniversitySystem.entities;
//
//import javax.persistence.*;
//import java.util.Date;
//import java.util.Set;
//
//@Entity
//@Table(name = "courses")
//public class Course extends BaseEntity {
//    private String name;
//    private String description;
//    @Column(name = "start_date")
//    private Date startDate;
//    @Column(name = "end_date")
//    private Date endDate;
//    private int credits;
//
//    @ManyToMany(targetEntity = Student.class)
//    private Set<Student> students;
//
//    @ManyToOne(targetEntity = Teacher.class)
//    private Teacher teacher;
//
//    public Course() {}
//
//    public String getName() {
//        return this.name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return this.description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Date getStartDate() {
//        return this.startDate;
//    }
//
//    public void setStartDate(Date startDate) {
//        this.startDate = startDate;
//    }
//
//    public Date getEndDate() {
//        return this.endDate;
//    }
//
//    public void setEndDate(Date endDate) {
//        this.endDate = endDate;
//    }
//
//    public int getCredits() {
//        return this.credits;
//    }
//
//    public void setCredits(int credits) {
//        this.credits = credits;
//    }
//
//    public Set<Student> getStudents() {
//        return this.students;
//    }
//
//    public void setStudents(Set<Student> students) {
//        this.students = students;
//    }
//}
