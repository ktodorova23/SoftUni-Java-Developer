import core.MachinesManagerImpl;

import core.MachineFactoryImpl;
import core.PilotFactoryImpl;
import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        PilotFactory pilotFactory = new PilotFactoryImpl();
        MachineFactory machineFactory = new MachineFactoryImpl();
        Map<String, Pilot> pilots = new LinkedHashMap<>();
        Map<String, Machine> machines = new LinkedHashMap<>();

        MachinesManager machinesManager = new MachinesManagerImpl(pilotFactory, machineFactory, pilots, machines);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;

        while (!"Over".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");

            String command = tokens[0];

            switch (command) {
                case "Hire":
                    System.out.println(machinesManager.hirePilot(tokens[1]));
                    break;
                case "Report":
                    System.out.println(machinesManager.pilotReport(tokens[1]));
                    break;
                case "ManufactureTank":
                    System.out.println(machinesManager.manufactureTank(tokens[1], Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3])));
                    break;
                case "ManufactureFighter":
                    System.out.println(machinesManager.manufactureFighter(tokens[1], Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3])));
                    break;
                case "Engage":
                    System.out.println(machinesManager.engageMachine(tokens[1], tokens[2]));
                    break;
                case "Attack":
                    System.out.println(machinesManager.attackMachines(tokens[1], tokens[2]));
                    break;
                case "DefenseMode":
                    System.out.println(machinesManager.toggleTankDefenseMode(tokens[1]));
                    break;
                case "AggressiveMode":
                    System.out.println(machinesManager.toggleFighterAggressiveMode(tokens[1]));
                    break;
            }
        }


    }
}
