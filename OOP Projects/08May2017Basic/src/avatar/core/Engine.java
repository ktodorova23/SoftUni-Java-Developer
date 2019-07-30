package avatar.core;

import avatar.containers.WarStatistics;
import avatar.entities.nations.AirNation;
import avatar.entities.nations.EarthNation;
import avatar.entities.nations.FireNation;
import avatar.entities.nations.WaterNation;
import avatar.factories.BenderFactory;
import avatar.factories.MonumentFactory;
import avatar.interfaces.*;
import avatar.io.InputReaderImpl;
import avatar.io.OutputWriterImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Engine {
    private InputReader reader;
    private OutputWriter writer;

    public Engine() {
        this.reader = new InputReaderImpl();
        this.writer = new OutputWriterImpl();
    }

    public void run() throws IOException {
        List<Nation> nations = new ArrayList<>();
        nations.add(null);
        nations.add(null);
        nations.add(null);
        nations.add(null);

        WarStatistics war = new WarStatistics();

        String line;
        while (!"Quit".equals(line = this.reader.readLine())) {
            String[] arguments = line.split("\\s+");

            switch (arguments[0]) {
                case "Bender":
                    Bender bender = BenderFactory.createBender(arguments[1], arguments[2], Long.parseLong(arguments[3]), Double.parseDouble(arguments
                            [4]));
                    if (arguments[1].equals("Fire")) {
                        if (nations.get(2) == null) {
                            nations.set(2, new FireNation());
                        }
                        nations.get(2).addBender(bender);
                    } else if (arguments[1].equals("Air")) {
                        if (nations.get(0) == null) {
                            nations.set(0, new AirNation());
                        }
                        nations.get(0).addBender(bender);
                    } else if (arguments[1].equals("Water")) {
                        if (nations.get(3) == null) {
                            nations.set(3, new WaterNation());
                        }
                        nations.get(3).addBender(bender);
                    } else {
                        if (nations.get(1) == null) {
                            nations.set(1, new EarthNation());
                        }
                        nations.get(1).addBender(bender);
                    }
                    break;
                case "Monument":
                    Monument monument = MonumentFactory.createMonument(arguments[1], arguments[2], Long.parseLong(arguments[3]));
                    if (arguments[1].equals("Fire")) {
                        if (nations.get(2) == null) {
                            nations.set(2, new FireNation());
                        }
                        nations.get(2).addMonument(monument);
                    } else if (arguments[1].equals("Air")) {
                        if (nations.get(0) == null) {
                            nations.set(0, new AirNation());
                        }
                        nations.get(0).addMonument(monument);
                    } else if (arguments[1].equals("Water")) {
                        if (nations.get(3) == null) {
                            nations.set(3, new WaterNation());
                        }
                        nations.get(3).addMonument(monument);
                    } else {
                        if (nations.get(1) == null) {
                            nations.set(1, new EarthNation());
                        }
                        nations.get(1).addMonument(monument);
                    }
                    break;
                case "Status":
                    if (arguments[1].equals("Fire") && nations.get(2) != null) {
                        this.writer.write(nations.get(2).toString());
                    } else if (arguments[1].equals("Air") && nations.get(0) != null) {
                        this.writer.write(nations.get(0).toString());
                    } else if (arguments[1].equals("Water") && nations.get(3) != null) {
                        this.writer.write(nations.get(3).toString());
                    } else if (arguments[1].equals("Earth") && nations.get(1) != null) {
                        this.writer.write(nations.get(1).toString());
                    }
                    break;
                case "War":
                    war.addWarInfo(arguments[1]);

                    List<Nation> list = nations.stream().filter(Objects::nonNull).collect(Collectors.toList());

                    if (!list.isEmpty()) {
                        Nation nation = list.get(0);

                        for (int i = 1; i < list.size(); i++) {
                            if (nation.getPower() > list.get(i).getPower()) {
                                list.get(i).emptyArmy();
                            } else {
                                nation.emptyArmy();
                                nation = list.get(i);
                            }
                        }
//                        for (Nation entry : list) {
//                            if (nation.getPower() > entry.getPower()) {
//                                entry.emptyArmy();
//                            } else {
//                                nation.emptyArmy();
//                                nation = entry;
//                            }
//                        }
                    }
                    break;
            }
        }

        this.writer.write(war.toString());
    }
}
