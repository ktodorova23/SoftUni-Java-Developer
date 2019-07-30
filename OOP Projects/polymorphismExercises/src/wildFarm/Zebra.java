package wildFarm;

public class Zebra extends Mammal {
    public Zebra(String name, Double weight, String livingRegion) {
        super(name, weight, livingRegion);
    }

    @Override
    public void eatFood(Food food) {
        if (food.getClass().getSimpleName().equals("Vegetable")) {
            this.setFoodEaten(food.getQuantity());
        } else {
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
    }

    @Override
    public String makeSound() {
        return "Zs";
    }
}
