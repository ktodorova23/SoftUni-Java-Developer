package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class DummyTests {
    private static int POSITIVE_STATE = 5;
    private static int NEGATIVE_STATE = 0;
    private static int ATTACK_VALUE = 2;

    private Dummy dummy;

    @Before
    public void setDefaultDummy () {
        dummy = new Dummy(POSITIVE_STATE, POSITIVE_STATE);
    }

    @Test
    public void dummyShouldLoseHealthAfterBeingAttacked() {
        dummy.takeAttack(ATTACK_VALUE);

        Assert.assertEquals(POSITIVE_STATE - ATTACK_VALUE, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void dummyShouldThrowAnExceptionIfIsDeadWhenAttacked() {
        dummy = new Dummy(NEGATIVE_STATE, POSITIVE_STATE);

        dummy.takeAttack(POSITIVE_STATE);
    }

    @Test
    public void dummyShouldGrantExperienceUponDeath() {
        dummy = new Dummy(NEGATIVE_STATE, POSITIVE_STATE);

        Assert.assertEquals(POSITIVE_STATE, dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void dummyShouldNotGrantExperienceIfIsStillAlive() {

        dummy.giveExperience();
    }
}
