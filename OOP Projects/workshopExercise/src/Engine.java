import interfaces.CommandInterpreter;
import interfaces.Runnable;

public class Engine implements Runnable {
    private CommandInterpreter commandInterpreter;

    public Engine(CommandInterpreter commandInterpreter) {
        this.commandInterpreter = commandInterpreter;
    }

    @Override
    public void run() {
        //TODO
    }
}
