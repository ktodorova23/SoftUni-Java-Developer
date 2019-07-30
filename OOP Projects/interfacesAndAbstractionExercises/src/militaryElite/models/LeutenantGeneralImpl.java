package militaryElite.models;

import militaryElite.interfaces.LeutenantGeneral;
import militaryElite.interfaces.Private;

import java.util.Comparator;
import java.util.TreeSet;

public class LeutenantGeneralImpl extends PrivateImpl implements LeutenantGeneral {
    private TreeSet<Private> privates;

    public LeutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new TreeSet<Private>(new Comparator<Private>() {
            @Override
            public int compare(Private first, Private second) {
                return second.getId() - first.getId();
            }
        });
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator()).append("Privates:");

        for (Private aPrivate : this.privates) {
            sb.append(System.lineSeparator());
            sb.append("  ").append(aPrivate.toString());
        }
        return sb.toString();
    }

    @Override
    public void addPrivate(Private soldier) {
        this.privates.add(soldier);
    }
}
