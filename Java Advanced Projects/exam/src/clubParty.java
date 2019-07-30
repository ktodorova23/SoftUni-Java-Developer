import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

@SuppressWarnings("Duplicates")
public class clubParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int capacity = Integer.parseInt(reader.readLine());

        String[] inputs = reader.readLine().split("\\s+");

        Deque<Character> halls = new ArrayDeque<>();
        Deque<Integer> reservations = new ArrayDeque<>();
        LinkedHashMap<Character, Integer> currentCapacityOfHalls = new LinkedHashMap<>();

        for (int i = inputs.length - 1; i >= 0; i--) {
            String currentInput = inputs[i];
            if (Character.isAlphabetic(currentInput.charAt(0))) {
                halls.offer(currentInput.charAt(0));
                currentCapacityOfHalls.put(currentInput.charAt(0), 0);
            } else {
                if (!halls.isEmpty()) {
                    char hall = halls.peek();
                    int reservation = Integer.parseInt(currentInput);
                    if (currentCapacityOfHalls.get(hall) + reservation <= capacity) {
                        reservations.offer(reservation);
                        currentCapacityOfHalls.put(hall, currentCapacityOfHalls.get(hall) + reservation);
                        //The problem may require a different turn of events!!!
                        if (currentCapacityOfHalls.get(hall) == capacity) {
                            halls.poll();
                            String reservationsToString = reservations.stream().map(String::valueOf).collect(Collectors.joining(", "));
                            System.out.println(String.format("%c -> %s", hall, reservationsToString));
                            currentCapacityOfHalls.remove(hall);
                            reservations.clear();
                        }
                    } else {
                        halls.poll();
                        String reservationsToString = reservations.stream().map(String::valueOf).collect(Collectors.joining(", "));
                        System.out.println(String.format("%c -> %s", hall, reservationsToString));
                        currentCapacityOfHalls.remove(hall);
                        reservations.clear();
                        while (!halls.isEmpty()) {
                            hall = halls.peek();
                            if (currentCapacityOfHalls.get(hall) + reservation <= capacity) {
                                reservations.offer(reservation);
                                currentCapacityOfHalls.put(hall, currentCapacityOfHalls.get(hall) + reservation);
                                //The problem may require a different turn of events!!!
                                if (currentCapacityOfHalls.get(hall) == capacity) {
                                    halls.poll();
                                    reservationsToString = reservations.stream().map(String::valueOf).collect(Collectors.joining(", "));
                                    System.out.println(String.format("%c -> %s", hall, reservationsToString));
                                    currentCapacityOfHalls.remove(hall);
                                    reservations.clear();
                                    break;
                                }
                            } else {
                                halls.poll();
                                reservationsToString = reservations.stream().map(String::valueOf).collect(Collectors.joining(", "));
                                System.out.println(String.format("%c -> %s", hall, reservationsToString));
                                currentCapacityOfHalls.remove(hall);
                                reservations.clear();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}

