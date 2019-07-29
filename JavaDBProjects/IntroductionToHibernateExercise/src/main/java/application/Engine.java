package application;

import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.rmi.server.ObjID;
import java.util.Arrays;
import java.util.List;

public class Engine implements Runnable {
    private EntityManager entityManager;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        /* 2.	Remove Objects */
//        this.removeObjects();
        /* 3.	Contains Employee */
//        try {
//            this.containsEmployee(reader);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        /* 4.	Employees with Salary Over 50 000 */
//        this.extractEmployeesWithSalaryHigherThanGivenValue();
        /* 5.	Employees from Department */
//        this.extractEmployeesFromResearchDepartment();
        /* 6.	Adding a New Address and Updating Employee */
//        try {
//            this.expandAddressesAndUpdateEmployee(reader);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        /* 7.	Addresses with Employee Count */
//        this.printAddressesWithCorrespondingEmployeesCount();
        /* 8.	Get Employee with Project */
//        try {
//            this.extractProjectsByEmployeeId(reader);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        /* 9.	Find Latest 10 Projects */
//        this.findLatest10Projects();
        /* 10.	Increase Salaries */
//        this.increaseSalaries();
        /* 11.	 Remove Towns */
//        try {
            // TODO: DB needs to be dropped and imported again in order to have correct town names after lower casing them in problem 2(Remove Objects)
//            this.removeTowns(reader);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        /* 12.	Find Employees by First Name */
        // TODO: In order to get correct salaries(after problem 10), DB needs to be dropped.
//        try {
//            this.findEmployeesByFirstName(reader);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        /* 13.	Employees Maximum Salaries */
        // TODO: Same as above - drop DB and load the data again...
//        this.employeesMaximumSalaries();
    }

    /* 2.	Remove Objects */
    private void removeObjects() {
        this.entityManager.getTransaction().begin();
        List<Town> allTowns = this.entityManager
                .createQuery("FROM Town", Town.class)
                .getResultList();

        allTowns.forEach(t -> {
            if (t.getName().length() > 5) {
                List<Address> addressesInGivenTown = this.entityManager.createQuery("FROM Address WHERE town_id = :townId", Address.class)
                        .setParameter("townId", t.getId())
                        .getResultList();

                    if (addressesInGivenTown.size() > 0) {
                        addressesInGivenTown.forEach(a -> a.setTown(null));
                    }
                this.entityManager.remove(t);
            } else {

                t.setName(t.getName().toLowerCase());
            }
        });


        this.entityManager.flush();
        this.entityManager.getTransaction().commit();
    }

    /* 3.	Contains Employee */
    private void containsEmployee(BufferedReader reader) throws IOException {
        String employeeName = reader.readLine();
        this.entityManager.getTransaction().begin();
        try{
            Employee employee = this.entityManager
                    .createQuery("FROM Employee WHERE CONCAT(first_name, ' ', last_name) = :name", Employee.class)
                    .setParameter("name", employeeName)
                    .getSingleResult();

            System.out.println("Yes");
        }catch (NoResultException e) {
            System.out.println("No");
        }

        this.entityManager.getTransaction().commit();
    }

    /* 4.	Employees with Salary Over 50 000 */
    private void extractEmployeesWithSalaryHigherThanGivenValue() {
        List<Employee> employees = this.entityManager
                .createQuery("FROM Employee WHERE salary > 50000", Employee.class)
                .getResultList();

        for (Employee employee : employees) {
            System.out.println(employee.getFirstName());
        }
    }

    /* 5.	Employees from Department */
    private void extractEmployeesFromResearchDepartment() {
        List<Employee> employees = this.entityManager
                .createQuery("FROM Employee WHERE department_id = 6 ORDER BY salary, id", Employee.class)
                .getResultList();

        for (Employee employee : employees) {
            System.out.println(String.format("%s %s from Research and Development - $%.2f",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getSalary()));
        }
    }

    /* 6.	Adding a New Address and Updating Employee */
    private void expandAddressesAndUpdateEmployee(BufferedReader reader) throws IOException {
        String lastNameToBeUpdated = reader.readLine();

        this.entityManager.getTransaction().begin();
        Town town = this.entityManager
                .createQuery("FROM Town WHERE id = 32", Town.class)
                .getSingleResult();
        ;
        Address address = new Address();
        address.setText("Vitoshka 15");
        address.setTown(town);
        this.entityManager.persist(address);
        this.entityManager.getTransaction().commit();

        this.entityManager.getTransaction().begin();
        List<Employee> employees = this.entityManager
                .createQuery("FROM Employee WHERE last_name = :lastName", Employee.class)
                .setParameter("lastName", lastNameToBeUpdated)
                .getResultList();

        for (Employee employee : employees) {
            employee.setAddress(address);
        }
        this.entityManager.flush();
        this.entityManager.getTransaction().commit();
    }

    /* 7.	Addresses with Employee Count */
    private void printAddressesWithCorrespondingEmployeesCount() {
        List<Address> addresses = this.entityManager
                .createQuery("FROM Address ORDER BY size(employees) DESC, town_id", Address.class)
                .setMaxResults(10)
                .getResultList();

        for (Address address : addresses) {
            System.out.println(String.format("%s, %s - %s employees",
                    address.getText(),
                    address.getTown().getName(),
                    address.getEmployees().size()));
        }
    }

    /* 8.	Get Employee with Project */
    private void extractProjectsByEmployeeId(BufferedReader reader) throws IOException {
        int employeeId = Integer.parseInt(reader.readLine());

        this.entityManager.getTransaction().begin();

        Employee employee = this.entityManager.createQuery("FROM Employee WHERE employee_id = :id", Employee.class)
                .setParameter("id", employeeId)
                .getSingleResult();

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s - %s%n", employee.getFirstName(), employee.getLastName(), employee.getJobTitle()));

        String projectsQuery = "SELECT *" +
                "FROM projects AS p\n" +
                "JOIN employees_projects AS ep ON p.project_id = ep.project_id\n" +
                "WHERE ep.employee_id = ?\n" +
                "ORDER BY p.name";

        List<Project> projects = this.entityManager.createNativeQuery(projectsQuery, Project.class)
                .setParameter(1, employeeId)
                .getResultList();

        for (Project project : projects) {
            sb.append("\t").append(project.getName()).append(System.lineSeparator());
        }
        System.out.println(sb.toString());
        this.entityManager.getTransaction().commit();
    }

    /* 9.	Find Latest 10 Projects */
    private void findLatest10Projects() {
        String query = "SELECT *\n" +
                "FROM (SELECT * FROM projects as p2 ORDER BY start_date DESC LIMIT 10) AS p\n" +
                "ORDER BY name";

        List<Project> projects = this.entityManager.createNativeQuery(query, Project.class)
                .getResultList();

        StringBuilder sb = new StringBuilder();
        projects.forEach(p -> sb.append(String.format("Project name: %s%n\tProject Description: %s%n" +
                        "\tProject Start Date:%s%n\tProject End Date: %s%n",
                p.getName(),
                p.getDescription(),
                p.getStartDate(),
                p.getEndDate())));

        System.out.println(sb.toString());
    }

    /* 10.	Increase Salaries */
    private void increaseSalaries() {
        this.entityManager.getTransaction().begin();
        List<Employee> employees = this.entityManager.createQuery("FROM Employee WHERE department_id IN (1, 2, 4, 11)", Employee.class)
                .getResultList();

        employees.forEach(e -> {
            e.setSalary(e.getSalary().add(e.getSalary().multiply(new BigDecimal(0.12))));
            this.entityManager.persist(e);
        });

        this.entityManager.flush();
        employees.forEach(e -> {
            e.setSalary(e.getSalary().setScale(2, RoundingMode.HALF_UP));
            System.out.println(String.format("%s %s ($%s)",
                    e.getFirstName(),
                    e.getLastName(),
                    e.getSalary()));
        });
        this.entityManager.getTransaction().commit();
    }

    /* 11.	 Remove Towns */
    private void removeTowns(BufferedReader reader) throws IOException {
        String townToBeRemoved = reader.readLine();

        List<Town> town = this.entityManager.createQuery("FROM Town WHERE name = :townName", Town.class)
                .setParameter("townName", townToBeRemoved)
                .getResultList();

        // This verification ensures that there is such town in DB and will not throw exceptions!
        if (town != null) {
            List<Address> addressesToBeDeleted = this.entityManager.createQuery("FROM Address WHERE town_id = :townId", Address.class)
                    .setParameter("townId", town.get(0).getId())
                    .getResultList();

            //Releasing the addresses that are going to be deleted from `employees` in order to be able to remove them from the DB
            for (Address address : addressesToBeDeleted) {
                List<Employee> currentEmployees = this.entityManager.createQuery("FROM Employee WHERE address_id = :addressId", Employee.class)
                        .setParameter("addressId", address.getId())
                        .getResultList();
                if (currentEmployees.size() > 0) {
                    currentEmployees.forEach(a -> a.setAddress(null));
                }
            }

            int count = addressesToBeDeleted.size();

            this.entityManager.getTransaction().begin();

            addressesToBeDeleted.forEach(a -> this.entityManager.remove(a));
            this.entityManager.flush();

            this.entityManager.getTransaction().commit();

            this.entityManager.getTransaction().begin();
            this.entityManager.remove(town.get(0));
            this.entityManager.flush();

            this.entityManager.getTransaction().commit();

            System.out.println(String.format("%d %s in %s deleted",
                    count,
                    count == 1 ? "address" : "addresses",
                    townToBeRemoved));
        }
    }


    /* 12.	Find Employees by First Name */
    private void findEmployeesByFirstName(BufferedReader reader) throws IOException {
        String name = reader.readLine();

        List<Employee> employees = this.entityManager.createQuery("FROM Employee WHERE first_name LIKE CONCAT(:firstName, '%')", Employee.class)
                .setParameter("firstName", name)
                .getResultList();

        employees.forEach(e -> System.out.println(String.format("%s %s - %s - ($%s)",
                e.getFirstName(),
                e.getLastName(),
                e.getJobTitle(),
                e.getSalary())));
    }

    /* 13.	Employees Maximum Salaries */
    private void employeesMaximumSalaries() {
        String query = "SELECT d.name, MAX(e.salary) AS max_salary\n" +
                "FROM employees AS e\n" +
                "JOIN departments d on e.department_id = d.department_id\n" +
                "GROUP BY e.department_id\n" +
                "HAVING max_salary NOT BETWEEN 30000 AND 70000";

        List<Object[]> results = this.entityManager.createNativeQuery(query)
                .getResultList();

        for (Object[] result : results) {
            System.out.println(String.format("%s - %s",
                    result[0].toString(),
                    result[1].toString()));
        }
    }
}
