import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class softuniCoursePlanning {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<String> courses = Arrays.stream(console.nextLine()
                .split(", "))
                .collect(Collectors.toList());

        String line = console.nextLine();

        while (!line.equals("course start")) {
            String[] tokens = line.split(":");
            String command = tokens[0];
            String lessonTitle = tokens[1];

            boolean existingCourse = courses.contains(lessonTitle);

            switch (command) {
                case "Add":
                    if (!existingCourse) {
                        courses.add(lessonTitle);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[2]);

                    if (!existingCourse) {
                        courses.add(index, lessonTitle);
                    }
                    break;
                case "Remove":
                    if (existingCourse) {
                        courses.remove(lessonTitle);
                    }
                    if (courses.contains(lessonTitle + "-Exercise")) {
                        courses.remove(lessonTitle + "-Exercise");
                    }
                    break;
                case "Swap":
                    if (existingCourse && courses.contains(tokens[2])) {
                        int indexOfFirstCourse = courses.indexOf(lessonTitle);
                        int indexOfSecondCourse = courses.indexOf(tokens[2]);

                        courses.remove(lessonTitle);
                        courses.remove(tokens[2]);

                        boolean containslessonTitleExer = courses.contains(lessonTitle + "-Exercise");
                        boolean containsToken2Exer = courses.contains(tokens[2] + "-Exercise");

                        if (containslessonTitleExer) {
                            courses.remove(lessonTitle + "-Exercise");
                        }
                        if (containsToken2Exer) {
                            courses.remove(tokens[2] + "-Exercise");
                        }
                        if (indexOfFirstCourse < indexOfSecondCourse) {
                            courses.add(indexOfFirstCourse, tokens[2]);
                            courses.add(indexOfSecondCourse, lessonTitle);
                        } else {
                            courses.add(indexOfSecondCourse, lessonTitle);
                            courses.add(indexOfFirstCourse, tokens[2]);
                        }

                        if (containslessonTitleExer) {
                            courses.add(indexOfSecondCourse + 1, lessonTitle + "-Exercise");
                        }
                        if (containsToken2Exer) {
                            courses.add(indexOfFirstCourse + 1, tokens[2] + "-Exercise");
                        }
                    }
                    break;
                case "Exercise":
                    if (existingCourse) {
                        if (!courses.contains(lessonTitle + "-Exercise")) {
                            int indexOfCourse = courses.indexOf(lessonTitle);

                            courses.add(indexOfCourse + 1, lessonTitle + "-Exercise");
                        }
                    } else {
                        courses.add(lessonTitle);
                        courses.add(lessonTitle + "-Exercise");
                    }
                    break;

            }

            line = console.nextLine();
        }

        for (int i = 0; i <= courses.size() - 1; i++) {
            System.out.println((i + 1) + "." + courses.get(i));
        }
    }
}
