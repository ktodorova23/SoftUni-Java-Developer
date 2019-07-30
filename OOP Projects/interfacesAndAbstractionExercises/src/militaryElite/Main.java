package militaryElite;

import militaryElite.enumerations.Corp;
import militaryElite.enumerations.State;
import militaryElite.general.Mission;
import militaryElite.general.Repair;
import militaryElite.interfaces.*;
import militaryElite.models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Private> soldiers = new ArrayList<>();
        List<Soldier> army = new ArrayList<>();

        String line;
        while (!"End".equals(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");
            int id = Integer.parseInt(tokens[1]);
            String firstName = tokens[2];
            String lastName = tokens[3];

            switch (tokens[0]) {
                case "Private":
                    Private person = new PrivateImpl(id, firstName, lastName, Double.parseDouble(tokens[4]));
                    soldiers.add(person);
                    army.add(person);
                    break;
                case "LeutenantGeneral":
                    LeutenantGeneral leutenantGeneral = new LeutenantGeneralImpl(id, firstName, lastName, Double.parseDouble(tokens[4]));
                    int[] privateIds = Arrays.stream(tokens).skip(5).mapToInt(Integer::parseInt).toArray();
                    for (int privateId : privateIds) {
                        for (Private soldier : soldiers) {
                            if (soldier.getId() == privateId) {
                                leutenantGeneral.addPrivate(soldier);
                                break;
                            }
                        }
                    }
                    army.add(leutenantGeneral);
                    break;
                case "Engineer":
                    if (Corp.Airforces.toString().equals(tokens[5]) || Corp.Marines.toString().equals(tokens[5])) {
                        Engineer engineer = new EngineerImpl(id, firstName, lastName, Double.parseDouble(tokens[4]),
                                tokens[5]);
                        String[] repairData = Arrays.stream(tokens).skip(6).toArray(String[]::new);
                        for (int i = 0; i < repairData.length; i += 2) {
                            Repair repair = new Repair(repairData[i], Integer.parseInt(repairData[i + 1]));
                            engineer.addRepair(repair);
                        }
                        army.add(engineer);
                    }

                    break;
                case "Commando":
                    if (Corp.Airforces.toString().equals(tokens[5]) || Corp.Marines.toString().equals(tokens[5])) {
                        Commando commando = new CommandoImpl(id, firstName, lastName, Double.parseDouble(tokens[4]),
                                tokens[5]);
                        String[] missionsData = Arrays.stream(tokens).skip(6).toArray(String[]::new);
                        for (int i = 0; i < missionsData.length; i += 2) {
                            if (State.Finished.toString().equals(missionsData[i + 1]) || State.inProgress.toString().equals(missionsData[i + 1])) {
                                Mission mission = new Mission(missionsData[i], missionsData[i + 1]);
                                commando.addMission(mission);
                            }
                        }
                        army.add(commando);
                    }
                    break;
                case "Spy":
                    Spy spy = new SpyImpl(id, firstName, lastName, tokens[4]);
                    army.add(spy);
                    break;
            }
        }
        for (Soldier soldier : army) {
            System.out.println(soldier.toString());
        }
    }
}
