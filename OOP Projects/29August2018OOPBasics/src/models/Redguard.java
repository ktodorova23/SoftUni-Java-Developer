package models;

public class Redguard extends Strength {
    private static final String HERO_TYPE = "REDGUARD";

    protected Redguard(String name, int magicka, int fatigue, int health) {
        super(name, magicka, fatigue, health, Redguard.HERO_TYPE);
    }

    @Override
    public String getBirthSign() {
        return "Strength";
    }
}
