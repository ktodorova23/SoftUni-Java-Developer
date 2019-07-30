package models;

public class Breton extends Willpower {
    private static final String HERO_TYPE = "BRETON";

    protected Breton(String name, int magicka, int fatigue, int health) {
        super(name, magicka, fatigue, health, Breton.HERO_TYPE);
    }

    @Override
    public String getBirthSign() {
        return "Willpower";
    }
}
