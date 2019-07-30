package models;

public class Orc extends Endurance {
    private static final String HERO_TYPE = "ORSIMER";


    protected Orc(String name, int magicka, int fatigue, int health) {
        super(name, magicka, fatigue, health, Orc.HERO_TYPE);
    }

    @Override
    public String getBirthSign() {
        return "Endurance";
    }
}
