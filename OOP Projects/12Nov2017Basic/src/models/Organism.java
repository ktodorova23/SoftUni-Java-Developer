package models;

import models.clusters.Cluster;

import java.util.Map;
import java.util.TreeMap;

public class Organism {
    private String name;
    private Map<String, Cluster> clusters;

    public Organism(String name) {
        this.name = name;
        this.clusters = new TreeMap<String, Cluster>();
    }

    public Map<String, Cluster> getClusters() {
        return this.clusters;
    }

    public void addCluster(String id, int rows, int cols) {
        this.clusters.put(id, new Cluster(id, rows, cols));
    }

    private int getTotalCountOfCells() {
        int result = 0;

        for (Cluster cluster : this.clusters.values()) {
            result += cluster.getCells().size();
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("Organism - %s%n" +
                        "--Clusters: %d%n" +
                        "--Cells: %d%n",
                this.name,
                this.clusters.size(),
                this.getTotalCountOfCells()));
        this.clusters.entrySet().forEach(k -> sb.append(k.getValue().toString()));
        return sb.toString().trim();

    }
}
