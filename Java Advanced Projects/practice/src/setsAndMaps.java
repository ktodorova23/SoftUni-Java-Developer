import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class setsAndMaps {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String rows = reader.readLine();

        TreeMap<Character, Integer> countOfSymbols = new TreeMap<>();

        for (int i = 0; i < rows.length(); i++) {
            countOfSymbols.putIfAbsent(rows.charAt(i), 0);
            countOfSymbols.put(rows.charAt(i), countOfSymbols.get(rows.charAt(i)) + 1);
        }

        for (Map.Entry<Character, Integer> entry : countOfSymbols.entrySet()) {
            System.out.println(String.format("%c: %d time/s", entry.getKey(), entry.getValue()));
        }
    }
}
