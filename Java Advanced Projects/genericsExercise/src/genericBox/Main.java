package genericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(reader.readLine());

        List<Box<Double>> listOfBoxes = new ArrayList<>();

        while (rows-- > 0) {
            double line = Double.parseDouble(reader.readLine());
            Box box = new Box(line);

            listOfBoxes.add(box);
        }

        double line = Double.parseDouble(reader.readLine());

        Box box = new Box(line);

        System.out.println(countGreaterElements(listOfBoxes, box));
    }

    private static <T extends Comparable<T>, B extends Box<T>> int countGreaterElements (List<B> listOfBoxes, Box<T> box) {
        int counter = 0;

        for (Box<T> current : listOfBoxes) {
            if (current.compareTo(box) > 0) {
                counter++;
            }
        }
        return counter;
    }

}
