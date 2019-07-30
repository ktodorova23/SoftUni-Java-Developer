package models.colonists;

public class GeneralPractitioner extends Medic {
    public GeneralPractitioner(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    protected int getPotentialBonuses() {
        int bonus = 0;

        if (this.getAge() > 15) {
            bonus++;
        }

        if (this.getSign().equals("caring")) {
            bonus++;
        } else if (this.getSign().equals("careless")) {
            bonus -= 2;
        }

        return super.getPotentialBonuses() + bonus;
    }

}
