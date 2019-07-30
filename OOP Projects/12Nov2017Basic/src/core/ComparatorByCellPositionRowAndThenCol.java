package core;

import models.cells.Cell;

import java.util.Comparator;

public class ComparatorByCellPositionRowAndThenCol implements Comparator<Cell> {
    @Override
    public int compare(Cell first, Cell second) {
        int result = Integer.compare(first.getPositionRow(), second.getPositionRow());
        if (result == 0) {
            result = Integer.compare(first.getPositionCol(), second.getPositionCol());
        }
        return result;
    }
}
