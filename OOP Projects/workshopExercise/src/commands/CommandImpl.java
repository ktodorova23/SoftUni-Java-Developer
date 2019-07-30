package commands;

import interfaces.Hardware;
import interfaces.Repository;

public class CommandImpl {
    private Repository repository;
    private Hardware hardware;

    protected CommandImpl(Repository repository, Hardware hardware) {
//        this.data = data;
        this.repository = repository;
        this.hardware = hardware;
    }

    public void interpretCommand(String[] data) {
        String commandName = "";

        if (data[0].contains("Register")) {

        }
    }
}
