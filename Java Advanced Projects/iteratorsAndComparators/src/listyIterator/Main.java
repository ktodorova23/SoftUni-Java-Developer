package listyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        ListyIterator listyIterator = new ListyIterator();
        Arrays.stream(reader.readLine()
                .split("\\s+"))
                .skip(1)
                .forEach(listyIterator::add);

        String line;
        while (!"END".equals(line = reader.readLine())) {
            if (line.equals("Print")) {
                try {
                    System.out.println(listyIterator.print());
                } catch (Exception e) {
                    System.out.println("Invalid Operation!");
                }
            } else if (line.equals("Move")) {
                System.out.println(listyIterator.move());
            } else if (line.equals("HasNext")) {
                System.out.println(listyIterator.hasNext());
            } else {
                if (listyIterator.getData().size() == 0) {
                    System.out.println("Invalid Operation!");
                } else {
                    for (String data : listyIterator.getData()) {
                        System.out.print(data + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
