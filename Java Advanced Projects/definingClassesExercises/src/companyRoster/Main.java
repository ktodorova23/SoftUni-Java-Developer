package companyRoster;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int rows = Integer.parseInt(console.nextLine());

        HashMap<String, Department> employeesByDepartment = new HashMap<>();

        while (rows-- > 0) {
            String[] tokens = console.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String department = tokens[3];

            Employee employee = null;
            switch (tokens.length) {
                case 4:
                    employee = new Employee(name, salary);
                    break;
                case 5:
                    try {
                        int age = Integer.parseInt(tokens[4]);
                        employee = new Employee(name, salary, age);
                    } catch (NumberFormatException e) {
                        employee = new Employee(name, salary, tokens[4]);
                    }
                    break;
                default:
                    employee = new Employee(name, salary, Integer.parseInt(tokens[5]), tokens[4]);
                    break;
            }
            employeesByDepartment.putIfAbsent(department, new Department(department));
            employeesByDepartment.get(department).getEmployees().add(employee);
        }

        employeesByDepartment.entrySet().stream()
                .sorted((f, s) -> Double.compare(s.getValue().getAverage(), f.getValue().getAverage()))
                .findFirst()
                .stream()
                .forEach(e -> {
                    System.out.println(String.format("Highest Average Salary: %s", e.getKey()));
                    e.getValue().getEmployees().stream().sorted((f, s) -> Double.compare(s.getSalary(), f.getSalary()))
                            .forEach(employee -> System.out.println(String.format("%s %.2f %s %d",
                                    employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge())));
                });

    }
}
