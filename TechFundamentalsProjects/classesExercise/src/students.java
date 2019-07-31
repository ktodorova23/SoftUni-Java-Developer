import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class students {

    static class Student {
        String firstName;
        String lastName;
        double grade;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public double getGrade() {
            return grade;
        }

        public void setGrade(double grade) {
            this.grade = grade;
        }

        public Student(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int rows = Integer.parseInt(console.nextLine());

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            String[] line = console.nextLine().split("\\s+");

            String firstName = line[0];
            String lastName = line[1];
            double grade = Double.parseDouble(line[2]);

            Student student = new Student(firstName, lastName, grade);

            students.add(student);
        }

        students.stream().sorted((e1, e2) -> Double.compare(e2.getGrade(), e1.getGrade())).forEach(e -> System.out.printf("%s %s: %.2f%n", e.getFirstName(), e.getLastName(), e.getGrade()));
    }
}
