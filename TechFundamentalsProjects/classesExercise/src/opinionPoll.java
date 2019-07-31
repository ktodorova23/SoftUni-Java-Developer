import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class opinionPoll {

    static class Person {
        String name;
        int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int rows = Integer.parseInt(console.nextLine());

        List<Person> people = new ArrayList<>();
        
        for (int i = 0; i < rows; i++) {
            String[] line = console.nextLine().split("\\s+");
            
            String name = line[0];
            int age = Integer.parseInt(line[1]);
            
            Person person = new Person(name, age);
            
            people.add(person);
        }

        people.stream().filter(p -> p.getAge() > 30).sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).forEach(per -> System.out.printf("%s - %d%n", per.getName(), per.getAge()));
    }
}
