package models;

public class Nord extends Endurance {
    private static final String HERO_TYPE = "NORD";

    protected Nord(String name, int magicka, int fatigue, int health) {
        super(name, magicka, fatigue, health, Nord.HERO_TYPE);
    }

    @Override
    public String getBirthSign() {
        return "Endurance";
    }
}
