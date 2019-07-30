import java.io.*;

public class lineNumbers {
    public static void main(String[] args) throws IOException {
        FileInputStream fileStream = new FileInputStream("inputLineNumbers.txt");
        PrintWriter writer = new PrintWriter("output.txt");

        BufferedReader reader = new BufferedReader(new InputStreamReader(fileStream));

        String line = reader.readLine();
        int lineNumber = 1;
        while (line != null) {
            writer.printf("%d. " + line + "%n", lineNumber);
            lineNumber++;

            line = reader.readLine();
        }

        writer.close();
    }
}
