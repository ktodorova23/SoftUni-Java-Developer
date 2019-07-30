package models.cells;

public class WhiteBloodCell extends BloodCell {
    private int size;

    public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
        super(id, health, positionRow, positionCol);
        this.size = size;
    }

    @Override
    public int calculateEnergy() {
        return (this.getHealth() + this.size) * 2;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("--------Health %d | Size %d | Energy %d%n",
                this.getHealth(), this.size, this.calculateEnergy());
    }
}
