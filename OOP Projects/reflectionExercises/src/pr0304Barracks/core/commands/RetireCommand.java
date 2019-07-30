package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Inject;
import pr0304Barracks.contracts.Repository;

public class RetireCommand extends CommandImpl {
    @Inject
    private Repository repository;

    protected RetireCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        try {
            this.repository.removeUnit(this.getData()[1]);
        } catch (IllegalArgumentException error) {
            return error.getMessage();
        }
        return this.getData()[1] + " retired!";
    }
}
