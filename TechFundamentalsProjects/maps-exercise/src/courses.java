import java.util.*;

public class courses {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Map<String, List<String>> courseSchedule = new LinkedHashMap<>();

        String line = console.nextLine();

        while (!line.equals("end")) {
            String[] input = line.split(" : ");

            String courseName = input[0];
            String studentName = input[1];

            courseSchedule.putIfAbsent(courseName, new ArrayList<>());
            courseSchedule.get(courseName).add(studentName);

            line = console.nextLine();
        }

        courseSchedule.entrySet().stream().sorted((value1, value2) -> {
            int length1 = value1.getValue().size();
            int length2 = value2.getValue().size();

            return Integer.compare(length2, length1);
        }).forEach(key -> {
            int length = key.getValue().size();
            System.out.print(key.getKey() + ": ");
            System.out.println(length);

            List<String> toPrint = courseSchedule.get(key.getKey());
            Collections.sort(toPrint);
            toPrint.forEach(e -> {System.out.print("-- ");
                System.out.println(e);});
        });





    }
}
