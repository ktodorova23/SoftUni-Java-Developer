import java.util.Scanner;

public class commonElements {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String [] text1 = console.nextLine().split(" ");
        String [] text2 = console.nextLine().split(" ");

        for (String aText2 : text2) {
            for (String aText1 : text1) {
                if (aText2.equals(aText1)) {
                    System.out.print(aText1 + " ");
                    break;
                }
            }
        }
    }
}
