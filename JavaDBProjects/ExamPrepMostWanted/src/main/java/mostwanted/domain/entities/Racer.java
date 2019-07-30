package mostwanted.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "racers")
public class Racer extends BaseEntity{
    @NotNull
    @Column(unique = true)
    private String name;
    private int age;
    private Double bounty;
    @ManyToOne(targetEntity = Town.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "home_town")
    private Town homeTown;
    @OneToMany(targetEntity = Car.class, mappedBy = "racer",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Car> cars;

    public Racer() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getBounty() {
        return bounty;
    }

    public void setBounty(Double bounty) {
        this.bounty = bounty;
    }

    public Town getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(Town homeTown) {
        this.homeTown = homeTown;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
