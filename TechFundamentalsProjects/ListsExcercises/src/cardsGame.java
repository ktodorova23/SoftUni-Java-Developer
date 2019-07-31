import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class cardsGame {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<Integer> firstPlayerCards = Arrays.stream(console.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondPlayerCards = Arrays.stream(console.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (true) {
            if (firstPlayerCards.size() == 0 || secondPlayerCards.size() == 0) {
                break;
            }

            if (firstPlayerCards.get(0) > secondPlayerCards.get(0)) {
                firstPlayerCards.add(firstPlayerCards.get(0));
                firstPlayerCards.add(secondPlayerCards.get(0));
                firstPlayerCards.remove(Integer.valueOf(firstPlayerCards.get(0)));
                secondPlayerCards.remove(Integer.valueOf(secondPlayerCards.get(0)));
            } else if (firstPlayerCards.get(0).equals(secondPlayerCards.get(0))) {
                firstPlayerCards.remove(Integer.valueOf(firstPlayerCards.get(0)));
                secondPlayerCards.remove(Integer.valueOf(secondPlayerCards.get(0)));
            } else {
                secondPlayerCards.add(secondPlayerCards.get(0));
                secondPlayerCards.add(firstPlayerCards.get(0));
                firstPlayerCards.remove(Integer.valueOf(firstPlayerCards.get(0)));
                secondPlayerCards.remove(Integer.valueOf(secondPlayerCards.get(0)));

        }
    }

    int sum = 0;

        if(firstPlayerCards.size()!=0)

    {
        for (int i = 0; i < firstPlayerCards.size(); i++) {
            sum += firstPlayerCards.get(i);
        }
        System.out.printf("First player wins! Sum: %d", sum);
    } else

    {
        for (int i = 0; i < secondPlayerCards.size(); i++) {
            sum += secondPlayerCards.get(i);
        }
        System.out.printf("Second player wins! Sum: %d", sum);
    }


}
}
