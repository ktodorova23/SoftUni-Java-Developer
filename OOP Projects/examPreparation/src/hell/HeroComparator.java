package hell;

import hell.interfaces.Hero;

import java.util.Comparator;

public class HeroComparator implements Comparator<Hero> {
    @Override
    public int compare(Hero first, Hero second) {
        long secondStats = second.getAgility() + second.getStrength() + second.getIntelligence();
        long firstStats = first.getAgility() + first.getStrength() + first.getIntelligence();

        int result = Long.compare(secondStats, firstStats);

        if (result == 0) {
            secondStats = second.getHitPoints() + second.getDamage();
            firstStats = first.getHitPoints() + first.getDamage();

            result = Long.compare(secondStats, firstStats);
        }
        return result;
    }
}
