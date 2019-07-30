package interfaces;

public interface Hero {
    public String getName();
    public int getHealth();
    public double getOffense();
    public double getDefense();
    public double getTotalPoints();
    public boolean isDead();
    public void attack(Hero hero);
    public void receiveDamage(double amount);
    public String getBirthSign();

}
