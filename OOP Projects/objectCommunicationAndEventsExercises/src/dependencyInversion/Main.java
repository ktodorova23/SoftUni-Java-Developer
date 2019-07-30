package dependencyInversion;

import dependencyInversion.interfaces.Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Calculator calculator = new CalculatorImpl();

        String line;
        while (!"End".equals(line = reader.readLine())) {
            String[] cmdArgs = line.split("\\s+");

            if (cmdArgs[0].equals("mode")) {
                calculator.changeStrategy(cmdArgs[1]);
            } else {
                System.out.println(calculator.performCalculation(Integer.parseInt(cmdArgs[0]), Integer.parseInt(cmdArgs[1])));
            }
        }
    }
}
