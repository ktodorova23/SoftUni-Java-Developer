import java.util.*;

public class listProducts {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        List<String> products = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = console.nextLine();
            products.add(input);
        }

        Collections.sort(products);

        for (int i = 1; i <= n; i++) {
            System.out.println(i + "." + products.get(i - 1));
        }
    }
}
