package avatar.factories;


import avatar.entities.benders.AirBender;
import avatar.entities.benders.EarthBender;
import avatar.entities.benders.FireBender;
import avatar.entities.benders.WaterBender;
import avatar.interfaces.Bender;

public class BenderFactory {
    BenderFactory () {}

    public static Bender createBender(String type, String name, long power, double additionalProperty) {
        Bender bender = null;

        switch (type) {
            case "Air":
                bender = new AirBender(name, power, additionalProperty);
                break;
            case "Fire":
                bender = new FireBender(name, power, additionalProperty);
                break;
            case "Water":
                bender = new WaterBender(name, power, additionalProperty);
                break;
            case "Earth":
                bender = new EarthBender(name, power, additionalProperty);
                break;
        }
        return bender;
    }
}
