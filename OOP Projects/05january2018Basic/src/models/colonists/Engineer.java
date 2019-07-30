package models.colonists;

import models.colonists.Colonist;

public abstract class Engineer extends Colonist {
    public Engineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    protected int getPotentialBonuses() {
        int bonus = 3;

        if (this.getAge() > 30) {
            bonus += 2;
        }

        return bonus;
    }
}
