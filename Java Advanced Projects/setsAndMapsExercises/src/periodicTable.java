import java.util.Scanner;
import java.util.TreeSet;

public class periodicTable {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int rows = Integer.parseInt(console.nextLine());

        TreeSet<String> compounds = new TreeSet<>();

        while (rows-- > 0) {
            String[] currentRow = console.nextLine().split("\\s+");

            for (String word :
                    currentRow) {
                compounds.add(word);
            }
        }

        for (String compound : compounds) {
            System.out.print(compound + " ");
        }
    }
}
