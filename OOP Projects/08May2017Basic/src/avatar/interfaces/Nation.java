package avatar.interfaces;

public interface Nation {
    double calculateTotalPower();

    void getBonusFromMonuments();

    void addBender(Bender bender);

    void addMonument(Monument monument);

    double getPower();

    void emptyArmy();
}
