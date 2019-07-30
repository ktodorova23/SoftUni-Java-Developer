import java.io.*;

public class sumBytes {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("input.txt");

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line = reader.readLine();
        int sum = 0;
        while (line != null) {
            for (int i = 0; i < line.length(); i++) {
                sum += line.charAt(i);
            }
            line = reader.readLine();
        }
        System.out.println(sum);
    }
}
