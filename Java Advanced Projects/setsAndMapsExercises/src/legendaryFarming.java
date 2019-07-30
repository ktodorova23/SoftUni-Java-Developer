import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class legendaryFarming {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        boolean legendaryObtained = false;

        HashMap<String, Integer> mats = new HashMap<>();
        mats.put("motes", 0);
        mats.put("fragments", 0);
        mats.put("shards", 0);
        HashMap<String, Integer> junk = new HashMap<>();

        while (true) {
            String[] line = console.nextLine().split("\\s+");

            int resource = 0;

            for (int i = 0; i < line.length; i++) {
                if (i % 2 == 0) {
                    resource = Integer.parseInt(line[i]);
                } else {
                    String currentResource = line[i].toLowerCase();
                    if (currentResource.equals("motes") || currentResource.equals("shards") || currentResource.equals("fragments")) {
                        mats.put(currentResource, mats.get(currentResource) + resource);

                        if (mats.get(currentResource) >= 250) {
                            legendaryObtained = true;
                            break;
                        }
                    } else {
                        junk.putIfAbsent(currentResource, 0);
                        junk.put(currentResource, junk.get(currentResource) + resource);
                    }
                }
            }

            if (legendaryObtained) {
                break;
            }
        }

        if (mats.get("motes") >= 250) {
            mats.put("motes", mats.get("motes") - 250);
            System.out.println("Dragonwrath obtained!");
        } else if (mats.get("fragments") >= 250) {
            mats.put("fragments", mats.get("fragments") - 250);
            System.out.println("Valanyr obtained!");
        } else {
            mats.put("shards", mats.get("shards") - 250);
            System.out.println("Shadowmourne obtained!");
        }

        mats.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        junk.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}
