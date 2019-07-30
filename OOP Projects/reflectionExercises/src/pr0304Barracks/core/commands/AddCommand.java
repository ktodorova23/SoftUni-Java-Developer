package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Inject;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

public class AddCommand extends CommandImpl {
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    protected AddCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        this.repository.addUnit(this.unitFactory.createUnit(getData()[1]));
        return getData()[1] + " added!";
    }
}
