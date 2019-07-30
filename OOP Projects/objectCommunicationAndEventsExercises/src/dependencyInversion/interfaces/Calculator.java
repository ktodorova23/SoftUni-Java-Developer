package dependencyInversion.interfaces;

public interface Calculator {
    void changeStrategy(String operator);

    int performCalculation(int firstOperand, int secondOperand);
}
