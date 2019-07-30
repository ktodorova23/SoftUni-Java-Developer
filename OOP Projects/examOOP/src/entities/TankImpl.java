package entities;

import entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {
    private final static double ATTACK_POINTS_MODIFIER = 40.0;
    private final static double DEFENSE_POINTS_MODIFIER = 30.0;

    private boolean defenseMode;
    private double attackPointsModifier;
    private double defensePointsModifier;

    public TankImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, 100);
        this.defenseMode = true;
        this.attackPointsModifier = TankImpl.ATTACK_POINTS_MODIFIER;
        this.defensePointsModifier = TankImpl.DEFENSE_POINTS_MODIFIER;
        super.setAttackPoints(super.getAttackPoints() - this.attackPointsModifier);
        super.setDefensePoints(super.getDefensePoints() + this.defensePointsModifier);
    }

    @Override
    public boolean getDefenseMode() {
        return this.defenseMode;
    }

    @Override
    public void toggleDefenseMode() {
        if (this.defenseMode) {
            this.defenseMode = false;
            super.setAttackPoints(super.getAttackPoints() + this.attackPointsModifier);
            super.setDefensePoints(super.getDefensePoints() - this.defensePointsModifier);
        } else {
            this.defenseMode = true;
            super.setAttackPoints(super.getAttackPoints() - this.attackPointsModifier);
            super.setDefensePoints(super.getDefensePoints() + this.defensePointsModifier);
        }
    }

    @Override
    public String toString() {
        return String.format("%s *Defense Mode(%s)\n",
                super.toString(), this.getDefenseMode() ? "ON" : "OFF");
    }
}
