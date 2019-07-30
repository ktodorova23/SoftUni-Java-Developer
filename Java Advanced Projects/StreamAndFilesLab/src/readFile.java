import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class readFile {
    public static void main(String[] args) {

        String inputPath = "E:\\Java\\Docs for exercise\\Java Advanced\\Labs\\04. Java-Advanced-Files-and-Streams-Lab-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try {
            FileInputStream fileStream = new FileInputStream(inputPath);

            int oneByte = fileStream.read();
            while (oneByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = fileStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
