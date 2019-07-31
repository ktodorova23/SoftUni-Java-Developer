import java.util.*;

/**
 * Created by User on 16.12.2018 г..
 */
public class concertExam {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String line = console.nextLine();

        Map<String, List<String>> membersByBand = new LinkedHashMap<>();
        Map<String, Integer> timeByBand = new LinkedHashMap<>();

        int totalTime = 0;
        while (!line.equals("start of concert")) {
            String[] tokens = line.split("; ");
            String cmd = tokens[0];
            String bandName = tokens[1];

            switch (cmd) {
                case "Add":
                    String[] data= tokens[2].split(", ");
                    List<String> members = new ArrayList<>();

                    for (String name :
                            data) {
                        members.add(name);
                    }

                    if (!membersByBand.containsKey(bandName)) {
                        membersByBand.put(bandName, members);
                    } else {
                        for (String name :
                                members) {
                            if (!membersByBand.get(bandName).contains(name)) {
                                membersByBand.get(bandName).add(name);
                            }
                        }
                    }

                    timeByBand.putIfAbsent(bandName, 0);
                    break;
                case "Play":
                    int time = Integer.parseInt(tokens[2]);

                    if (timeByBand.containsKey(bandName)) {
                        timeByBand.put(bandName, timeByBand.get(bandName) + time);
                        totalTime += time;
                    } else {
                        timeByBand.put(bandName, time);
                        totalTime += time;
                    }
                    break;
            }

            line = console.nextLine();
        }

        System.out.println("Total time: " + totalTime);
        timeByBand.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));

        String band = console.nextLine();
        System.out.println(band);
        membersByBand.get(band).forEach(e -> System.out.println("=> " + e));
    }
}
