import java.util.Scanner;

public class extraxtFile {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] path = console.nextLine().split("\\\\");

        String lastPart = path[path.length - 1];
        int index = lastPart.lastIndexOf(".");
        String file = lastPart.substring(0, index);
        String extension = lastPart.substring(index + 1);

        System.out.println(String.format("File name: %s\n" +
                "File extension: %s\n", file, extension));
    }
}
