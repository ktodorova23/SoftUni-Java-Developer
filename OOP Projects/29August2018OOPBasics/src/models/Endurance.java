package models;

public class Endurance extends Characters {
    private double magicResistance;

    protected Endurance(String name, int magicka, int fatigue, int health, String heroType) {
        super(name, magicka, fatigue, health, heroType);
        this.setMagicResistance();
        this.setHealth(health);
    }

    private void setMagicResistance() {
        this.magicResistance = this.getMagicka() * 0.4;
    }

    @Override
    protected void setHealth(int health) {
        super.setHealth(health * 2);
    }

    @Override
    public double getOffense() {
        return this.getFatigue();
    }

    @Override
    public double getDefense() {
        return this.getHealth() + this.getFatigue() * 0.6 + this.magicResistance;
    }

    @Override
    public String getBirthSign() {
        return this.getClass().getSimpleName();
    }

}
