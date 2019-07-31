import java.util.*;

public class orderByAge {

    static class Person {
        String name;
        String ID;
        int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Person(String name, String ID, int age) {
            this.name = name;
            this.ID = ID;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String line = console.nextLine();

        List<Person> people = new ArrayList<>();

        while (!line.equals("End")) {
            String[] data = line.split("\\s+");

            String name = data[0];
            String ID = data[1];
            int age = Integer.parseInt(data[2]);

            Person person = new Person(name, ID, age);
            people.add(person);

            line = console.nextLine();
        }

        people.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .forEach(p -> System.out.printf("%s with ID: %s is %d years old.%n", p.getName(), p.getID(), p.getAge()));
    }
}
