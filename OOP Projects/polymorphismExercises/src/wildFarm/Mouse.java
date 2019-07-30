package wildFarm;

public class Mouse extends Mammal {
    public Mouse(String name, Double weight, String livingRegion) {
        super(name, weight, livingRegion);
    }

    @Override
    public void eatFood(Food food) {
        if (food.getClass().getSimpleName().equals("Vegetable")) {
            this.setFoodEaten(food.getQuantity());
        } else {
            throw new IllegalArgumentException("Mice are not eating that type of food!");
        }
    }

    @Override
    public String makeSound() {
        return "SQUEEEAAAK!";
    }
}
