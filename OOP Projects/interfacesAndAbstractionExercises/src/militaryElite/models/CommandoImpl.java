package militaryElite.models;

import militaryElite.enumerations.Corp;
import militaryElite.general.Mission;
import militaryElite.interfaces.Commando;

import java.util.ArrayList;
import java.util.List;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private List<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator()).append("Missions:");

        for (Mission mission : this.missions) {
            sb.append(System.lineSeparator());
            sb.append("  ").append(mission.toString());
        }
        return sb.toString();
    }
}
