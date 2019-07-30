import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ashesOfRoses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("^Grow <([A-Z][a-z]+)> <([A-Za-z0-9]+)> (\\d+)$");

        TreeMap<String, TreeMap<String, Long>> regions = new TreeMap<>();
        TreeMap<String, Long> roses = new TreeMap<>();

        String line;
        while (!"Icarus, Ignite!".equals(line = reader.readLine())) {
            Matcher matcher = pattern.matcher(line);
            String region = "";
            String color = "";
            long amount = 0;

            if (matcher.find()) {
                region = matcher.group(1);
                color = matcher.group(2);
                amount = Long.parseLong(matcher.group(3));

                if (regions.containsKey(region)) {
                    if (regions.get(region).containsKey(color)) {
                        regions.get(region).put(color, regions.get(region).get(color) + amount);
                    } else {
                        regions.get(region).put(color, amount);
                    }
                    roses.put(region, roses.get(region) + amount);
                } else {
                    regions.put(region, new TreeMap<>());
                    regions.get(region).put(color, amount);
                    roses.put(region, amount);
                }
            }
        }

        roses.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(r -> {
                    System.out.println(r.getKey());
                    regions.get(r.getKey()).entrySet().stream()
                            .sorted(Map.Entry.comparingByValue())
                            .forEach(e -> System.out.println("*--" + e.getKey() + " | " + e.getValue()));
                });
    }
}
