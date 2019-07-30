package hell;

import hell.entities.heroes.Assassin;
import hell.entities.heroes.Barbarian;
import hell.entities.heroes.Wizard;
import hell.entities.items.CommonItem;
import hell.entities.items.RecipeItem;
import hell.interfaces.Hero;
import hell.interfaces.Manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Manager manager = new ManagerImpl();

        String line;
        while (!"Quit".equals(line = reader.readLine())) {
            List<String> cmdArgs = Arrays.stream(line.split("\\s+")).collect(Collectors.toList());


            switch (cmdArgs.get(0)) {
                case "Hero":
                    System.out.println(manager.addHero(cmdArgs.stream().skip(1).collect(Collectors.toList())));
                    break;
                case "Item":
                    System.out.println(manager.addItem(cmdArgs.stream().skip(1).collect(Collectors.toList())));
                    break;
                case "Recipe":
                    System.out.println(manager.addRecipe(cmdArgs.stream().skip(1).collect(Collectors.toList())));
                    break;
                case "Inspect":
                    System.out.println(manager.inspect(cmdArgs.stream().skip(1).collect(Collectors.toList())));
                    break;
            }
        }

        System.out.println(manager.quit());
    }
}