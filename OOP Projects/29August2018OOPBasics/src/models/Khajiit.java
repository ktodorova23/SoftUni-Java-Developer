package models;

public class Khajiit extends Strength {
    private static final String HERO_TYPE = "KHAJIIT";

    protected Khajiit(String name, int magicka, int fatigue, int health) {
        super(name, magicka, fatigue, health, Khajiit.HERO_TYPE);
    }

    @Override
    public String getBirthSign() {
        return "Strength";
    }
}
