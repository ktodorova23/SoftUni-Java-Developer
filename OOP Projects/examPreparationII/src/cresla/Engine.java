package cresla;

import cresla.interfaces.InputReader;
import cresla.interfaces.Manager;
import cresla.interfaces.OutputWriter;
import cresla.io.InputReaderImpl;
import cresla.io.OutputWriterImpl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine {
    private InputReader reader;
    private OutputWriter writer;

    public Engine() {
        this.reader = new InputReaderImpl();
        this.writer = new OutputWriterImpl();
    }

    public void run() throws IOException {

        Manager manager = new ManagerImpl();

        String line;

        while (!"Exit".equals(line = reader.readLine())) {
            List<String> command = Arrays.stream(line.split("\\s+")).collect(Collectors.toList());
            List<String> arguments = command.stream().skip(1).collect(Collectors.toList());

            switch (command.get(0)) {
                case "Reactor":
                    writer.writeLine(manager.reactorCommand(arguments));
                    break;
                case "Module":
                    writer.writeLine(manager.moduleCommand(arguments));
                    break;
                case "Report":
                    writer.write(manager.reportCommand(arguments));
                    break;
            }
        }

        writer.write(manager.exitCommand(null));
    }
}
