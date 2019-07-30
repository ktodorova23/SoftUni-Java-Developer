package models;

import interfaces.Hero;

public abstract class Characters implements Hero {
    private String name;
    private int magicka;
    private int fatigue;
    private int health;
    private String heroType;

    protected Characters(String name, int magicka, int fatigue, int health, String heroType) {
        this.name = name;
        this.magicka = magicka;
        this.fatigue = fatigue;
        this.health = health;
        this.heroType = heroType;
    }

    protected int getMagicka() {
        return this.magicka;
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    public String getHeroType() {
        return this.heroType;
    }


    protected int getFatigue() {
        return this.fatigue;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public boolean isDead() {
        return this.getHealth() < 1;
    }

    @Override
    public double getTotalPoints() {
        return this.getOffense() + this.getDefense();
    }

    @Override
    public void attack(Hero hero) {
        hero.receiveDamage(this.getOffense());
    }

    @Override
    public void receiveDamage(double amount) {
        this.setHealth(this.getHealth() - (int) Math.floor(amount));
    }
}
