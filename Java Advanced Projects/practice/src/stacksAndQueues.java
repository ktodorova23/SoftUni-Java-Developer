import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("Duplicates")
public class stacksAndQueues {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        String[] powerOfPlants = console.nextLine().split("\\s+");
        List<Long> power = new ArrayList<>();

        for (String flower : powerOfPlants) {
            power.add(Long.parseLong(flower));
        }

        int days = 1;
        boolean flag = false;
        while (true) {
            days++;
            boolean finalDay = false;
            int size = power.size();
            for (int i = power.size() - 1; i >= 0; i--) {
                if (!flag && i < power.size() - 1) {
                    power.remove(i + 1);
                }
                flag = false;
                for (int j = 0; j < i; j++) {
                    if (power.get(j) > power.get(i)) {
                        flag = true;
                        break;
                    }
                }
                if (i == 0 && power.size() == size) {
                    finalDay = true;
                }
            }
            if (finalDay) {
                break;
            }
        }

        System.out.println(days);


    }
}