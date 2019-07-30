package avatar.containers;

import java.util.Map;
import java.util.TreeMap;

public class WarStatistics {
    private int count;
    private Map<Integer, String> warInitiators;

    public WarStatistics() {
        this.count = 1;
        this.warInitiators = new TreeMap<>();
    }

    public void addWarInfo(String nation) {
        this.warInitiators.put(this.count++, nation);
    }

    public Map<Integer, String> getWarInitiators() {
        return this.warInitiators;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Integer, String> entry : warInitiators.entrySet()) {
            sb.append(String.format("War %d issued by %s\n", entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }
}
