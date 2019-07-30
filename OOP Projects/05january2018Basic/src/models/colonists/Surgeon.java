package models.colonists;

public class Surgeon extends Medic {
    public Surgeon(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    protected int getPotentialBonuses() {
        int bonus = 0;

        if (this.getAge() > 25 && this.getAge() < 35) {
            bonus += 2;
        }

       if (this.getSign().equals("precise")) {
            bonus += 3;
        } else if (this.getSign().equals("butcher")) {
            bonus -= 3;
        }

        return super.getPotentialBonuses() + bonus;
    }
}
