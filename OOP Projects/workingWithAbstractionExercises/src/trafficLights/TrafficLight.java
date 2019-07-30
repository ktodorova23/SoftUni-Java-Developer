package trafficLights;

public class TrafficLight {
    private LightStates lightState;

    public TrafficLight(LightStates lightState) {
        this.lightState = lightState;
    }

    public LightStates getLightState() {
        return lightState;
    }

    public void update() {
        switch (this.lightState) {
            case RED:
                this.lightState = LightStates.GREEN;
                break;
            case GREEN:
                this.lightState = LightStates.YELLOW;
                break;
            case YELLOW:
                this.lightState = LightStates.RED;
                break;

        }
    }
}
