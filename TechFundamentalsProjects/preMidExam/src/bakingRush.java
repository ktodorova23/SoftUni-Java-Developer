import java.util.Scanner;

public class bakingRush {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] events = console.nextLine().split("\\|+");

        int energy = 100;
        int coins = 100;

        for (int i = 0; i < events.length; i++) {
            String[] currentEvent = events[i].split("-");
            switch (currentEvent[0]) {
                case "rest":
                    int energyGained = Integer.parseInt(currentEvent[1]);
                    if (energy <= (100 - energyGained)) {
                        energy += energyGained;
                        System.out.printf("You gained %d energy.%n", energyGained);
                    } else {
                        energy += (100 - energy);
                        System.out.printf("You gained %d energy.%n", (100 - energy));
                    }
                    System.out.printf("Current energy: %d.%n", energy);
                    break;
                case "order":
                    int earnedCoins = Integer.parseInt(currentEvent[1]);
                    if ((energy - 30) >= 0) {
                        coins += earnedCoins;
                        energy -= 30;
                        System.out.printf("You earned %d coins.%n", earnedCoins);
                    } else {
                        if (energy <= 50) {
                            energy += 50;
                        } else {
                            energy += (100 - energy);
                        }
                        System.out.println("You had to rest!");
                    }
                    break;
                    default:
                        int price = Integer.parseInt(currentEvent[1]);
                        if ((coins - price) > 0) {
                            coins -= price;
                            System.out.printf("You bought %s.%n", currentEvent[0]);
                        } else {
                            System.out.printf("Closed! Cannot afford %s.%n", currentEvent[0]);
                            return;
                        }
                        break;
            }
        }

        System.out.printf("Day completed!%nCoins: %d%nEnergy: %d", coins, energy);

    }
}
