package models.clusters;

import core.ComparatorByCellPositionRowAndThenCol;
import models.cells.Cell;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Cluster {
    private String id;
    private int rows;
    private int cols;
    private Map<String, Cell> cells;

    public Cluster(String id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.cells = new TreeMap<>();
    }

    public String getId() {
        return this.id;
    }

    public int getRows() {
        return this.rows;
    }

    public int getCols() {
        return this.cols;
    }

    public Map<String, Cell> getCells() {
        return this.cells;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("o----Cluster %s%n", this.id));
        this.cells.values().stream()
                .sorted(new ComparatorByCellPositionRowAndThenCol())
                .forEach(c -> sb.append(c.toString()));
        return sb.toString().trim();
    }

    public void addCell(Cell cell) {
        this.cells.put(cell.getId(), cell);
    }
}
