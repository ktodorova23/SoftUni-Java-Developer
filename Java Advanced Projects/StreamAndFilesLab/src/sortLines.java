import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class sortLines {
    public static void main(String[] args) {
        Path inputPath = Paths.get("E:\\Java\\Docs for exercise\\Java Advanced\\Labs\\04. Java-Advanced-Files-and-Streams-Lab-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\newInput.txt");

        Path outputPath = Paths.get("E:\\Java\\Docs for exercise\\Java Advanced\\Labs\\04. Java-Advanced-Files-and-Streams-Lab-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt");

//        BufferedReader reader = null;
//        OutputStreamWriter writer = null;

        try {
            List<String> allLines = Files.readAllLines(inputPath);
            Collections.sort(allLines);
            Files.write(outputPath, allLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
