package avatar.entities.monuments;

import avatar.interfaces.Monument;

public abstract class MonumentImpl implements Monument {
    private String name;
    private long affinity;

    protected MonumentImpl(String name, long affinity) {
        this.name = name;
        this.affinity = affinity;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public long getAffinity() {
        return this.affinity;
    }


}
