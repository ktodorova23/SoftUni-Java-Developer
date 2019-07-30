package mostwanted.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "race_entries")
public class RaceEntry extends BaseEntity{

    private boolean hasFinished;

    private Double finishTime;
    @ManyToOne(targetEntity = Car.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Car car;
    @ManyToOne(targetEntity = Racer.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Racer racer;
}
