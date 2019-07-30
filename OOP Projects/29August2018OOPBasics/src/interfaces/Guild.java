package interfaces;

public interface Guild {
    public String addHero(Hero hero);
    public String removeHero(Hero hero);
    public Hero getHeroByName(String heroName);
    public Long getGuildSize();
    public double getGuildPower();
    public String getGuildSpecialization();
    public String getName();
}
