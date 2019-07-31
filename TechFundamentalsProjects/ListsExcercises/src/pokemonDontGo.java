import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class pokemonDontGo {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<Integer> pokemons = Arrays.stream(console.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int indexToRemove = Integer.parseInt(console.nextLine());

        int sum = 0;
        while (true) {
            int number = 0;

            if (indexToRemove < 0) {
                number = pokemons.get(0);
                pokemons.remove(pokemons.get(0));
                pokemons.add(0, pokemons.get(pokemons.size() - 1));
            } else if (indexToRemove > pokemons.size() - 1) {
                number = pokemons.get(pokemons.size() - 1);
                pokemons.remove(pokemons.size() - 1);
                pokemons.add(Integer.valueOf(pokemons.get(0)));
            } else {
                number = pokemons.get(indexToRemove);
                pokemons.remove(indexToRemove);
            }

            sum += number;

            for (int i = 0; i < pokemons.size(); i++) {
                if (pokemons.get(i) <= number) {
                    pokemons.set(i, pokemons.get(i) + number);
                } else {
                    pokemons.set(i, pokemons.get(i) - number);
                }
            }

            if (pokemons.size() == 0) {
                break;
            }
            indexToRemove = Integer.parseInt(console.nextLine());
        }

        System.out.println(sum);
    }
}
