import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class hospital {
    public static class Department {
        private String name;
        private TreeMap<Integer, TreeSet<String>> rooms;
        private LinkedHashSet<String> patients;

        public Department(String name) {
            this.name = name;
            this.rooms = new TreeMap<>();
            rooms.put(1, new TreeSet<>());
            this.patients = new LinkedHashSet<>();
        }

        public void setRooms(String patientName) {
            int maxRoom = this.rooms.size();

            if (this.rooms.get(maxRoom).size() == 3) {
                if(maxRoom < 20) {
                    this.rooms.put(maxRoom + 1, new TreeSet<>());
                    this.rooms.get(maxRoom + 1).add(patientName);
                }
            } else {
                this.rooms.get(maxRoom).add(patientName);
            }
        }

        public Map<Integer, TreeSet<String>> getRooms() {
            return this.rooms;
        }

        public LinkedHashSet<String> getPatients() {
            return this.patients;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, TreeSet<String>> patientsByDoctor = new HashMap<>();
        LinkedHashMap<String, Department> departments = new LinkedHashMap<>();

        String line;
        while (!"Output".equals(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");
            String department = tokens[0];
            String doctorsName = tokens[1] + " " + tokens[2];
            String patientsName = tokens[3];

            Department dep = null;
            if (departments.containsKey(department)) {
                dep = departments.get(department);
            } else {
                dep = new Department(department);
                departments.putIfAbsent(department, dep);
            }
            dep.setRooms(patientsName);
            dep.getPatients().add(patientsName);
            patientsByDoctor.putIfAbsent(doctorsName, new TreeSet<>());
            patientsByDoctor.get(doctorsName).add(patientsName);
        }

        String input = reader.readLine();
        while (!"End".equals(input)) {
            if (input.contains(" ")) {
                String[] tokens = input.split("\\s+");
                try {
                    int roomNumber = Integer.parseInt(tokens[1]);
                    departments.get(tokens[0]).getRooms().get(roomNumber).forEach(System.out::println);
                } catch (Exception e) {
                    patientsByDoctor.get(tokens[0] + " " + tokens[1]).forEach(System.out::println);
                }
            } else {
                departments.get(input).getPatients().forEach(System.out::println);
            }
            input = reader.readLine();
        }
    }
}
