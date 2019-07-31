import java.util.Scanner;

public class greaterOfTwoValues {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        String type = console.nextLine().toLowerCase();
        String firstInput = console.nextLine();
        String secondInput = console.nextLine();

        if (type.equals("int")) {
            int first = Integer.parseInt(firstInput);
            int second = Integer.parseInt(secondInput);
            System.out.println(getMax(first, second));
        } else if (type.equals("char")) {
            char firstChar = firstInput.charAt(0);
            char secondChar = secondInput.charAt(0);
            System.out.println((char) getMax(firstChar, secondChar));
        } else if (type.equals("string")) {
            System.out.println(getMax(firstInput, secondInput));
        }


    }

    private static int getMax(int first, int second) {
        if (first > second) {
            return first;
        }
        return second;
    }

//    static char getMax(char firstChar, char secondChar) {
//        if (firstChar > secondChar) {
//            return firstChar;
//        }
//        return secondChar;
//    }

    static String getMax(String firstInput, String secondInput) {
        if (firstInput.compareTo(secondInput) >= 0) {
            return firstInput;
        }
        return secondInput;
    }
}
