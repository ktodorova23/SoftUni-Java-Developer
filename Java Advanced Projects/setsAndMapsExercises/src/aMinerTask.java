import java.util.LinkedHashMap;
import java.util.Scanner;

public class aMinerTask {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String line = console.nextLine();

        LinkedHashMap<String, Integer> quantityByResources = new LinkedHashMap<>();

        int count = 0;
        String lastResource = "";

        while (!line.equals("stop")) {
            count++;
            if (count % 2 != 0) {
                quantityByResources.putIfAbsent(line, 0);
                lastResource = line;
            } else {
                quantityByResources.put(lastResource, quantityByResources.get(lastResource) + Integer.parseInt(line));
            }

            line = console.nextLine();
        }

        quantityByResources.entrySet().stream().forEach(k -> System.out.println(k.getKey() + " -> " + k.getValue()));
    }
}
