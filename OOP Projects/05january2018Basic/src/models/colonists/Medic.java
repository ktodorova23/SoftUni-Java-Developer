package models.colonists;

import models.colonists.Colonist;

public abstract class Medic extends Colonist {
    private String sign;

    protected Medic(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age);
        this.sign = sign;
    }

    public String getSign() {
        return this.sign;
    }

    @Override
    protected int getPotentialBonuses() {
        return 2;
    }
}
