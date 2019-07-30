import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class getFolderSize {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("output.txt");
        File file = new File("Exercises Resources");

        long sum = Arrays.stream(file.listFiles())
                .filter(f -> f.isFile())
                .mapToLong(f -> f.length())
                .sum();

        writer.println("Folder size: " + sum);
        writer.close();
    }
}
