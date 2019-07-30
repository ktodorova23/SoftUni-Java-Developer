package kingsGambit;

import kingsGambit.entities.Footman;
import kingsGambit.entities.King;
import kingsGambit.entities.RoyalGuard;
import kingsGambit.interfaces.Defender;
import kingsGambit.interfaces.Target;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String kingsName = reader.readLine();

        String[] royalGuardsNames = reader.readLine().split("\\s+");
        String[] footmenNames = reader.readLine().split("\\s+");

        Map<String, Defender> units = new LinkedHashMap<>();

        for (String name : royalGuardsNames) {
            Defender royalGuard = new RoyalGuard(name);
            units.put(name, royalGuard);
        }

        for (String name : footmenNames) {
            Defender footman = new Footman(name);
            units.put(name, footman);
        }

        Target king = new King(kingsName, units);

        String line;
        while (!"End".equals(line = reader.readLine())) {
            String[] cmdArgs = line.split("\\s+");
            if (cmdArgs[0].equals("Attack")) {
                king.uponAttack();
            } else {
                units.remove(cmdArgs[1]);
            }
        }
    }
}
