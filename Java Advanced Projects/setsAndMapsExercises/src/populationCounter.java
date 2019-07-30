import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class populationCounter {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String line = console.nextLine();

        LinkedHashMap<String, LinkedHashMap<String, Long>> citiesAndPopulationByCountry = new LinkedHashMap<>();
        LinkedHashMap<String, Long> populationByCountry = new LinkedHashMap<>();

        while (!line.equals("report")) {
            String[] tokens = line.split("\\|");

            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            citiesAndPopulationByCountry.putIfAbsent(country, new LinkedHashMap<>());
            citiesAndPopulationByCountry.get(country).putIfAbsent(city, population);
            populationByCountry.putIfAbsent(country, 0L);
            populationByCountry.put(country, populationByCountry.get(country) + population);
            line = console.nextLine();
        }

        populationByCountry.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(e -> {
                    String currentCountry = e.getKey();
                    System.out.println(currentCountry + " (total population: " + e.getValue() + ")");
                    citiesAndPopulationByCountry.get(currentCountry).entrySet().stream()
                            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                            .forEach(c -> {
                                System.out.println("=>" + c.getKey() + ": " + c.getValue());
                            });
                        }
                );

    }
}
