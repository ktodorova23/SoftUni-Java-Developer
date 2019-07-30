import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;

public class countCharacterTypes {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("input.txt");
        PrintWriter writer = new PrintWriter("output.txt");

        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));

        String line = reader.readLine();
        int vowelsCount = 0;
        int punctuationSignCounts = 0;
        int consonantsCount = 0;

        while (line != null) {
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == 'a' || line.charAt(i) == 'e' || line.charAt(i) == 'i' || line.charAt(i) == 'o' || line.charAt(i) == 'u') {
                    vowelsCount++;
                } else if (line.charAt(i) == '!' || line.charAt(i) == '.' || line.charAt(i) == ',' || line.charAt(i) == '?') {
                    punctuationSignCounts++;
                } else if (line.charAt(i) == ' ' || line.charAt(i) == '\n'){
                    continue;
                } else{
                    consonantsCount++;
                }
            }

            line = reader.readLine();
        }

        writer.printf("Vowels: %d%n", vowelsCount);
        writer.printf("Consonants: %d%n", consonantsCount);
        writer.printf("Punctuation: %d%n", punctuationSignCounts);

        writer.close();
    }
}
