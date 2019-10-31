package app.domain.entities;

import app.domain.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "job_applications")
public class JobApplication extends BaseEntity {
    @Column(name = "sector", nullable = false)
    @Enumerated(EnumType.STRING)
    private Sector sector;
    @Column(name = "profession", nullable = false)
    private String profession;
    @Column(name = "salary", nullable = false)
    private BigDecimal salary;
    @Column(name = "description", nullable = false)
    private String description;

    public JobApplication() {}

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
