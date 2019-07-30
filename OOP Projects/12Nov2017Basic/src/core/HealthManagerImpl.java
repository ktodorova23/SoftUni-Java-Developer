package core;

import interfaces.HealthManager;
import models.Organism;
import models.cells.Cell;
import models.clusters.Cluster;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;

public class HealthManagerImpl implements HealthManager {
    private static final String CELLS_PACKAGE = "models.cells.";

    private Map<String, Organism> organisms;

    public HealthManagerImpl() {
        this.organisms = new TreeMap<>();
    }

    @Override
    public String checkCondition(String organismName) {
        return this.organisms.get(organismName).toString();
    }

    @Override
    public String createOrganism(String name) {
        String resultMsg = "";

        if (!this.organisms.containsKey(name)) {
            this.organisms.put(name, new Organism(name));
            resultMsg = "Created organism " + name;
        } else {
            resultMsg = String.format("Organism %s already exists", name);
        }
        return resultMsg;
    }

    @Override
    public String addCluster(String organismName, String id, int rows, int cols) {
        if (!this.organisms.get(organismName).getClusters().containsKey(id)) {
            this.organisms.get(organismName).addCluster(id, rows, cols);
            return String.format("Organism %s: Created cluster %s", organismName, id);
        }
        return null;
    }

    @Override
    public String addCell(String organismName, String clusterId,
                          String cellType,
                          String cellId, int health, int positionRow, int positionCol,
                          int additionalProperty) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        if (this.organisms.containsKey(organismName)) {
            if (this.organisms.get(organismName).getClusters().containsKey(clusterId)) {
                Cluster cluster = this.organisms.get(organismName).getClusters().get(clusterId);
                if (positionRow >= 0 && positionRow < cluster.getRows() && positionCol >= 0 && positionCol < cluster.getCols()) {
                    Class cellClass = Class.forName(HealthManagerImpl.CELLS_PACKAGE + cellType);

                    Constructor<? extends Cell> cellConstructor = cellClass.getDeclaredConstructor
                            (String.class, int.class, int.class, int.class, int.class);
                    cellConstructor.setAccessible(true);

                    Cell cell = cellConstructor.newInstance(cellId, health, positionRow, positionCol, additionalProperty);

                    this.organisms.get(organismName).getClusters().get(clusterId).addCell(cell);
                    return String.format("Organism %s: Created cell %s in cluster %s",
                            organismName, cellId, clusterId);
                }

            }
        }
        return null;
    }

    //TODO needs to be finished
    @Override
    public String activateCluster(String organismName) {
        this.organisms.get(organismName);
        return null;
    }
}
