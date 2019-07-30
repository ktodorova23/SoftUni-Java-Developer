import java.util.Arrays;
import java.util.Scanner;

public class parkingSystem {
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] dimensions = Arrays.stream(console.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        boolean[][] parkingLot = new boolean[rows][cols];
        for (int i = 0; i < parkingLot.length; i++) {
            parkingLot[i][0] = true;
        }
        String line = console.nextLine();
        int countSteps;
        while (!line.equals("stop")) {
            int[] tokens = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();

            int entryRow = tokens[0];
            int desiredRow = tokens[1];
            int desiredCol = tokens[2];

            if (entryRow >= 0 && entryRow < rows &&
                    desiredRow >= 0 && desiredRow < rows &&
                    desiredCol >= 0 && desiredCol < cols) {
                countSteps = Math.abs(entryRow - desiredRow) + 1;
                boolean foundParkingSpot = false;

                if (!parkingLot[desiredRow][desiredCol]) {
                    for (int i = 1; i <= desiredCol; i++) {
                        countSteps++;
                        foundParkingSpot = true;
                        parkingLot[desiredRow][desiredCol] = true;
                    }
                } else {
                    int tempColumn = -1;
                    int steps = 0;
                    for (int i = desiredCol; i >= 1; i--) {
                        int tempSteps = countSteps;
                        tempSteps = i + countSteps;
                        if (!parkingLot[desiredRow][i]) {
                            foundParkingSpot = true;
                            tempColumn = i;
                            steps = tempSteps;
                            break;
                        }
                    }

                    for (int i = desiredCol + 1; i < parkingLot[desiredRow].length; i++) {
                        int tempSteps = countSteps;
                        tempSteps = i + countSteps;
                        if (!parkingLot[desiredRow][i]) {
                            if (tempColumn != -1) {
                                if ((Math.abs(desiredCol - i) < Math.abs(desiredCol - tempColumn))) {
                                    foundParkingSpot = true;
                                    parkingLot[desiredRow][i] = true;
                                    tempColumn = -1;
                                    countSteps = tempSteps;
                                    steps = 0;
                                } else if (Math.abs(desiredCol - i) >= Math.abs(desiredCol - tempColumn)) {
                                        foundParkingSpot = true;
                                        parkingLot[desiredRow][tempColumn] = true;
                                        tempColumn = -1;
                                        countSteps = steps;
                                        steps = 0;
                                }
                            } else {
                                foundParkingSpot = true;
                                parkingLot[desiredRow][i] = true;
                                countSteps = tempSteps;
                            }
                            break;
                        }
                    }

                    if (foundParkingSpot && tempColumn != -1 && steps != 0) {
                        parkingLot[desiredRow][tempColumn] = true;
                        countSteps = steps;
                    }
                }

                if (foundParkingSpot) {
                    System.out.println(countSteps);
                } else {
                    System.out.println(String.format("Row %d full", desiredRow));
                }
            }

            line = console.nextLine();
        }
    }
}
