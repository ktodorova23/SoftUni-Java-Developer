import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class printerQueue {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String line = console.nextLine();

        Deque<String> printerQueue = new ArrayDeque<>();

        while (!line.equals("print")) {
            if (!line.equals("cancel")) {
                printerQueue.offer(line);
            } else {
                if (printerQueue.size() > 0) {
                    String canceledJob = printerQueue.poll();
                    System.out.println("Canceled " + canceledJob);
                } else {
                    System.out.println("Printer is on standby");
                }
            }

            line = console.nextLine();
        }
        while (!printerQueue.isEmpty()) {
            System.out.println(printerQueue.poll());
        }
    }
}
