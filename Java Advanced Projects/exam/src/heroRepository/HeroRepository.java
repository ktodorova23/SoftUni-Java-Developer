package heroRepository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class HeroRepository {
    private Map<String, Hero> data;

    public HeroRepository() {
        this.data = new LinkedHashMap<>();
    }

    public void add(Hero hero) {
        this.data.put(hero.getName(), hero);
    }

    public void remove(String name) {
        this.data.remove(name);
    }

    public Hero getHeroWithHighestStrength() {
        int highestStrength = Integer.MIN_VALUE;
        Hero hero = null;

        for (Map.Entry<String, Hero> entry : data.entrySet()) {
            if (this.data.get(entry.getKey()).getItem().getStrength() > highestStrength) {
                highestStrength = this.data.get(entry.getKey()).getItem().getStrength();
                hero = entry.getValue();
            }
        }
        return hero;
    }

    public Hero getHeroWithHighestAgility() {
        int highestAgility = Integer.MIN_VALUE;
        Hero hero = null;

        for (Map.Entry<String, Hero> entry : data.entrySet()) {
            if (this.data.get(entry.getKey()).getItem().getAgility() > highestAgility) {
                highestAgility = this.data.get(entry.getKey()).getItem().getAgility();
                hero = entry.getValue();
            }
        }
        return hero;
    }

    public Hero getHeroWithHighestIntelligence() {
        int highestIntelligence = Integer.MIN_VALUE;
        Hero hero = null;

        for (Map.Entry<String, Hero> entry : data.entrySet()) {
            if (this.data.get(entry.getKey()).getItem().getIntelligence() > highestIntelligence) {
                highestIntelligence = this.data.get(entry.getKey()).getItem().getIntelligence();
                hero = entry.getValue();
            }
        }
        return hero;
    }

    public int getCount() {
        return this.data.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Hero> entry : data.entrySet()) {
            sb.append(entry.getValue().toString());
        }
        return sb.toString();
    }
}
