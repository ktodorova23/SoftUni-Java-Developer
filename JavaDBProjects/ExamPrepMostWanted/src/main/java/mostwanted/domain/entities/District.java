package mostwanted.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "districts")
public class District  extends  BaseEntity{
    @NotNull
    @Column(unique = true)
    private String name;
    @ManyToOne(targetEntity = Town.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Town town;
    @OneToMany(targetEntity = Race.class, mappedBy = "district", cascade = CascadeType.ALL)
    private List<Race> races;

    public District() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public List<Race> getRaces() {
        return races;
    }

    public void setRaces(List<Race> races) {
        this.races = races;
    }
}
