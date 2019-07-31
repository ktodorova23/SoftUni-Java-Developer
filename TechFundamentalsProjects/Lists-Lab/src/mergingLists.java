import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class mergingLists {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<Integer> firstRow = Arrays.stream(console.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondRow = Arrays.stream(console.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int sizeOfLists = Math.min(firstRow.size(), secondRow.size());

        List<Integer> newList = new ArrayList<>();

        for (int i = 0; i < sizeOfLists; i++) {
            newList.add(firstRow.get(i));
            newList.add(secondRow.get(i));
        }


        if (firstRow.size() > secondRow.size()) {
            newList.addAll(getRemainingElements(firstRow, secondRow));
        } else if (firstRow.size() < secondRow.size()) {
            newList.addAll(getRemainingElements(secondRow, firstRow));
        }

        for (Integer aNewList : newList) {
            System.out.print(aNewList + " ");
        }
    }

    static List<Integer> getRemainingElements(List<Integer> longerList, List<Integer> shorterList) {
        int difference = longerList.size() - shorterList.size();

        List<Integer> aditionalNumbers = new ArrayList<>();

        for (int i = shorterList.size(); i < longerList.size(); i++) {
            aditionalNumbers.add(longerList.get(i));
        }
        return aditionalNumbers;
    }
}
