package genericBox.tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstInput = reader.readLine().split("\\s+");
        String[] secondInput = reader.readLine().split("\\s+");
        String[] thirdInput = reader.readLine().split("\\s+");

        Threeuple<String, String, String> firstPair = new Threeuple<>(
                (firstInput[0] + " " + firstInput[1]),
                firstInput[2],
                firstInput[3]
        );

        Threeuple<String, Integer, String> secondPair = new Threeuple<>(
                secondInput[0],
                Integer.parseInt(secondInput[1]),
                (secondInput[2].equals("drunk") ? "true" : "false")
        );

        Threeuple<String, Double, String> thirdPair = new Threeuple<>(
                thirdInput[0],
                Double.parseDouble(thirdInput[1]),
                thirdInput[2]
        );

        System.out.println(firstPair);
        System.out.println(secondPair);
        System.out.println(thirdPair);
    }
}
