//package Problem04HospitalDB;
//
//import jdk.jshell.Diag;
//
//import javax.persistence.*;
//import java.sql.Blob;
//import java.util.Date;
//import java.util.Set;
//
//@Entity
//@Table(name = "patients")
//public class Patient {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @Column(name = "first_name")
//    private String firstName;
//    @Column(name = "last_name")
//    private String lastName;
//    private String address;
//    private String email;
//    @Column(name = "date_of_birth")
//    private Date dateOfBirth;
//    private String picture;
//    @Column(name = "has_medical_insurance")
//    private boolean hasMedicalInsurance;
//
//    @OneToMany(targetEntity = Visitation.class)
//    private Set<Visitation> visitations;
//
//    @OneToMany(targetEntity = Diagnose.class)
//    private Set<Diagnose>diagnoses;
//
//    @OneToMany(targetEntity = Medicament.class)
//    private Set<Medicament> medicaments;
//
//    public Patient() {}
//
//    public int getId() {
//        return this.id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
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
//    public String getAddress() {
//        return this.address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
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
//    public Date getDateOfBirth() {
//        return this.dateOfBirth;
//    }
//
//    public void setDateOfBirth(Date dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
//
//    public String getPicture() {
//        return this.picture;
//    }
//
//    public void setPicture(String picture) {
//        this.picture = picture;
//    }
//
//    public boolean isHasMedicalInsurance() {
//        return this.hasMedicalInsurance;
//    }
//
//    public void setHasMedicalInsurance(boolean hasMedicalInsurance) {
//        this.hasMedicalInsurance = hasMedicalInsurance;
//    }
//
//    public Set<Visitation> getVisitations() {
//        return this.visitations;
//    }
//
//    public void setVisitations(Set<Visitation> visitations) {
//        this.visitations = visitations;
//    }
//
//    public Set<Diagnose> getDiagnoses() {
//        return this.diagnoses;
//    }
//
//    public void setDiagnoses(Set<Diagnose> diagnoses) {
//        this.diagnoses = diagnoses;
//    }
//
//    public Set<Medicament> getMedicaments() {
//        return this.medicaments;
//    }
//
//    public void setMedicaments(Set<Medicament> medicaments) {
//        this.medicaments = medicaments;
//    }
//}
