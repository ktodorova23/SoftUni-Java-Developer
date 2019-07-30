import java.io.*;

public class ALLCAPITALS {
    public static void main(String[] args) throws IOException {
        FileInputStream fileStream = new FileInputStream("input.txt");
        FileWriter writer = new FileWriter("output.txt");

        BufferedReader reader = new BufferedReader(new InputStreamReader(fileStream));

        String line = reader.readLine();

        while (line != null){
            line = line.toUpperCase();

            writer.write(line + System.lineSeparator());

            line = reader.readLine();
        }

        writer.close();
    }
}
