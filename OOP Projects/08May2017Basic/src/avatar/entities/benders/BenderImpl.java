package avatar.entities.benders;

import avatar.interfaces.Bender;

public abstract class BenderImpl implements Bender {
    private String name;
    private long power;

    protected BenderImpl (String name, long power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return this.name;
    }

    public long getPower() {
        return this.power;
    }
}
