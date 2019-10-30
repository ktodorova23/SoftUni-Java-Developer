package app.domain.entities;

import app.domain.entities.enums.Engine;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {
    @Column
    private String brand;
    @Column
    private String model;
    @Column
    private int year;
    @Enumerated(EnumType.STRING)
    private Engine engine;
    @ManyToOne(targetEntity = User.class)
    private User user;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
