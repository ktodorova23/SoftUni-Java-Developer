package dependencyInversion.strategies;

import dependencyInversion.interfaces.Strategy;

public class Addition implements Strategy {
    @Override
    public int calculateResult(int first, int second) {
        return first + second;
    }
}
