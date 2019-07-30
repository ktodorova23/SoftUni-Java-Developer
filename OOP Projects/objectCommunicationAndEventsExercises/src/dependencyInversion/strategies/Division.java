package dependencyInversion.strategies;

import dependencyInversion.interfaces.Strategy;

public class Division implements Strategy {
    @Override
    public int calculateResult(int first, int second) {
        return first / second;
    }
}
