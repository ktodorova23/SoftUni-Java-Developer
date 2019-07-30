package mostwanted.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "races")
public class Race extends BaseEntity{
    @NotNull
    private int laps;
    @ManyToOne(targetEntity = District.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private District district;

    private List<RaceEntry> entries;

    public Race() {
        this.laps = 0;
    }

    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public List<RaceEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<RaceEntry> entries) {
        this.entries = entries;
    }
}
