import java.util.Scanner;

public class heiganDanceMaxed {
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        double heiganLife = 3000000;
        int playerLife = 18500;

        boolean[][] chamber = new boolean[15][15];

        boolean activeCloud = false;
        boolean heiganIsDead = false;
        boolean playerIsDead = false;
        boolean diedFromEruption = false;
        int playerRow = 7;
        int playerCol = 7;
        int plagueDmg = 3500;
        int eruptionDmg = 6000;

        double dmgToHeiganPerTurn = Double.parseDouble(console.nextLine());

        while (playerLife > 0 && heiganLife > 0) {
            heiganLife -= dmgToHeiganPerTurn;

            if (activeCloud) {
                playerLife -= plagueDmg;
                if (playerLife <= 0) {
                    playerIsDead = true;
                }
                activeCloud = false;
            }

            if (heiganLife <= 0) {
                heiganIsDead = true;
            }

            if (playerIsDead || heiganIsDead) {
                break;
            }

            String[] tokens = console.nextLine().split("\\s+");
            String spell = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);

            if (row - 1 >= 0 && row - 1 <= 14 && col - 1 >= 0 && col - 1 <= 14) {
                chamber[row - 1][col - 1] = true;
            }
            if (row - 1 >= 0 && row - 1 <= 14 && col >= 0 && col <= 14) {
                chamber[row - 1][col] = true;
            }
            if (row - 1 >= 0 && row - 1 <= 14 && col + 1 >= 0 && col + 1 <= 14) {
                chamber[row - 1][col + 1] = true;
            }
            if (row >= 0 && row <= 14 && col - 1 >= 0 && col - 1 <= 14) {
                chamber[row][col - 1] = true;
            }
            if (row >= 0 && row <= 14 && col >= 0 && col <= 14) {
                chamber[row][col] = true;
            }
            if (row >= 0 && row <= 14 && col + 1 >= 0 && col + 1 <= 14) {
                chamber[row][col + 1] = true;
            }
            if (row + 1 >= 0 && row + 1 <= 14 && col - 1 >= 0 && col - 1 <= 14) {
                chamber[row + 1][col - 1] = true;
            }
            if (row + 1 >= 0 && row + 1 <= 14 && col >= 0 && col <= 14) {
                chamber[row + 1][col] = true;
            }
            if (row + 1 >= 0 && row + 1 <= 14 && col >= 0 && col + 1 <= 14) {
                chamber[row + 1][col + 1] = true;
            }


            if (chamber[playerRow][playerCol]) {
                if (playerRow - 1 < 0 || chamber[playerRow - 1][playerCol]) {
                    if (playerCol + 1 > 14 || chamber[playerRow][playerCol + 1]) {
                        if (playerRow + 1 > 14 || chamber[playerRow + 1][playerCol]) {
                            if (playerCol - 1 < 0 || chamber[playerRow][playerCol - 1]) {
                                switch (spell) {
                                    case "Cloud":
                                        playerLife -= plagueDmg;
                                        activeCloud = true;
                                        if (playerLife <= 0) {
                                            playerIsDead = true;
                                        }
                                        break;
                                    case "Eruption":
                                        playerLife -= eruptionDmg;
                                        if (playerLife <= 0) {
                                            playerIsDead = true;
                                            diedFromEruption = true;
                                        }
                                        break;
                                }
                            } else {
                                playerCol--;
                            }
                        }else {
                            playerRow++;
                        }
                    } else {
                        playerCol++;
                    }
                } else {
                    playerRow--;
                }
            }
            chamber = new boolean[15][15];
        }

        if (heiganIsDead && playerIsDead) {
            System.out.println("Heigan: Defeated!");
            System.out.printf("Player: Killed by %s%n", "Plague Cloud");
            System.out.printf("Final position: %d, %d%n", playerRow, playerCol);
            return;
        }

        if (heiganIsDead) {
            System.out.println("Heigan: Defeated!");
            System.out.printf("Player: %d%n", playerLife);
            System.out.printf("Final position: %d, %d%n", playerRow, playerCol);
        }

        if (playerIsDead) {
            System.out.printf("Heigan: %.2f%n", heiganLife);
            System.out.printf("Player: Killed by %s%n", diedFromEruption ? "Eruption" : "Plague Cloud");
            System.out.printf("Final position: %d, %d%n", playerRow, playerCol);
        }
    }
}
