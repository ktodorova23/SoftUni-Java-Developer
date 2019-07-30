package cardSuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(reader.readLine() + ":");
        CardSuits[] suits = CardSuits.values();

        for (CardSuits suit : suits) {
            System.out.println(String.format("Ordinal value: %d; Name value: %s", suit.ordinal(), suit.name()));
        }
    }
}
