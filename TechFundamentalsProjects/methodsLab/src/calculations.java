import java.util.Scanner;

public class calculations {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String command = console.nextLine();

        int firstNumber = Integer.parseInt(console.nextLine());
        int secondNumber = Integer.parseInt(console.nextLine());

        if (command.equals("add")) {
            addNumbers(firstNumber, secondNumber);
        } else if (command.equals("multiply")) {
            multiplyNumbers(firstNumber, secondNumber);
        } else if (command.equals("subtract")) {
            subtractNumbers(firstNumber, secondNumber);
        } else if (command.equals("divide")) {
            divideNumbers(firstNumber, secondNumber);
        }
    }

    private static void divideNumbers(int firstNumber, int secondNumber) {
        System.out.println(firstNumber / secondNumber);
    }

    private static void subtractNumbers(int firstNumber, int secondNumber) {
        System.out.println(firstNumber - secondNumber);
    }

    private static void multiplyNumbers(int firstNumber, int secondNumber) {
        System.out.println(firstNumber * secondNumber);
    }

    private static void addNumbers(int firstNumber, int secondNumber) {
        System.out.println(firstNumber + secondNumber);
    }
}
