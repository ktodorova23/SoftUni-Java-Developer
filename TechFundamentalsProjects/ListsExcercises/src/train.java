import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class train {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(console.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(console.nextLine());

        String input = console.nextLine();

        while (!input.equals("end")) {
            String[] cmd = input.split(" ");

            if (cmd[0].equals("Add")) {
                int numberToAdd = Integer.parseInt(cmd[1]);
                wagons.add(numberToAdd);
            } else {
                int passangers = Integer.parseInt(cmd[0]);

                for (int i = 0; i < wagons.size(); i++) {
                    if (wagons.get(i) + passangers <= maxCapacity) {
                        wagons.set(i, wagons.get(i) + passangers);
                        break;
                    }

                }
            }
            input = console.nextLine();
        }

        for (int i = 0; i < wagons.size(); i++) {
            System.out.print(wagons.get(i) + " ");
        }
//        wagons.forEach(e -> System.out.print(e + " "));
    }
}
