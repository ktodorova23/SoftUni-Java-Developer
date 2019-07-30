package avatar.factories;

import avatar.entities.monuments.AirMonument;
import avatar.entities.monuments.EarthMonument;
import avatar.entities.monuments.FireMonument;
import avatar.entities.monuments.WaterMonument;
import avatar.interfaces.Monument;

public class MonumentFactory {
    
    MonumentFactory() {}

    public static Monument createMonument(String type, String name, long affinity) {
        Monument monument = null;

        switch (type) {
            case "Air":
                monument = new AirMonument(name, affinity);
                break;
            case "Fire":
                monument = new FireMonument(name, affinity);
                break;
            case "Water":
                monument = new WaterMonument(name, affinity);
                break;
            case "Earth":
                monument = new EarthMonument(name, affinity);
                break;
        }
        return monument;
    }
}
