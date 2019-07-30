package rpg_tests;

import interfaces.Target;
import interfaces.Weapon;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Axe;
import rpg_lab.Hero;

public class HeroTests {
    private static final String HERO_NAME = "Pesho";
    private static final int POSITIVE_STATE = 5;
    private static final int NEGATIVE_STATE = 0;

    @Test
    public void heroShouldGainExperienceUponAttackIfTargetIsDead() {
        Weapon mockedWeapon = Mockito.mock(Weapon.class);
        Target mockedTarget = Mockito.mock(Target.class);
        Mockito.when(mockedTarget.isDead()).thenReturn(true);
        Mockito.when(mockedTarget.giveExperience()).thenReturn(POSITIVE_STATE);

        Hero hero = new Hero(HERO_NAME, mockedWeapon);
        hero.attack(mockedTarget);

        Assert.assertEquals(POSITIVE_STATE, hero.getExperience());
    }

    @Test
    public void heroShouldReceiveLootAfterTargetDeath() {
        Weapon weapon = new Axe(5, 10);
        Weapon mockedWeapon = Mockito.mock(Weapon.class);
        Target mockedTarget = Mockito.mock(Target.class);
        Mockito.when(mockedTarget.isDead()).thenReturn(true);
        Mockito.when(mockedTarget.getLoot()).thenReturn(weapon);

        Hero hero = new Hero(HERO_NAME, mockedWeapon);

        hero.attack(mockedTarget);

        Assert.assertEquals(weapon, hero.getInventory().get(0));
    }
}
