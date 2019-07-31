import java.util.*;
import java.util.stream.Collectors;

public class forceBook {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String line = console.nextLine();

        Map<String, List<String>> forces = new LinkedHashMap<>();

        while (!line.equals("Lumpawaroo")) {
            List<String> tokens = Arrays.stream(line.split("\\s+")).collect(Collectors.toList());
            int index = 0;

            if (tokens.contains("->")) {
                index = tokens.indexOf("->");
                String forceUser = "";
                String forceSide = "";
                if (index > 1) {
                    for (int i = 0; i < index; i++) {
                        if (i < index - 1) {
                            forceUser += tokens.get(i) + " ";
                        } else {
                            forceUser += tokens.get(i);
                        }
                    }
                    for (int i = index + 1; i < tokens.size(); i++) {
                        if (i == tokens.size() - 1) {
                            forceSide += tokens.get(i);
                        } else {
                            forceSide += tokens.get(i) + " ";
                        }
                    }
                } else {
                    forceUser = tokens.get(0);
                    forceSide = tokens.get(2);
                }
                forces.putIfAbsent(forceSide, new ArrayList<>());
                String currentSide = "";
                boolean onDifferentSide = false;
                for (Map.Entry<String, List<String>> aForces:forces.entrySet()) {
                    if (aForces.getValue().contains(forceUser)) {
                        onDifferentSide = true;
                        currentSide = aForces.getKey();
                    }
                }
                if (!forces.get(forceSide).contains(forceUser) && !onDifferentSide) {
                    forces.get(forceSide).add(forceUser);
                    System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
                } else if (!forces.get(forceSide).contains(forceUser) && onDifferentSide) {
                    forces.get(currentSide).remove(forceUser);
                    forces.get(forceSide).add(forceUser);
                    System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
                }
            } else {
                index = tokens.indexOf("|");
                String forceSide = "";
                String forceUser = "";
                if (index > 1) {
                    for (int i = 0; i < index; i++) {
                        if (i < index - 1) {
                            forceSide += tokens.get(i) + " ";
                        } else {
                            forceSide += tokens.get(i);
                        }
                    }

                    for (int i = index + 1; i < tokens.size(); i++) {
                        if (i == tokens.size() - 1){
                            forceUser += tokens.get(i);
                        } else {
                            forceUser += tokens.get(i) + " ";
                        }
                    }
                } else {
                    if (tokens.size() > 3) {
                        for (int i = index + 1; i < tokens.size(); i++) {
                            if (i == tokens.size() - 1) {
                                forceUser += tokens.get(i);
                            } else {
                                forceUser += tokens.get(i) + " ";
                            }
                        }
                    } else {
                        forceUser = tokens.get(2);
                    }
                    forceSide = tokens.get(0);
                }
                forces.putIfAbsent(forceSide, new ArrayList<>());
                if (!forces.get(forceSide).contains(forceUser)) {
                    forces.get(forceSide).add(forceUser);
                }
            }
            line = console.nextLine();
        }
        forces.entrySet().stream().sorted((e1, e2) -> {
            int e1MembersCount = e1.getValue().size();
            int e2MembersCount = e2.getValue().size();
            if (Integer.compare(e2MembersCount, e1MembersCount) == 0) {
                return e1.getKey().compareTo(e2.getKey());
            }
            return Integer.compare(e2MembersCount, e1MembersCount);
        }).forEach(key -> {
            int length = key.getValue().size();
            if (length > 0) {
                System.out.println("Side: " + key.getKey() + ", Members: " + length);
                Collections.sort(key.getValue());
                key.getValue().stream().forEach(e -> System.out.println("! " + e));
            }
        });
    }
}
