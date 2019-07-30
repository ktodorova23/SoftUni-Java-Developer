import java.io.*;
import java.util.Scanner;

public class extractIntegers {
    public static void main(String[] args) {
        String inputPath = "E:\\Java\\Docs for exercise\\Java Advanced\\Labs\\04. Java-Advanced-Files-and-Streams-Lab-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        String outputPath = "E:\\Java\\Docs for exercise\\Java Advanced\\Labs\\04. Java-Advanced-Files-and-Streams-Lab-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt";
            Scanner console = null;
            FileOutputStream fileOutputStream = null;
        try {
            console = new Scanner(new FileInputStream(inputPath));
            fileOutputStream = new FileOutputStream(outputPath);

            while (console.hasNext()) {
                if (console.hasNextInt()) {
                    System.out.println(console.nextInt());
                }
                console.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (console != null) {
                console.close();
            }

            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
