package repository;

import interfaces.Guild;
import interfaces.Hero;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.TreeMap;


public class GuildImpl implements Guild {
    private Map<String, Hero> heroes;
    private String name;

    //TODO add Comparator: heroes should be sorted by their total points in descending order.
    // If two or more heroes have the same total points sort them alphabetically by their name.
    public GuildImpl(String name) {
        this.heroes = new TreeMap<>();
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String addHero(Hero hero) {
        String result = "";
        if (!this.heroes.containsKey(hero.getName())) {
            this.heroes.put(hero.getName(), hero);
            result = "Added hero: " + hero.getName();
        } else {
            if (hero.getTotalPoints() > this.heroes.get(hero.getName()).getTotalPoints()) {
                this.heroes.put(hero.getName(), hero);
                result = "Updated hero: " + hero.getName();
            } else {
                result = String.format("Hero %s can not be replaced by a weaker one.", hero.getName());
            }
        }
        return result;
    }

    @Override
    public String removeHero(Hero hero) {
        //TODO: Check if neccessary to check explicidly if the hero exists in the guild collection
        this.heroes.remove(hero.getName());
        return String.format("Successfully removed hero [%s] from guild %s",
                hero.getName(), this.name);
    }

    @Override
    public Hero getHeroByName(String heroName) {
        //TODO need to check for availability?
        Hero hero = this.heroes.get(heroName);
        return hero;
    }

    @Override
    public Long getGuildSize() {
        return (long) this.heroes.size();
    }

    //TODO: Should check if it formats correctly!!!
    @Override
    public double getGuildPower() {
        double sum = 0;
        for (Map.Entry<String, Hero> hero : this.heroes.entrySet()) {
            sum += hero.getValue().getTotalPoints();
        }

        DecimalFormat df = new DecimalFormat("#.00");
        sum = Double.valueOf(df.format(sum));
        return sum;
    }

    @Override
    public String getGuildSpecialization() {
        String guildName = "";
        int countStrengthSigns = 0;
        int strengthTotalPoints = 0;
        int countEnduranceSigns = 0;
        int enduranceTotalPoints = 0;
        int countWillpowerSigns = 0;
        int willpowerTotalPoints = 0;

        for (Hero hero : this.heroes.values()) {
            if (hero.getBirthSign().equals("Strength")) {
                countStrengthSigns++;
                strengthTotalPoints += hero.getTotalPoints();
            } else if (hero.getBirthSign().equals("Endurance")) {
                countEnduranceSigns++;
                enduranceTotalPoints += hero.getTotalPoints();
            } else {
                countWillpowerSigns++;
                willpowerTotalPoints += hero.getTotalPoints();
            }
        }

        guildName = getString(countStrengthSigns, countEnduranceSigns, countWillpowerSigns);

        if (guildName.equals("")) {
            guildName = getString(strengthTotalPoints, enduranceTotalPoints, willpowerTotalPoints);
        }

        return guildName;
    }

    private String getString(int strength, int endurance, int willpower) {
        String result = "";
        if (strength > endurance && strength > willpower) {
            result = "Strength";
        } else if (endurance > strength && endurance > willpower) {
            result = "Endurance";
        } else if (willpower > strength && willpower > endurance) {
            result = "Willpower";
        }
        return result;
    }
}
