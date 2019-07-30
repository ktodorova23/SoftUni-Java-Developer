package constructors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);

        int rows = Integer.parseInt(console.nextLine());

        IntStream
                .rangeClosed(1, rows)
                .boxed()
                .map(n -> console.nextLine().split("\\s+"))
                .map(data -> {
                    Car current;
                    if (data.length == 1) {
                        current = new Car(data[0]);
                    } else {
                        current = new Car(data[0], data[1], Integer.parseInt(data[2]));
                    }
                    return current;
                })
                .forEach(car -> System.out.println(car.getInfo()));
    }
}
