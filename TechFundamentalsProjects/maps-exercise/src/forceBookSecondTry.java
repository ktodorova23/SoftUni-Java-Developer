import java.lang.reflect.Member;
import java.util.*;

public class forceBookSecondTry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> force = new LinkedHashMap<>();

        String line = scanner.nextLine();

        while (!line.equals("Lumpawaroo")) {
            if (line.contains("|")) {
                String[] tokens = line.split(" \\| ");
                String forceSide = tokens[0];
                String forceUser = tokens[1];

                force.putIfAbsent(forceSide, new ArrayList<>());
                if (!force.containsValue(forceUser)) {
                    if (!userIsPresent(force, forceSide, forceUser)) {
                        force.get(forceSide).add(forceUser);
                    }
                }
            } else {
                String[] tokens = line.split(" -> ");
                String forceSide = tokens[1];
                String forceUser = tokens[0];

                force.putIfAbsent(forceSide, new ArrayList<>());
                if (!force.containsValue(forceUser) && userIsPresent(force, forceSide, forceUser)) {
                        force.get(forceSide).add(forceUser);
                        System.out.println(String.format("%s joins the %s side!", forceUser, forceSide));
                }
            }
            line = scanner.nextLine();
        }

        force.entrySet().stream().filter(key -> key.getValue().size() > 0).sorted((e1, e2) -> {
            int comparison = Integer.compare(e2.getValue().size(), e1.getValue().size());

            if (comparison == 0) {
                return e1.getKey().compareTo(e2.getKey());
            }
            return comparison;
        }).forEach(key -> {
            System.out.println("Side: " + key.getKey() + ", Members: " + key.getValue().size());
            Collections.sort(key.getValue());
            key.getValue().forEach(value -> System.out.println("! " + value));
        });
    }

    public static boolean userIsPresent (Map<String, List<String>> force, String forceSide, String forceUser) {
        boolean presentSomewhere = false;
        String currentSide = "";
        for (Map.Entry<String, List<String>> entry:force.entrySet()) {
            if (entry.getValue().contains(forceUser)) {
                currentSide += entry.getKey();
                presentSomewhere = true;
                break;
            }
        }
        boolean onDifferentSide = false;
        if (presentSomewhere && !currentSide.equals(forceSide)) {
            onDifferentSide = true;
        }
        if (onDifferentSide) {
            force.get(currentSide).remove(forceUser);
        }
        return onDifferentSide;
    }
}
