import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class arrangeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(", ");

        Map<String, String> numbers = new TreeMap<>();

        for (String number : input) {
            String currentNumber = "";
            for (int i = 0; i < number.length(); i++) {
                if (i != 0) {
                    currentNumber += "-";
                }

                switch (number.charAt(i)) {
                    case '0':
                        currentNumber += "zero";
                        break;
                    case '1':
                        currentNumber += "one";
                        break;
                    case '2':
                        currentNumber += "two";
                    break;
                    case '3':
                        currentNumber += "three";
                        break;
                    case '4':
                        currentNumber += "four";
                        break;
                    case '5':
                        currentNumber += "five";
                        break;
                    case '6':
                        currentNumber += "six";
                        break;
                    case '7':
                        currentNumber += "seven";
                        break;
                    case '8':
                        currentNumber += "eight";
                        break;
                    case '9':
                        currentNumber += "nine";
                        break;
                }
            }
            if (numbers.containsKey(currentNumber)) {
                String newValue = numbers.get(currentNumber) + ", " + number;
                numbers.replace(currentNumber, newValue);
            } else {
                numbers.put(currentNumber, number);
            }
        }

        StringBuilder sb = new StringBuilder();
        numbers.entrySet().stream().forEach(e -> sb.append(e.getValue()).append(", "));

        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb.toString());
    }
}
