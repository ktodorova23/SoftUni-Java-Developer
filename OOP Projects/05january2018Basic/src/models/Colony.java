package models;

import interfaces.ColonyInterface;
import models.colonists.Colonist;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Colony implements ColonyInterface {
    private int maxFamilyCount;
    private int maxFamilyCapacity;
    private Map<String, Family> families;

    public Colony(int maxFamilyCount, int maxFamilyCapacity) {
        this.maxFamilyCount = maxFamilyCount;
        this.maxFamilyCapacity = maxFamilyCapacity;
        this.families = new TreeMap<>();
    }

    public Family getFamilyById(String familyId) {
        return this.families.values().stream()
                .filter(f -> f.getId().equals(familyId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addColonist(Colonist colonist) {
        if (!this.families.containsKey(colonist.getFamilyId())) {
            if (this.families.size() < this.maxFamilyCount) {
                this.families.put(colonist.getFamilyId(), new Family(colonist.getFamilyId()));
            } else {
                System.out.println("colony is full");
            }
        }
        if (this.families.get(colonist.getFamilyId()).getSize() < this.maxFamilyCapacity) {
            this.families.get(colonist.getFamilyId()).addColonist(colonist);
        } else {
            System.out.println("family is full");
        }
    }

    @Override
    public void removeColonist(String familyId, String memberId) {
        if (this.families.containsKey(familyId)) {
            this.families.get(familyId).removeColonist(memberId);
        }

        if (this.families.get(familyId).getSize() == 0) {
            this.removeFamily(familyId);
        }
    }

    @Override
    public void removeFamily(String id) {
        this.families.remove(id);
    }

    public List<Colonist> getColonistsByFamilyId(String familyId) {
        return this.families.get(familyId).getColonists();
    }

    @Override
    public void grow(int years) {
        for (Map.Entry<String, Family> entry : this.families.entrySet()) {
            for (Colonist colonist : this.families.get(entry.getKey()).getColonists()) {
                colonist.grow(years);
            }
        }
    }

    @Override
    public int getPotential() {
        int potential = 0;

        for (Map.Entry<String, Family> entry : families.entrySet()) {
            for (Colonist colonist : this.families.get(entry.getKey()).getColonists()) {
                potential += colonist.getPotential();
            }
        }
        return potential;
    }

    @Override
    public String getCapacity() {
        StringBuilder sb = new StringBuilder(String.format("families: %d/%d%n",
                this.families.size(), this.maxFamilyCount));

        this.families.entrySet().forEach(f -> sb.append(String.format("-%s: %d/%d%n",
                f.getKey(), f.getValue().getSize(), this.maxFamilyCapacity)));
        return sb.toString().trim();
    }
}
