import java.io.*;
import java.util.Scanner;

public class writeEveryThirdLine {
    public static void main(String[] args) {
        String inputPath = "E:\\Java\\Docs for exercise\\Java Advanced\\Labs\\04. Java-Advanced-Files-and-Streams-Lab-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        String outputPath = "E:\\Java\\Docs for exercise\\Java Advanced\\Labs\\04. Java-Advanced-Files-and-Streams-Lab-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt";

        BufferedReader reader = null;
        PrintWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(inputPath));
            writer = new PrintWriter(new FileWriter(outputPath));

            int lines = 1;
            String line = reader.readLine();
            while (line != null) {
                if (lines % 3 == 0) {
                   writer.println(line);
                }
                lines++;
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (writer != null) {
                writer.close();
            }
        }
    }
}
