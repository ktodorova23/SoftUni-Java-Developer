package greedyTimes;

import java.util.HashMap;
import java.util.Map;

public class Bag {
    private long capacity;
    private long currentWeight;
    private long gold;
    private Map<String, Long> gems;
    private long totalGems;
    private Map<String, Long> cash;
    private long totalCash;
    private boolean goldIsAdded;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.currentWeight = 0;
        this.gold = 0;
        this.gems = new HashMap<>();
        this.totalGems = 0;
        this.cash = new HashMap<>();
        this.totalCash = 0;
        this.goldIsAdded = false;
    }

    public void addCash(String item, long quantity) {
        if (this.hasFreeCapacity(quantity) && this.totalGems >= this.totalCash + quantity) {
            this.cash.putIfAbsent(item, 0L);
            this.cash.put(item, this.cash.get(item) + quantity);

            this.currentWeight += quantity;
            this.totalCash += quantity;
        }
    }

    private boolean hasFreeCapacity(long weight) {
        return this.currentWeight + weight <= this.capacity;
    }

    public void addGems(String item, long quantity) {
        if (this.hasFreeCapacity(quantity) && this.gold >= this.totalGems + quantity) {
            this.gems.putIfAbsent(item, 0L);
            this.gems.put(item, this.gems.get(item) + quantity);

            this.currentWeight += quantity;
            this.totalGems += quantity;
        }
    }

    public void addGold(long weight) {
        if (hasFreeCapacity(weight)) {
            this.gold += weight;
            this.currentWeight += weight;
            this.goldIsAdded = true;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.goldIsAdded) {
            sb.append("<Gold> $").append(this.gold).append(System.lineSeparator());
            sb.append("##Gold - ").append(this.gold).append(System.lineSeparator());
        }
        if (this.gems.size() > 0) {
            sb.append("<Gem> $").append(this.totalGems).append(System.lineSeparator());
            this.gems.entrySet().stream()
                    .sorted(Map.Entry.<String, Long>comparingByKey().reversed().thenComparing(Map.Entry.comparingByValue()))
                    .forEach(g -> sb.append("##").append(g.getKey()).append(" - ").append(g.getValue()).append(System.lineSeparator()));
        }
        if (this.cash.size() > 0) {
            sb.append("<Cash> $").append(this.totalCash).append(System.lineSeparator());
            this.cash.entrySet().stream()
                    .sorted(Map.Entry.<String, Long>comparingByKey().reversed().thenComparing(Map.Entry.comparingByValue()))
                    .forEach(c -> sb.append("##").append(c.getKey()).append(" - ").append(c.getValue()).append(System.lineSeparator()));
        }
        return sb.toString();
    }
}
