import java.util.Scanner;

public class dataTypeFinder {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);


        while (true) {

        String input = console.nextLine();

        if (input.equals("END")) {
            break;
        }

        boolean isNum = true;

        try {
            int num = Integer.parseInt(input);
        } catch (Exception e) {
            isNum = false;
        }

        boolean isFloating = true;

        try {
            double isDouble = Double.parseDouble(input);
        } catch (Exception e) {
            isFloating = false;
        }

//        boolean isChar = true;
//
//        try {
//            char character = input.charAt(0);
//        } catch (Exception e) {
//            isChar = false;
//        }

        if (isNum) {
            System.out.printf("%s is integer type%n", input);
        } else if (isFloating) {
            System.out.printf("%s is floating point type%n", input);
        } else if (input.length() == 1) {
            System.out.printf("%s is character type%n", input);
        } else if (input.equalsIgnoreCase("True") || input.equalsIgnoreCase("False")) {
            System.out.printf("%s is boolean type%n", input);
        } else {
            System.out.printf("%s is string type%n", input);
        }
            }
        }
    }
