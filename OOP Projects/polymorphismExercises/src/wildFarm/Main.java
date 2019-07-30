package wildFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] animals) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Animal> animalList = new ArrayList<>();

        String line;
        int countRows = 0;
        while (!"End".equals(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");
            if (countRows % 2 == 0) {
                Animal animal = null;
                if (tokens[0].equals("Mouse")) {
                    animal = new Mouse(tokens[1], Double.parseDouble(tokens[2]), tokens[3]);
                } else if (tokens[0].equals("Cat")) {
                    animal = new Cat(tokens[1], Double.parseDouble(tokens[2]), tokens[3], tokens[4]);
                } else if (tokens[0].equals("Tiger")) {
                    animal = new Tiger(tokens[1], Double.parseDouble(tokens[2]), tokens[3]);
                } else {
                    animal = new Zebra(tokens[1], Double.parseDouble(tokens[2]), tokens[3]);
                }
                animalList.add(animal);
                System.out.println(animal.makeSound());
            } else {
                Food food = null;
                if (tokens[0].equals("Vegetable")) {
                    food = new Vegetable(Integer.parseInt(tokens[1]));
                } else {
                    food = new Meat((Integer.parseInt(tokens[1])));
                }

                try {
                    animalList.get(animalList.size() - 1).eatFood(food);
                }catch (IllegalArgumentException error) {
                    System.out.println(error.getMessage());
                }
            }

            countRows++;
        }

        for (Animal animal : animalList) {
            System.out.println(animal.toString());
        }
    }
}
