import java.io.*;
import java.nio.Buffer;

public class mergeTwoFiles {
    public static void main(String[] args) throws IOException {
        FileInputStream firstStream = new FileInputStream("inputOne.txt");
        FileInputStream secondStream = new FileInputStream("inputTwo.txt");
        PrintWriter writer = new PrintWriter("output.txt");

        BufferedReader reader = new BufferedReader(new InputStreamReader(firstStream));

        String line = reader.readLine();

        while (line != null) {
            writer.println(line);

            line = reader.readLine();
        }

        reader = new BufferedReader(new InputStreamReader(secondStream));

        line = reader.readLine();
        while (line != null) {
            writer.println(line);

            line = reader.readLine();
        }

        writer.close();
    }
}
