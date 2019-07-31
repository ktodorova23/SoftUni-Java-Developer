import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class legendaryFarming {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        boolean canObtainShadowmourne = false;
        boolean canObtainValanyr = false;
        boolean canObtainDragonwrath = false;

        Map<String, Integer> mats = new HashMap<>();
        mats.put("motes", 0);
        mats.put("fragments", 0);
        mats.put("shards", 0);
        Map<String, Integer> junk = new HashMap<>();

        while (true) {
            String[] input = console.nextLine().toLowerCase().split("\\s+");

            int numberToAdd = 0;
            int count = 0;
            while(count < input.length) {
                if (count % 2 == 0) {
                    numberToAdd = Integer.parseInt(input[count]);
                } else {
                    if (input[count].equals("motes") || input[count].equals("fragments") || input[count].equals("shards")) {
                        mats.put(input[count], mats.get(input[count]) + numberToAdd);
                        for (Map.Entry<String, Integer> entry:mats.entrySet()) {
                            if (entry.getValue() >= 250) {
                                if (entry.getKey().equals("motes")) {
                                    canObtainDragonwrath = true;
                                    break;
                                } else if (entry.getKey().equals("fragments")) {
                                    canObtainValanyr = true;
                                    break;
                                } else if (entry.getKey().equals("shards")) {
                                    canObtainShadowmourne = true;
                                    break;
                                }
                            }
                        }
                        if (canObtainDragonwrath || canObtainShadowmourne || canObtainValanyr) {
                            break;
                        }

                    } else {
                        junk.putIfAbsent(input[count], 0);
                        junk.put(input[count], junk.get(input[count]) + numberToAdd);
                    }
                }
                count++;
            }

            if (canObtainDragonwrath || canObtainShadowmourne || canObtainValanyr) {
                break;
            }
        }

        if (canObtainDragonwrath) {
            System.out.println("Dragonwrath obtained!");
            mats.put("motes", mats.get("motes") - 250);
        } else if (canObtainShadowmourne) {
            System.out.println("Shadowmourne obtained!");
            mats.put("shards", mats.get("shards") - 250);
        } else if (canObtainValanyr) {
            System.out.println("Valanyr obtained!");
            mats.put("fragments", mats.get("fragments") - 250);
        }

        mats.entrySet().stream().sorted((e1, e2) -> {
            int valueComparison = Integer.compare(e2.getValue(), e1.getValue());

            if (valueComparison == 0) {
                return e1.getKey().compareTo(e2.getKey());
                }
                return valueComparison;
        }).forEach(m -> {
            System.out.print(m.getKey() + ": ");
            System.out.println(m.getValue());
        });

        junk.entrySet().stream().sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey())).forEach(m -> {
            System.out.print(m.getKey() + ": ");
            System.out.println(m.getValue());
        });


    }
}
