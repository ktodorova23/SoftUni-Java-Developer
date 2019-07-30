package dependencyInversion;

import dependencyInversion.interfaces.Calculator;
import dependencyInversion.interfaces.Strategy;
import dependencyInversion.strategies.Addition;
import dependencyInversion.strategies.Division;
import dependencyInversion.strategies.Multiplication;
import dependencyInversion.strategies.Subtraction;

public class CalculatorImpl implements Calculator {
//    private int firstOperand;
//    private int secondOperand;

    private Strategy strategy;

    public CalculatorImpl() {
        this.strategy = new Addition();
    }


    @Override
    public void changeStrategy(String operator) {
        switch (operator) {
            case "+":
                this.strategy = new Addition();
                break;
            case "-":
                this.strategy = new Subtraction();
                break;
            case "*":
                this.strategy = new Multiplication();
                break;
            case "/":
                this.strategy = new Division();
                break;
        }
    }

    @Override
    public int performCalculation(int firstOperand, int secondOperand) {
        return this.strategy.calculateResult(firstOperand, secondOperand);
    }
}
