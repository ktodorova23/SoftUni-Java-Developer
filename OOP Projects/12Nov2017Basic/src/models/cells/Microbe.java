package models.cells;

import models.cells.Cell;

public abstract class Microbe extends Cell {
    private int virulence;

    public Microbe(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol);
        this.virulence = virulence;
    }

    public int getVirulence() {
        return this.virulence;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("--------Health %d | Virulence %d | Energy %d",
                this.getHealth(), this.virulence, this.calculateEnergy());
    }
}
