package kingsGambit.entities;

import kingsGambit.interfaces.Defender;

public class Footman extends Unit implements Defender {
    public Footman(String name) {
        super(name);
    }

    @Override
    public String respondToAttack() {
        return String.format("Footman %s is panicking!", super.getName());
    }
}
