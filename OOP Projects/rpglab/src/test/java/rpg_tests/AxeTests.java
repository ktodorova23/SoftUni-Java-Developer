package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class AxeTests {
    private static int POSITIVE_STATE = 5;
    private static int NEGATIVE_STATE = 0;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void setUp () {
        axe = new Axe(POSITIVE_STATE, POSITIVE_STATE);
        dummy = new Dummy(POSITIVE_STATE, POSITIVE_STATE);
    }
    @Test
    public void weaponShouldLoseDurabilityAfterAttacking() {
        axe.attack(dummy);

        Assert.assertEquals(POSITIVE_STATE - 1, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void weaponShouldThrowAnExceptionIfDurabilityEqualsZero() {
        axe = new Axe(POSITIVE_STATE, NEGATIVE_STATE);

        axe.attack(dummy);
    }
}
