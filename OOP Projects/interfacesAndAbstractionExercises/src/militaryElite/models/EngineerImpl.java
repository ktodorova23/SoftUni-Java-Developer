package militaryElite.models;

import militaryElite.general.Repair;
import militaryElite.interfaces.Engineer;

import java.util.ArrayList;
import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private List<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator()).append("Repairs:");

        for (Repair repair : this.repairs) {
            sb.append(System.lineSeparator());
            sb.append("  ").append(repair.toString());
        }
        return sb.toString();
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }
}
