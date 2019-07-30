package cresla;

import cresla.entities.modules.CooldownSystem;
import cresla.entities.modules.CryogenRod;
import cresla.entities.modules.HeatProcessor;
import cresla.entities.reactors.CryoReactor;
import cresla.entities.reactors.HeatReactor;
import cresla.interfaces.*;
import cresla.interfaces.Module;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ManagerImpl implements Manager {
    private int id;
    private Map<Integer, Reactor> reactors;
    private Map<Integer, Module> modules;

    public ManagerImpl() {
        this.id = 1;
        this.reactors = new LinkedHashMap<>();
        this.modules = new LinkedHashMap<>();
    }

    @Override
    public String reactorCommand(List<String> arguments) {
        Reactor reactor = null;
        if (arguments.get(0).equals("Cryo")) {
            reactor = new CryoReactor(this.id++, Integer.parseInt(arguments.get(2)), Integer.parseInt(arguments.get(1)));
        } else {
            reactor = new HeatReactor(this.id++, Integer.parseInt(arguments.get(2)), Integer.parseInt(arguments.get(1)));
        }

        this.reactors.putIfAbsent(reactor.getId(), reactor);
        return String.format("Created %s Reactor - %d", arguments.get(0), reactor.getId());
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        Module module = null;
        if (arguments.get(1).equals("CryogenRod")) {
            module = new CryogenRod(this.id++, Integer.parseInt(arguments.get(2)));
        } else if (arguments.get(1).equals("HeatProcessor")) {
            module = new HeatProcessor(this.id++, Integer.parseInt(arguments.get(2)));
        } else {
            module = new CooldownSystem(this.id++, Integer.parseInt(arguments.get(2)));
        }

        if (module.getClass().getSimpleName().equals("CryogenRod")) {
            this.reactors.get(Integer.parseInt(arguments.get(0))).addEnergyModule((EnergyModule) module);
        } else {
            this.reactors.get(Integer.parseInt(arguments.get(0))).addAbsorbingModule((AbsorbingModule) module);
        }

        this.modules.putIfAbsent(module.getId(), module);
        return String.format("Added %s - %d to Reactor - %d",
                module.getClass().getSimpleName(), module.getId(), Integer.parseInt(arguments.get(0)));
    }

    @Override
    public String reportCommand(List<String> arguments) {
        int reportId = Integer.parseInt(arguments.get(0));
        String result = "";

        if (this.reactors.containsKey(reportId)) {
            result = this.reactors.get(reportId).toString();
        } else {
            result = this.modules.get(reportId).toString();
        }

        return result;
    }

    @Override
    public String exitCommand(List<String> arguments) {
        int cryoReactorsCount = 0;
        int heatReactorsCount = 0;
        int energyModulesCount = 0;
        int absorbingModulesCount = 0;
        long totalEnergyOutput = 0;
        long totalHeatAbsorbing = 0;

        for (Reactor reactor : this.reactors.values()) {
            if(reactor.getClass().getSimpleName().contains("Cryo")) {
                cryoReactorsCount++;
            } else {
                heatReactorsCount++;
            }
        }

        for (Module module : this.modules.values()) {
            if (module.getClass().getSuperclass().getSimpleName().contains("Energy")) {
                energyModulesCount++;
            } else {
                absorbingModulesCount++;
            }
        }

        totalEnergyOutput = this.modules.values()
                .stream()
                .filter(e -> e instanceof EnergyModule)
                .mapToLong(e -> ((EnergyModule) e).getEnergyOutput())
                .sum();

        totalHeatAbsorbing = this.modules.values()
                .stream()
                .filter(e -> e instanceof AbsorbingModule)
                .mapToLong(e -> ((AbsorbingModule) e).getHeatAbsorbing())
                .sum();

        return String.format("Cryo Reactors: %d\n" +
                "Heat Reactors: %d\n" +
                "Energy Modules: %d\n" +
                "Absorbing Modules: %d\n" +
                "Total Energy Output: %d\n" +
                "Total Heat Absorbing: %d",
                cryoReactorsCount, heatReactorsCount,
                energyModulesCount, absorbingModulesCount,
                totalEnergyOutput, totalHeatAbsorbing);
    }
}
