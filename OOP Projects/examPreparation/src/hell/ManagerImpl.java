package hell;

import hell.entities.heroes.Assassin;
import hell.entities.heroes.Barbarian;
import hell.entities.heroes.Wizard;
import hell.entities.items.CommonItem;
import hell.entities.items.RecipeItem;
import hell.interfaces.Hero;
import hell.interfaces.Manager;

import java.util.*;
import java.util.stream.Collectors;

public class ManagerImpl implements Manager {
    private Map<String, Hero> heroes;

    public ManagerImpl() {
        this.heroes = new LinkedHashMap<>();
    }

    @Override
    public String addHero(List<String> arguments) {
        Hero hero = null;
        if (arguments.get(1).equals("Barbarian")) {
            hero = new Barbarian(arguments.get(0));
        } else if (arguments.get(1).equals("Assassin")) {
            hero = new Assassin(arguments.get(0));
        } else {
            hero = new Wizard(arguments.get(0));
        }

        this.heroes.putIfAbsent(arguments.get(0), hero);
        return String.format("Created %s - %s", arguments.get(1), arguments.get(0));
    }

    @Override
    public String addItem(List<String> arguments) {
        this.heroes.get(arguments.get(1)).addItem(new CommonItem(arguments.get(0),
                Integer.parseInt(arguments.get(2)),
                Integer.parseInt(arguments.get(3)),
                Integer.parseInt(arguments.get(4)),
                Integer.parseInt(arguments.get(5)),
                Integer.parseInt(arguments.get(6))));
        return String.format("Added item - %s to Hero - %s", arguments.get(0),
                arguments.get(1));
    }

    @Override
    public String addRecipe(List<String> arguments) {
        List<String> requiredItems = arguments
                .stream()
                .skip(7)
                .collect(Collectors.toList());

        this.heroes.get(arguments.get(1)).addRecipe(new RecipeItem(arguments.get(0),
                Integer.parseInt(arguments.get(2)),
                Integer.parseInt(arguments.get(3)),
                Integer.parseInt(arguments.get(4)),
                Integer.parseInt(arguments.get(5)),
                Integer.parseInt(arguments.get(6)),
                requiredItems));
        return String.format("Added recipe - %s to Hero - %s", arguments.get(0),
                arguments.get(1));
    }

    @Override
    public String inspect(List<String> arguments) {
        Hero hero = this.heroes.get(arguments.get(0));

        String itemsString = hero.getItems().isEmpty() ? " None" : "\n";
        List<String> itemsStringsIterable = hero.getItems().stream().map(Object::toString).collect(Collectors.toList());

        itemsString += String.join("\n", itemsStringsIterable);

        return String.format("Hero: %s, Class: %s\n" +
                        "HitPoints: %d, Damage: %d\n" +
                        "Strength: %d\n" +
                        "Agility: %d\n" +
                        "Intelligence: %d\n" +
                        "Items:%s",
                hero.getName(), hero.getClass().getSimpleName(),
                hero.getHitPoints(), hero.getDamage(),
                hero.getStrength(),
                hero.getAgility(),
                hero.getIntelligence(),
                itemsString);
    }

    @Override
    public String quit() {
        HeroComparator comparator = new HeroComparator();
        List<Hero> orderedHeroes = this.heroes
                .values()
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();

        int index = 1;
        for (Hero hero : orderedHeroes) {
            sb.append(index++).append(". ").append(hero.toString());
        }
        return sb.toString();
    }
}
