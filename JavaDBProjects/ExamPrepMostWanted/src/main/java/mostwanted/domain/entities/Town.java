package mostwanted.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity{
    @NotNull
    @Column(unique = true)
    private String name;
    @OneToMany(targetEntity = District.class, mappedBy = "town", cascade = CascadeType.ALL)
    private List<District> districts;
    @OneToMany(targetEntity = Racer.class, mappedBy = "homeTown", cascade = CascadeType.ALL)
    private List<Racer> racers;

    public Town() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

    public List<Racer> getRacers() {
        return racers;
    }

    public void setRacers(List<Racer> racers) {
        this.racers = racers;
    }
}
