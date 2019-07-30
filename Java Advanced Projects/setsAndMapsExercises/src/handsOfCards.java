import java.util.*;

public class handsOfCards {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String line = console.nextLine();

        LinkedHashMap<String, Integer> pointsByPlayer = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> powerOfCards = new LinkedHashMap<>();
        powerOfCards.put("2", 2);
        powerOfCards.put("3", 3);
        powerOfCards.put("4", 4);
        powerOfCards.put("5", 5);
        powerOfCards.put("6", 6);
        powerOfCards.put("7", 7);
        powerOfCards.put("8", 8);
        powerOfCards.put("9", 9);
        powerOfCards.put("10", 10);
        powerOfCards.put("J", 11);
        powerOfCards.put("Q", 12);
        powerOfCards.put("K", 13);
        powerOfCards.put("A", 14);

        HashMap<Character, Integer> multiplierByType = new HashMap<>();
        multiplierByType.put('S', 4);
        multiplierByType.put('H', 3);
        multiplierByType.put('D', 2);
        multiplierByType.put('C', 1);

        HashMap<String, List<String>> cardsByPlayer = new HashMap<>();

        while (!line.equals("JOKER")) {
            String[] tokens = line.split(": ");
            String player = tokens[0];
            String[] cards = tokens[1].split(", ");

            pointsByPlayer.putIfAbsent(player, 0);
            cardsByPlayer.putIfAbsent(player, new ArrayList<>());

            String powerOfCard = "";
            int points = 0;
            char type = '\n';

            for (int i = 0; i < cards.length; i++) {
                if (!cardsByPlayer.get(player).contains(cards[i])) {
                    if (cards[i].length() == 3) {
                        powerOfCard = cards[i].substring(0, 2);
                        type = cards[i].charAt(2);
                    } else {
                        powerOfCard = cards[i].charAt(0) + "";
                        type = cards[i].charAt(1);
                    }
                    cardsByPlayer.get(player).add(cards[i]);
                    points += powerOfCards.get(powerOfCard) * multiplierByType.get(type);
                }
            }

            pointsByPlayer.put(player, pointsByPlayer.get(player) + points);

            line = console.nextLine();
        }

        pointsByPlayer.entrySet().stream().forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}
