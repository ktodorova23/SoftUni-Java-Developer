package pokemonTrainer;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String line = console.nextLine();

        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();

        while (!line.equals("Tournament")) {
            String[] tokens = line.split("\\s+");

            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int health = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, health);

            if (!trainers.containsKey(trainerName)) {
            Trainer trainer = new Trainer(trainerName);
            trainer.getPokemons().add(pokemon);
            trainers.put(trainerName, trainer);
            } else {
                trainers.get(trainerName).getPokemons().add(pokemon);
            }
            line = console.nextLine();
        }

        line = console.nextLine();

        while (!line.equals("End")) {
            for (Map.Entry<String, Trainer> trainer : trainers.entrySet()) {
                trainer.getValue().hasPokemonOfTheRequiredElement(line);
            }
            line = console.nextLine();
        }

        trainers.entrySet().stream()
                .sorted((f, s) -> Integer.compare(s.getValue().getBadges(), f.getValue().getBadges()))
                .forEach(e -> System.out.println(e.getKey() + " " + e.getValue().getBadges() + " " + e.getValue().getPokemons().size()));
    }
}
