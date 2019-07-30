package avatar.entities.nations;

import avatar.entities.benders.EarthBender;
import avatar.entities.monuments.EarthMonument;
import avatar.interfaces.Bender;
import avatar.interfaces.Monument;
import avatar.interfaces.Nation;

import java.util.LinkedHashMap;
import java.util.Map;

public class EarthNation implements Nation {
    private Map<String, EarthBender> benders;
    private Map<String, EarthMonument> monuments;
    private double power;

    public EarthNation() {
        this.benders = new LinkedHashMap<>();
        this.monuments = new LinkedHashMap<>();
        this.power = 0;
    }

    private void setPower(double value) {
        this.power = value;
    }

    @Override
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

        for (EarthBender bender : this.benders.values()) {
            totalPower += bender.getTotalPower();
        }
        return totalPower;
    }

    @Override
    public void getBonusFromMonuments() {
        double totalBonuses = 0;

        if (!this.monuments.isEmpty()) {
            for (EarthMonument monument : this.monuments.values()) {
                totalBonuses += monument.getAffinity();
            }
        }

        double bonus = (this.calculateTotalPower() / 100) * totalBonuses;
        this.setPower(this.calculateTotalPower() + bonus);
    }

    @Override
    public void addBender(Bender bender) {
        this.benders.putIfAbsent(bender.getName(), (EarthBender) bender);
    }

    @Override
    public void addMonument(Monument monument) {
        this.monuments.putIfAbsent(monument.getName(), (EarthMonument) monument);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Warth Nation\n");

        if (this.benders.isEmpty()) {
            sb.append("Benders: None\n");
        } else {
            sb.append("Benders:\n");
            for (EarthBender bender : benders.values()) {
                sb.append("###").append(bender.toString()).append("\n");
            }
        }

        if (this.monuments.isEmpty()) {
            sb.append("Monuments: None\n");
        } else {
            sb.append("Monuments:\n");
            for (EarthMonument monument : this.monuments.values()) {
                sb.append("###").append(monument.toString()).append("\n");
            }
        }

        return sb.toString();
    }
}
