import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class advertisementMessage {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int rows = Integer.parseInt(console.nextLine());

        Random rnd = new Random();

        String[] phrases = {"Excellent product.",
                "Such a great product.",
                "I always use that product.",
                "Best product of its category.",
                "Exceptional product.",
                "I can’t live without this product."};

        String[] events = {"Now I feel good.",
                "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.",
                "I feel great!"};

        String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};

        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        for (int i = 0; i < rows; i++) {
            int randomPhrase = rnd.nextInt(phrases.length);
            int randomEvent = rnd.nextInt(events.length);
            int randomAuthor = rnd.nextInt(authors.length);
            int randomCity = rnd.nextInt(cities.length);
            System.out.println(phrases[randomPhrase] + " " + events[randomEvent] + " " + authors[randomAuthor] + " - " + cities[randomCity]);
        }
    }
}
