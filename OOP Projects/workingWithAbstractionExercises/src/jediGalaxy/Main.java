package jediGalaxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] dimensions = convertToIntArray(reader.readLine());
        Galaxy galaxy = new Galaxy(dimensions[0], dimensions[1]);

        StarsManipulator starsManipulator = new StarsManipulator(galaxy);

        String input = reader.readLine();
        long collectedStarsValues = 0;
        while (!"Let the Force be with you".equals(input)) {
            int[] playerCoordinates = convertToIntArray(input);
            int[] enemyCoordinates = convertToIntArray(reader.readLine());

            starsManipulator.destroyStars(enemyCoordinates[0], enemyCoordinates[1]);

            collectedStarsValues += starsManipulator.collectStars(playerCoordinates[0], playerCoordinates[1]);

            input = reader.readLine();
        }
        System.out.println(collectedStarsValues);
    }

    private static int[] convertToIntArray(String input) {
        return Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
