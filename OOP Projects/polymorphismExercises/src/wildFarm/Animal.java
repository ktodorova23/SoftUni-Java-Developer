package wildFarm;

public abstract class Animal implements Feedable, SoundProducable {
    private String name;
    private Double weight;
    private Integer foodEaten;

    public Animal(String name, Double weight) {
        this.name = name;
        this.weight = weight;
        this.foodEaten = 0;
    }

    protected void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }

    protected String getName() {
        return this.name;
    }

    protected Double getWeight() {
        return this.weight;
    }

    protected Integer getFoodEaten() {
        return this.foodEaten;
    }
}
