public class Extensions extends InputInterpreter {
    public static InputInterpreter buildInterpreter(CalculationEngine engine) {
        return new Extensions(engine);
    }

    private CalculationEngine engine;

    public Extensions(CalculationEngine engine) {
        super(engine);
    }


    @Override
    public Operation getOperation(String operation) {
        super.getOperation(operation);
        if (operation.equals("/")) {
            return new DivisionOperation();
        } else if (operation.equals("+")) {
            return new AddingOperation();
        }

        return null;
    }
}
