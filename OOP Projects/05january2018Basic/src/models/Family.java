package models;

import models.colonists.Colonist;

import java.util.*;

public class Family {
    private String id;
    private Map<String, Colonist> colonists;

    public Family(String id) {
        this.id = id;
        this.colonists = new TreeMap<>();
    }

    public String getId() {
        return this.id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public List<Colonist> getColonists() {
        return List.copyOf(this.colonists.values());
    }

    public void addColonist(Colonist colonist) {
        this.colonists.put(colonist.getId(), colonist);
    }

    public int getSize() {
        return this.colonists.size();
    }


    public void removeColonist(String memberId) {
        if (this.colonists.containsKey(memberId)) {
            this.colonists.remove(memberId);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.id + ":" + System.lineSeparator());

        this.colonists.values().stream().forEach(colonist -> {
            sb.append("-").append(colonist.getId()).append(": ").append(colonist.getPotential()).append(System.lineSeparator());
        });

        return sb.toString().trim();
    }
}
