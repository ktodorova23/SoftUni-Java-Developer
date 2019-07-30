package pr0304Barracks.core;

import pr0304Barracks.contracts.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {
    private static final String COMMANDS_PACKAGE = "pr0304Barracks.core.commands.";

    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data) {
        String commandName = Character.toUpperCase(data[0].charAt(0)) + data[0].substring(1) + "Command";

        Executable executable = null;

        try {
            Class<? extends Executable> commandClass =
                    (Class<? extends Executable>) Class.forName(CommandInterpreterImpl.COMMANDS_PACKAGE + commandName);

            Constructor<? extends Executable> constructor =
                    commandClass.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);
            executable = constructor.newInstance(new Object[]{data});

            Field[] executableFields = executable.getClass().getDeclaredFields();
            Field[] thisCommandInterpreterFields = this.getClass().getDeclaredFields();

            for (Field executableField : executableFields) {
                if (executableField.isAnnotationPresent(Inject.class)) {
                    for (Field field : thisCommandInterpreterFields) {
                        if (executableField.getType().equals(field.getType())) {
                            executableField.setAccessible(true);
                            executableField.set(executable, field.get(this));
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return executable;
    }
}
