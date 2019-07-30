import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class writeToFile {
    public static void main(String[] args) {

        String inputPath = "E:\\Java\\Docs for exercise\\Java Advanced\\Labs\\04. Java-Advanced-Files-and-Streams-Lab-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        String outputPath = "E:\\Java\\Docs for exercise\\Java Advanced\\Labs\\04. Java-Advanced-Files-and-Streams-Lab-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt";

        List<Character> punctuation = new ArrayList<>();
        Collections.addAll(punctuation, '.', ',', '!', '?');

        try {
            FileInputStream inputStream = new FileInputStream(inputPath);
            FileOutputStream outputStream = new FileOutputStream(outputPath);

            int oneByte = inputStream.read();
            while (oneByte >= 0) {
                if (!punctuation.contains((char)oneByte)) {
                    outputStream.write(oneByte);
                }
                oneByte = inputStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
