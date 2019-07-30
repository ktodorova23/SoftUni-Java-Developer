import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class DHARMAInitiative {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, String> messagesByStation = new HashMap<>();
        messagesByStation.put("Hydra", "Zoological Research.");
        messagesByStation.put("Arrow", "Development of defensive strategies, and Intelligence gathering.");
        messagesByStation.put("Flame", "Communication.");
        messagesByStation.put("Pearl", "Psychological Research and/or Observation.");
        messagesByStation.put("Orchid", "Space-time manipulation research, disguised as a Botanical station.");

        HashMap<String, HashMap<String, Integer>> peopleAndNumbersByStation = new HashMap<>();
        HashMap<String, Integer> countOfRecruitsByStation = new HashMap<>();
        for (Map.Entry<String, String> entry : messagesByStation.entrySet()) {
            peopleAndNumbersByStation.put(entry.getKey(), new HashMap<>());
            countOfRecruitsByStation.put(entry.getKey(), 0);
        }


        String line;

        while (!"Recruit".equals(line = reader.readLine())) {
            String[] tokens = line.split(":");
            String personName = tokens[0];
            int facilityNumber = Integer.parseInt(tokens[1]);
            String stationName = tokens[2];

            if (peopleAndNumbersByStation.containsKey(stationName)) {
                peopleAndNumbersByStation.get(stationName).put(personName, facilityNumber);
                countOfRecruitsByStation.put(stationName, countOfRecruitsByStation.get(stationName) + 1);
            }
        }

        line = reader.readLine();

        if (line.equals("DHARMA Initiative")) {
            countOfRecruitsByStation.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                            .thenComparing(Map.Entry.comparingByKey()))
                    .forEach(entry ->
                            System.out.println(String.format("The %s has %d DHARMA recruits in it.", entry.getKey(), entry.getValue())));
        } else {
            if (peopleAndNumbersByStation.containsKey(line)) {
                System.out.println(String.format("The %s station: %s", line, messagesByStation.get(line)));
                if (countOfRecruitsByStation.get(line) > 0) {
                    peopleAndNumbersByStation.get(line).entrySet().stream()
                            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                            .forEach(e -> System.out.println(String.format("###%s - %s", e.getKey(), e.getValue())));
                } else {
                    System.out.println("No recruits.");
                }
            } else {
                System.out.println("DHARMA Initiative does not have such a station!");
            }
        }

    }
}
