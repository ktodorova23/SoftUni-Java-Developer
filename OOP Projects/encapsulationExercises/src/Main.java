import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] pizzaData = reader.readLine().split("\\s+");
        Pizza pizza = null;
        try {
            pizza = new Pizza(pizzaData[1], Integer.parseInt(pizzaData[2]));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        String[] doughData = reader.readLine().split("\\s+");
        try {
            Dough dough = new Dough((doughData[1]), doughData[2], Double.parseDouble(doughData[3]));
            pizza.setDough(dough);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        String line;
        while (!"END".equals(line = reader.readLine())) {
            String[] toppingData = line.split("\\s+");

            try {
                Topping topping = new Topping(toppingData[1], Double.parseDouble(toppingData[2]));
                pizza.addTopping(topping);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        System.out.println(pizza.toString());
    }
}
