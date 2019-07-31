import java.util.*;
import java.util.stream.Collectors;

public class softUniExamResults {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String line = console.nextLine();

        Map<String, Integer> languages = new LinkedHashMap<>();
        Map<String, Integer> results = new LinkedHashMap<>();

        while (!line.equals("exam finished")) {
            List<String> tokens = Arrays.stream(line.split("-")).collect(Collectors.toList());

            String participant = tokens.get(0);
            if (!tokens.get(1).equals("banned")) {
                String language = tokens.get(1);
                int points = Integer.parseInt(tokens.get(2));

                languages.putIfAbsent(language, 0);
                languages.put(language, languages.get(language) + 1);
                if (!results.containsKey(participant)) {
                    results.put(participant, points);
                } else if (results.get(participant) < points){
                    results.put(participant, points);

                }
                if (results.containsKey(participant) && points < results.get(participant)) {
                }
            } else {
                results.put(participant, 0);
            }

            line = console.nextLine();
        }

        System.out.println("Results: ");
        results.entrySet().stream()
                .filter(key -> key.getValue() > 0)
                .sorted((e1, e2) -> {
                    int comparison = e2.getValue().compareTo(e1.getValue());

                    if (comparison == 0) {
                        return e1.getKey().compareTo(e2.getKey());
                    }
                    return comparison;
                })
                .forEach(key -> {
            System.out.println(key.getKey() + " | " + key.getValue());
        });
        System.out.println("Submissions: ");
        languages.entrySet().stream().sorted((e1, e2) -> {
            int comparison = Integer.compare(e2.getValue(), e1.getValue());

            if (comparison == 0) {
                return e1.getKey().compareTo(e2.getKey());
            }
            return comparison;
        }).forEach(key -> System.out.println(key.getKey() + " - " + key.getValue()));
    }
}
