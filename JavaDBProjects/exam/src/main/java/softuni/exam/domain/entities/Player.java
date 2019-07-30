package softuni.exam.domain.entities;

import softuni.exam.domain.entities.enums.Position;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "players")
public class Player extends BaseEntity{
    @NotNull
    @Column(name = "first_name")
    private String firstName;
    @NotNull
    @Size(min = 3, max = 15)
    @Column(name = "last_name")
    private String lastName;
    @NotNull
    @Min(1)
    @Max(99)
    private int number;
    @NotNull
    @Min(0)
    private BigDecimal salary;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Position position;
    @NotNull
    @ManyToOne(targetEntity = Picture.class, cascade = CascadeType.ALL)
    private Picture picture;
    @NotNull
    @ManyToOne(targetEntity = Team.class, cascade = CascadeType.ALL)
    private Team team;

    public Player() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
