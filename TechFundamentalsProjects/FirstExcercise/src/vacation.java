import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class vacation {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader((System.in)));
        int groupNumber = Integer.valueOf(console.readLine());
        String type = console.readLine();
        String weekDay = console.readLine();

        double pricePerOne = -1;

        switch (type) {
            case "Students":
                switch (weekDay) {
                    case "Friday":
                        pricePerOne = 8.45;
                        break;
                    case "Saturday":
                        pricePerOne = 9.80;
                        break;
                    case "Sunday":
                        pricePerOne = 10.46;
                        break;
                }
                break;
            case "Business":
                switch (weekDay) {
                    case "Friday":
                        pricePerOne = 10.90;
                        break;
                    case "Saturday":
                        pricePerOne = 15.60;
                        break;
                    case "Sunday":
                        pricePerOne = 16;
                        break;
                }
                break;
            case "Regular":
                switch (weekDay) {
                    case "Friday":
                        pricePerOne = 15;
                        break;
                    case "Saturday":
                        pricePerOne = 20;
                        break;
                    case "Sunday":
                        pricePerOne = 22.50;
                        break;
                }
                break;
        }


        double priceTotal = pricePerOne * groupNumber;

        if (groupNumber >= 30 && type. equals("Students")) {
            priceTotal = groupNumber * pricePerOne - ((groupNumber * pricePerOne) * 0.15);
        }

        if (groupNumber >= 100 && type.equals("Business")) {
            priceTotal = (groupNumber - 10) * pricePerOne;
        }

        if (groupNumber >= 10 && groupNumber <= 20 && type. equals("Regular")) {
            priceTotal = (groupNumber * pricePerOne) - ((groupNumber * pricePerOne) * 0.05);
        }

        System.out.printf("Total price: %.2f", priceTotal);

    }
}
