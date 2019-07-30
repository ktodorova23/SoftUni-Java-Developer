import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class sumLines {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("input.txt");

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line = reader.readLine();

        while (line != null){
            int sum = 0;

            for (int i = 0; i < line.length(); i++) {
                sum += line.charAt(i);
            }
            System.out.println(sum);
            line = reader.readLine();
        }
    }
}
