package models;

public class Willpower extends Characters {
    private double spellPenetration;

    protected Willpower(String name, int magicka, int fatigue, int health, String heroType) {
        super(name, magicka, fatigue, health, heroType);
        this.setSpellPentration();
    }

    private void setSpellPentration() {
        this.spellPenetration = this.getFatigue() * 0.2;
    }

    @Override
    public double getOffense() {
        return this.getMagicka() * 1.8 + this.spellPenetration;
    }

    @Override
    public double getDefense() {
        return this.getHealth();
    }

    @Override
    public String getBirthSign() {
        return this.getClass().getSimpleName();
    }

}
