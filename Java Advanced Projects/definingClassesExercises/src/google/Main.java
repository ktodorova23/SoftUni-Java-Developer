package google;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String line = console.nextLine();

        LinkedHashMap<String, Person> people = new LinkedHashMap<>();

        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");
            String name = tokens[0];
            String info = tokens[1];

            Person person = null;
            if (!people.containsKey(name)) {
            person = new Person(name);
            people.put(name, person);
            } else {
                person = people.get(name);
            }
            switch (info) {
                case "company":
                    Company company = new Company(tokens[2], tokens[3], Double.parseDouble(tokens[4]));
                    person.setCompany(company);
                    break;
                case "pokemon":
                    Pokemon pokemon = new Pokemon(tokens[2], tokens[3]);
                    person.getPokemons().add(pokemon);
                    break;
                case "parents":
                    Parents parent = new Parents(tokens[2], tokens[3]);
                    person.getParents().add(parent);
                    break;
                case "children":
                    Child child = new Child(tokens[2], tokens[3]);
                    person.getChildren().add(child);
                    break;
                case "car":
                    Car car = new Car(tokens[2], Integer.parseInt(tokens[3]));
                    person.setCar(car);
                    break;
            }

            line = console.nextLine();
        }

        line = console.nextLine();

        people.get(line).printInfo();

    }
}
