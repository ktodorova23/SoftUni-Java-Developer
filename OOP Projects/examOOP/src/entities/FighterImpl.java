package entities;

import entities.interfaces.Fighter;

public class FighterImpl extends BaseMachine implements Fighter {
    private final static double ATTACK_POINTS_MODIFIER = 50.0;
    private final static double DEFENSE_POINTS_MODIFIER = 25.0;

    private boolean aggressiveMode;
    private double attackPointsModifier;
    private double defencePointsModifier;

    public FighterImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, 200);
        this.aggressiveMode = true;
        this.attackPointsModifier = FighterImpl.ATTACK_POINTS_MODIFIER;
        this.defencePointsModifier = FighterImpl.DEFENSE_POINTS_MODIFIER;
        super.setAttackPoints(super.getAttackPoints() + this.attackPointsModifier);
        super.setDefensePoints(super.getDefensePoints() - this.defencePointsModifier);
    }

    @Override
    public boolean getAggressiveMode() {

        return this.aggressiveMode;
    }

    @Override
    public void toggleAggressiveMode() {
        if (this.aggressiveMode) {
            this.aggressiveMode = false;
            super.setAttackPoints(super.getAttackPoints() - this.attackPointsModifier);
            super.setDefensePoints(super.getDefensePoints() + this.defencePointsModifier);
        } else {
            this.aggressiveMode = true;
            super.setAttackPoints(super.getAttackPoints() + this.attackPointsModifier);
            super.setDefensePoints(super.getDefensePoints() - this.defencePointsModifier);
        }
    }

    @Override
    public String toString() {
        return String.format("%s *Aggressive Mode(%s)\n",
                super.toString(), this.getAggressiveMode() ? "ON" : "OFF");
    }
}
