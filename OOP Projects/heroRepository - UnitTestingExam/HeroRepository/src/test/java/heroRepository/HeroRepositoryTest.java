package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroRepositoryTest {
    private HeroRepository repository;

    @Before
    public void setRepository() {
        this.repository = new HeroRepository();
    }

    @Test(expected = IllegalArgumentException.class)
    public void addShouldThrowAnExceptionIfDuplicateIsAdded() {
        Item item = new Item(5, 5, 5);
        Hero hero = new Hero("Pesho", 3, item);
        this.repository.add(hero);
        this.repository.add(hero);
    }

    @Test
    public void addShouldIncreaseTheSizeOfTheRepository() {
        for (int i = 0; i < 3; i++) {
            Item item = new Item(5, 5, 5);
            Hero hero = new Hero("Pesho" + i,3, item);
            this.repository.add(hero);
        }
        Assert.assertEquals(3, this.repository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void removeShouldThrowAnExceptionIfListIsEmpty() {
        this.repository.remove("Ivan");
    }

    @Test(expected = NullPointerException.class)
    public void removeShouldThrowAnExceptionIfHeroIsNotPresent() {
        Item item = new Item(5, 5, 5);
        Hero hero = new Hero("Pesho", 3, item);
        this.repository.add(hero);
        this.repository.remove("Ivan");
    }

    @Test
    public void removeShouldReduceTheSizeOfTheRepositoryWhenSuccessful(){
        for (int i = 0; i < 3; i++) {
            Item item = new Item(5, 5, 5);
            Hero hero = new Hero("Pesho" + i,3, item);
            this.repository.add(hero);
        }
        this.repository.remove("Pesho0");
        Assert.assertEquals(2, this.repository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestStrengthShouldThrowAnExceptionIfListIsEmpty() {
        this.repository.getHeroWithHighestStrength();
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestStrengthShouldThrowAnExceptionIfNoSuchHeroIsFound() {
        Item item2 = new Item(-1, 2, 2);
        Hero hero2 = new Hero("Ivan", 2, item2);
        this.repository.getHeroWithHighestStrength();
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestIntelligenceShouldThrowAnExceptionIfNoSuchHeroIsFound() {
        Item item2 = new Item(15, 2, -2);
        Hero hero2 = new Hero("Ivan", 2, item2);
        this.repository.getHeroWithHighestIntelligence();
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestAgilityShouldThrowAnExceptionIfNoSuchHeroIsFound() {
        Item item2 = new Item(10, -2, 2);
        Hero hero2 = new Hero("Ivan", 2, item2);
        this.repository.getHeroWithHighestAgility();
    }

    @Test
    public void getHeroWithHighestStrengthShouldReturnHeroCorectly() {
        Hero hero = null;
        for (int i = 0; i < 3; i++) {
            Item item = new Item(5 + i, 5, 5);
            hero = new Hero("Pesho" + i,3, item);
            this.repository.add(hero);
        }

        Assert.assertEquals(hero, this.repository.getHeroWithHighestStrength());
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestAgilityShouldThrowAnExceptionIfListIsEmpty() {
        this.repository.getHeroWithHighestAgility();
    }

    @Test
    public void getHeroWithHighestAgilityShouldReturnHeroCorectly() {
        Hero hero = null;
        for (int i = 0; i < 3; i++) {
            Item item = new Item(5, 5 + i, 5);
            hero = new Hero("Pesho" + i,3, item);
            this.repository.add(hero);
        }
        Assert.assertEquals(hero, this.repository.getHeroWithHighestAgility());
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestIntelligenceShouldThrowAnExceptionIfListIsEmpty() {
        this.repository.getHeroWithHighestIntelligence();
    }

    @Test
    public void getHeroWithHighestIntelligenceShouldReturnHeroCorectly() {
        Hero hero = null;
        for (int i = 0; i < 3; i++) {
            Item item = new Item(5, 5, 5 + i);
            hero = new Hero("Pesho" + i,3, item);
            this.repository.add(hero);
        }
        Assert.assertEquals(hero, this.repository.getHeroWithHighestIntelligence());
    }


}