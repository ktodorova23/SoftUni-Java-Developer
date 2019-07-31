import java.util.*;

import static java.lang.Double.*;

public class studentAcademy {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        Map<String, List<Double>> grades = new LinkedHashMap<>();
        Map<String, Double> avgGrades = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String name = console.nextLine();
            double grade = parseDouble(console.nextLine());

            grades.putIfAbsent(name, new ArrayList<>());
            avgGrades.putIfAbsent(name, 0d);
            grades.get(name).add(grade);
        }

        for (Map.Entry<String, List<Double>> addStudentGrade:grades.entrySet()) {
            List<Double> allGrades = addStudentGrade.getValue();

            double avgGrade = 0;

            for (int i = 0; i < allGrades.size(); i++) {
                avgGrade += allGrades.get(i) / allGrades.size();
            }

            if (avgGrade >= 4.50) {
                avgGrades.put(addStudentGrade.getKey(), avgGrade);
            } else {
                avgGrades.remove(addStudentGrade.getKey());
            }
        }

        avgGrades.entrySet().stream().sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue())).forEach(m -> {
            System.out.print(m.getKey() + " -> ");
            System.out.printf("%.2f%n", m.getValue());
        });
    }
}
