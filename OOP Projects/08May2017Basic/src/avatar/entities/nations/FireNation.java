package avatar.entities.nations;

import avatar.entities.benders.FireBender;
import avatar.entities.monuments.FireMonument;
import avatar.interfaces.Bender;
import avatar.interfaces.Monument;
import avatar.interfaces.Nation;

import java.util.LinkedHashMap;
import java.util.Map;

public class FireNation implements Nation {
    private Map<String, FireBender> benders;
    private Map<String, FireMonument> monuments;
    private double power;

    public FireNation() {
        this.benders = new LinkedHashMap<>();
        this.monuments = new LinkedHashMap<>();
        this.power = 0;
    }

    private void setPower(double value) {
        this.power = value;
    }

    public double getPower() {
        return this.power;
    }

    @Override
    public void emptyArmy() {
        this.benders.clear();
        this.monuments.clear();
    }

    @Override
    public double calculateTotalPower() {
        double totalPower = 0;

        for (FireBender bender : this.benders.values()) {
            totalPower += bender.getTotalPower();
        }
        return totalPower;
    }

    @Override
    public void getBonusFromMonuments() {
            double totalBonuses = 0;

            if (!this.monuments.isEmpty()) {
                for (FireMonument monument : this.monuments.values()) {
                    totalBonuses += monument.getAffinity();
                }
            }

            double bonus = (this.calculateTotalPower() / 100) * totalBonuses;
            this.setPower(this.calculateTotalPower() + bonus);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Fire Nation\n");

        if (this.benders.isEmpty()) {
            sb.append("Benders: None\n");
        } else {
            sb.append("Benders:\n");
            for (FireBender bender : benders.values()) {
                sb.append("###").append(bender.toString()).append("\n");
            }
        }

        if (this.monuments.isEmpty()) {
            sb.append("Monuments: None\n");
        } else {
            sb.append("Monuments:\n");
            for (FireMonument monument : this.monuments.values()) {
                sb.append("###").append(monument.toString()).append("\n");
            }
        }

        return sb.toString();
    }

    @Override
    public void addBender(Bender bender) {
        this.benders.putIfAbsent(bender.getName(), (FireBender) bender);
    }

    @Override
    public void addMonument(Monument monument) {
        this.monuments.putIfAbsent(monument.getName(), (FireMonument) monument);
    }
}
