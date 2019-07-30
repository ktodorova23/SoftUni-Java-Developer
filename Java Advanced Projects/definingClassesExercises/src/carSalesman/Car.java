package carSalesman;

public class Car {
    private static String DEFAULT_VALUE = "n/a";

    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine, int weight, String color) {
        this(model, engine, weight);
        this.color = color;
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = -1;
        this.color = DEFAULT_VALUE;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public String getInfo() {
        return String.format("%s:\n" +
                "%s:\n" +
                "Power: %d\n" +
                "Displacement: %s\n" +
                "Efficiency: %s\n" +
                "Weight: %s\n" +
                "Color: %s\n",
                this.getModel(),
                this.engine.getModel(),
                this.engine.getPower(),
                this.engine.getDisplacement() == -1 ? "n/a" : String.valueOf(this.engine.getDisplacement()),
                this.engine.getEfficiency(),
                this.getWeight() == -1 ? "n/a" : String.valueOf(this.getWeight()),
                this.getColor());
    }
}
