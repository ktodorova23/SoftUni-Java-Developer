package comparingObjects;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<Person> peopleByEquality = new TreeSet<>();
        HashSet<Person> peopleByHash = new HashSet<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] tokens= scanner.nextLine().split("\\s+");

            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));
            peopleByEquality.add(person);
            peopleByHash.add(person);
        }

        System.out.println(peopleByEquality.size());
        System.out.println(peopleByHash.size());
    }
}
