import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int toppings) {
        this.setName(name);
        this.setToppings(toppings);
    }

    private void setToppings(int toppings) {
        if (toppings < 0 || toppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().length() < 1 || name.trim().length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return this.name;
    }

    private Dough getDough() {
        return this.dough;
    }

    private List<Topping> getToppings() {
        return this.toppings;
    }

    public void addTopping(Topping topping) {
        this.getToppings().add(topping);
    }

    public double getOverallCalories() {
        double result = this.getDough().calculateCalories();
        for (Topping topping : this.getToppings()) {
            result += topping.calculateCalories();
        }
        return result;
    }
}
