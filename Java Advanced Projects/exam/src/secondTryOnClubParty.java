import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class secondTryOnClubParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<String> halls = new ArrayDeque<>();
        Map<String, ArrayDeque<Integer>> hallsData = new HashMap<>();
        Map<String, Integer> hallsSums = new HashMap<>();
        StringBuilder result = new StringBuilder();

        int maxCapacity = Integer.parseInt(reader.readLine());
        String[] input = reader.readLine().split("\\s+");
        for (int i = input.length - 1; i >= 0; i--) {
            String token = input[i];
            if (Character.isAlphabetic(token.charAt(0))) {
                halls.offer(token);
                hallsData.put(token, new ArrayDeque<>());
                hallsSums.put(token, 0);
            } else {
                int reservation = Integer.parseInt(token);
                while (halls.size() > 1) {
                    String hall = halls.getFirst();
                    int clubLoad = hallsSums.get(hall);
                    if (clubLoad + reservation <= maxCapacity) {
                        hallsData.get(hall).offer(reservation);
                        hallsSums.put(hall, hallsSums.get(hall) + reservation);
                        break;
                    } else {
                        String overflowed = halls.poll();
                        ArrayDeque<Integer> reservations = hallsData.get(overflowed);
                        result.append(String.format("%s -> %s%n", overflowed,
                                reservations
                                        .stream().map(String::valueOf).collect(Collectors.joining(", "))));
                        hallsData.remove(overflowed);
                        hallsSums.remove(overflowed);
                    }
                }
//                while (true) { //handle the last bunker
//                    if (reservation > maxCapacity) {
//                        break;
//                    }
//                    String hall = halls.poll();
//                    int lastHallLoad = hallsSums.get(hall);
//                    if (lastHallLoad + reservation <= maxCapacity) {
//                        hallsData.get(hall).addLast(reservation);
//                        hallsSums.put(hall, hallsSums.get(hall) + reservation);
//                        break;
//                    }
//                    int removed = hallsData.get(hall).removeFirst();
//                    hallsSums.put(hall, hallsSums.get(hall) - removed);
//                }
            }
        }
        System.out.println(result);
    }
}