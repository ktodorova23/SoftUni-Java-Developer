//import java.util.ArrayList;
//        import java.util.List;
//        import java.util.Scanner;
//
//public class students {
//
//    public static class Student {
//        private String firstName;
//        private String lastName;
//        private int age;
//        private String homeTown;
//
//        public String getFirstName() {
//            return firstName;
//        }
//
//        public void setFirstName(String firstName) {
//            this.firstName = firstName;
//        }
//
//        public String getLastName() {
//            return lastName;
//        }
//
//        public void setLastName(String lastName) {
//            this.lastName = lastName;
//        }
//
//        public int getAge() {
//            return age;
//        }
//
//        public void setAge(int age) {
//            this.age = age;
//        }
//
//        public String getHomeTown() {
//            return homeTown;
//        }
//
//        public void setHomeTown(String homeTown) {
//            this.homeTown = homeTown;
//        }
//
//        private Student(String firstName, String lastName, int age, String homeTown) {
//            this.firstName = firstName;
//            this.lastName = lastName;
//            this.age = age;
//            this.homeTown = homeTown;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner console = new Scanner(System.in);
//
//        String line = console.nextLine();
//
//        List<Student> students = new ArrayList<>();
//
//        while (!line.equals("end")) {
//            String[] tokens = line.split("\\s+");
//
//            String firstName = tokens[0];
//            String lastName = tokens[1];
//            int age = Integer.parseInt(tokens[2]);
//            String homeTown = tokens[3];
//
//            Student student = new Student(firstName, lastName, age, homeTown);
//
//            students.add(student);
//
//            line = console.nextLine();
//        }
//
//        String town = console.nextLine();
//
//        students.stream()
//                .filter(e -> e.getHomeTown().equals(town))
//                .forEach(el -> System.out.printf("%s %s is %d years old%n", el.getFirstName(), el.getLastName(), el.getAge()));
//    }
//}
