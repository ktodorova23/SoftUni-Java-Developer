package kingsGambit.entities;

import kingsGambit.interfaces.Target;

public abstract class Unit {
    private String name;

    public Unit(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
