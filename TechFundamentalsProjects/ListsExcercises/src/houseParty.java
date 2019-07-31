import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class houseParty {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int lines = Integer.parseInt(console.nextLine());

        List<String> guests = new ArrayList<>();

        while (lines > 0) {
            String input = console.nextLine();

            String[] guestCheck = input.split("\\s+");

            String name = guestCheck[0];
            if (!guestCheck[2].equals("not")) {
                if (!guests.contains(name)) {
                    guests.add(name);
                } else {
                    System.out.println(name + " is already in the list!");
                }
            } else {
                if (guests.contains(name)) {
                    guests.remove(name);
                } else {
                    System.out.println(name + " is not in the list!");
                }
            }
            lines--;
        }

        for (String aGuests : guests) {
            System.out.println(aGuests);
        }
    }
}
