package wildFarm;

public class Tiger extends Felime {

    public Tiger(String name, Double weight, String livingRegion) {
        super(name, weight, livingRegion);
    }

    @Override
    public void eatFood(Food food) {
        if (food.getClass().getSimpleName().equals("Meat")) {
            this.setFoodEaten(food.getQuantity());
        } else {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
    }

    @Override
    public String makeSound() {
        return "ROAAR!!!";
    }
}
