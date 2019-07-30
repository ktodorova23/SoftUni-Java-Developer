package hell.interfaces;

/**
 *  This is the interface for the ItemImpl entity
 *  @method String getName() - a getter for the name property of the ItemImpl
 *  @method long getStrengthBonus() - a getter for the strengthBonus property of the ItemImpl
 *  @method long getAgilityBonus() - a getter for the agilityBonus property of the ItemImpl
 *  @method long getIntelligenceBonus() - a getter for the intelligenceBonus property of the ItemImpl
 *  @method long getHitPointsBonus() - a getter for the hitPointsBonus property of the ItemImpl
 *  @method long getDamageBonus() - a getter for the damageBonus property of the ItemImpl
 */
public interface Item {
    String getName();

    int getStrengthBonus();

    int getAgilityBonus();

    int getIntelligenceBonus();

    int getHitPointsBonus();

    int getDamageBonus();
}