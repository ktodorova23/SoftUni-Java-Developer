package pokemonTrainer;

import java.util.ArrayList;

public class Trainer {
    private String name;
    private int badges;
    private ArrayList<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.badges = 0;
    }

    public String getName() {
        return name;
    }

    public int getBadges() {
        return badges;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void hasPokemonOfTheRequiredElement(String element) {
        boolean hasPokemon = false;
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getElement().equals(element)) {
                this.badges++;
                hasPokemon = true;
                break;
            }
        }

        if (!hasPokemon) {
            for (Pokemon pokemon : pokemons) {
                pokemon.setHealth(pokemon.getHealth() - 10);
            }

        }
        pokemons.removeIf(pokemon -> pokemon.getHealth() <= 0);
    }
}
