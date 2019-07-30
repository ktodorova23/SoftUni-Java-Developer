import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class roboticsFromLecture {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] roboData = console.nextLine().split(";");

        String[] robots = new String[roboData.length];
        int[] workingTime = new int[roboData.length];
        int[] processTime = new int[roboData.length];

        for (int i = 0; i < roboData.length; i++) {
            robots[i] = roboData[i].split("-")[0];
            workingTime[i] = Integer.parseInt(roboData[i].split("-")[1]);
        }

        String[] timeData = console.nextLine().split(":");

        int hours = Integer.parseInt(timeData[0]);
        int minutes = Integer.parseInt(timeData[1]);
        int seconds = Integer.parseInt(timeData[2]);

        int startTime = hours * 3600 + minutes * 60 + seconds;

        int time = 0;

        Deque<String> products = new ArrayDeque<>();

        String currentProduct = console.nextLine();

        while (!currentProduct.equals("End")) {
            products.offer(currentProduct);
            currentProduct = console.nextLine();
        }

        while (!products.isEmpty()) {
            time++;

            String product = products.pollFirst();
            boolean isAssigned = false;

            for (int i = 0; i < robots.length; i++) {
                if (processTime[i] == 0 && !isAssigned) {
                    processTime[i] = workingTime[i];
                    printTask(robots[i], startTime + time, product);
                    isAssigned = true;
                }
                if (processTime[i] > 0) {
                    processTime[i]--;
                }
            }

            if (!isAssigned) {
                products.offer(product);
            }
        }
    }

    private static void printTask(String robot, int time, String product) {
        int hours = (time / 3600) % 24;
        int minutes = (time / 60) % 60;
        int seconds = time % 60;

        DecimalFormat format = new DecimalFormat("00");

        System.out.println(String.format("%s - %s [%s:%s:%s]", robot, product,
                format.format(hours), format.format(minutes), format.format(seconds)));
    }
}
