package models.cells;

public class RedBloodCell extends BloodCell {
    private int velocity;

    public RedBloodCell(String id, int health, int positionRow, int positionCol, int velocity) {
        super(id, health, positionRow, positionCol);
        this.velocity = velocity;
    }


    @Override
    public int calculateEnergy() {
        return this.getHealth() + this.velocity;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("--------Health %d | Velocity %d | Energy %d%n",
                this.getHealth(), this.velocity, this.calculateEnergy());
    }
}
