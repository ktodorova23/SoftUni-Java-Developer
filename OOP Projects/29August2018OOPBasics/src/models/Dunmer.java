package models;

public class Dunmer extends Willpower {
    private static final String HERO_TYPE = "DUNMER";

    protected Dunmer(String name, int magicka, int fatigue, int health) {
        super(name, magicka, fatigue, health, Dunmer.HERO_TYPE);
    }

    @Override
    public String getBirthSign() {
        return "Willpower";
    }
}
