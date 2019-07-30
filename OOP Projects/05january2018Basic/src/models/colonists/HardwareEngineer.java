package models.colonists;

public class HardwareEngineer extends Engineer {
    public HardwareEngineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    protected int getPotentialBonuses() {
        int bonus = 0;

        if (this.getAge() < 18) {
            bonus += 2;
        }
        return super.getPotentialBonuses() + bonus;
    }
}
