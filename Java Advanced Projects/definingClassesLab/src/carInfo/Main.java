package carInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(reader.readLine());

        for (int i = 0; i < rows; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            Car car = new Car();
            car.setMake(tokens[0]);
            car.setModel(tokens[1]);
            car.setHorsePower(Integer.parseInt(tokens[2]));

            System.out.println(car.getInfo());
        }
    }
}
