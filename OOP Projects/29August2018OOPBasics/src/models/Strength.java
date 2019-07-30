package models;

public class Strength extends Characters {
    private double magicDamage;

    protected Strength(String name, int magicka, int fatigue, int health, String heroType) {
        super(name, magicka, fatigue, health, heroType);
        this.setMagicDamage();
    }

    private void setMagicDamage() {
        this.magicDamage = this.getMagicka() * 0.5;
    }

    protected double getMagicDamage() {
        return this.magicDamage;
    }

    @Override
    public double getOffense() {
        return this.getFatigue() * 1.25 + this.getHealth() * 0.3 + this.getMagicDamage();
    }

    @Override
    public double getDefense() {
        return this.getHealth() + this.getFatigue() * 0.1;
    }

    @Override
    public String getBirthSign() {
        return this.getClass().getSimpleName();
    }


}
