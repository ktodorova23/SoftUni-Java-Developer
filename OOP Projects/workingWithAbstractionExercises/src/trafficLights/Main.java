package trafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = reader.readLine().split("\\s+");
        int switches = Integer.parseInt(reader.readLine());

        ArrayList<TrafficLight> trafficLights = new ArrayList<>();

        for (String input : inputs) {
            TrafficLight trafficLight = new TrafficLight(LightStates.valueOf(input));
            trafficLights.add(trafficLight);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < switches; i++) {
            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.update();
                sb.append(trafficLight.getLightState().toString()).append(" ");
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb);
    }
}
