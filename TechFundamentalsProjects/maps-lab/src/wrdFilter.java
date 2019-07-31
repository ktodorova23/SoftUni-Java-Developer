import java.util.Arrays;
import java.util.Scanner;

public class wrdFilter {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] row = console.nextLine().split("\\s+");

        Arrays.stream(row).filter(e -> e.length()%2 == 0).forEach(e -> System.out.println(e));
    }
}
