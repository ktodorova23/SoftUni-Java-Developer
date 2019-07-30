package core;

import common.OutputMessages;
import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;

import entities.interfaces.Fighter;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;
import entities.interfaces.Tank;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MachinesManagerImpl implements MachinesManager {
    private PilotFactory pilotFactory;
    private MachineFactory machineFactory;
    private Map<String, Pilot> pilots;
    private Map<String, Machine> machines;

    public MachinesManagerImpl(PilotFactory pilotFactory, MachineFactory machineFactory,
                               Map<String, Pilot> pilots, Map<String, Machine> machines) {
        this.pilotFactory = pilotFactory;
        this.machineFactory = machineFactory;
        this.pilots = pilots;
        this.machines = machines;
    }


    @Override
    public String hirePilot(String name) {
        String result = "";
        if (!this.pilots.containsKey(name)) {
            Pilot pilot = this.pilotFactory.createPilot(name);
            this.pilots.putIfAbsent(name, pilot);
            result = String.format(OutputMessages.pilotHired, pilot.getName());
        } else {
            result = String.format(OutputMessages.pilotExists, name);
        }
        return result;
    }

    @Override
    public String manufactureTank(String name, double attackPoints, double defensePoints) {
        String result = "";
        if (!this.machines.containsKey(name)) {
            Tank tank = this.machineFactory.createTank(name, attackPoints, defensePoints);
            this.machines.putIfAbsent(name, tank);
            result = String.format(OutputMessages.tankManufactured, name, attackPoints, defensePoints);
        } else {
            result = String.format(OutputMessages.machineExists, name);
        }
        return result;
    }

    @Override
    public String manufactureFighter(String name, double attackPoints, double defensePoints) {
        String result = "";
        if (!this.machines.containsKey(name)) {
            Fighter fighter = this.machineFactory.createFighter(name, attackPoints, defensePoints);
            this.machines.putIfAbsent(name, fighter);
            result = String.format(OutputMessages.fighterManufactured, name, attackPoints, defensePoints);
        } else {
            result = String.format(OutputMessages.machineExists, name);
        }
        return result;
    }

    @Override
    public String engageMachine(String selectedPilotName, String selectedMachineName) {
        String result = "";
        if (this.pilots.containsKey(selectedPilotName) && this.machines.containsKey(selectedMachineName)) {
            Pilot pilot = this.pilots.get(selectedPilotName);
            Machine machine = this.machines.get(selectedMachineName);

            boolean machineIsEngagedAnywhere = false;
            for (Pilot value : pilots.values()) {
                if (value.getMachines().contains(machine)) {
                    machineIsEngagedAnywhere = true;
                    break;
                }
            }
            if (!machineIsEngagedAnywhere) {
                machine.setPilot(pilot);
                pilot.addMachine(machine);
                result = String.format(OutputMessages.machineEngaged, pilot.getName(), machine.getName());
            } else {
                result = String.format(OutputMessages.machineHasPilotAlready, machine.getName());
            }
        } else if (!this.machines.containsKey(selectedMachineName)) {
            result = String.format(OutputMessages.machineNotFound, selectedMachineName);
        } else if (!this.pilots.containsKey(selectedPilotName)) {
            result = String.format(OutputMessages.pilotNotFound, selectedPilotName);
        }
        return result;
    }

    @Override
    public String attackMachines(String attackingMachineName, String defendingMachineName) {
        String result = "";
        boolean attackingMachineIsPresent = this.machines.containsKey(attackingMachineName);
        boolean defendingMachineIsPresent = this.machines.containsKey(defendingMachineName);

        if (attackingMachineIsPresent && defendingMachineIsPresent) {
            Machine attackingMachine = this.machines.get(attackingMachineName);
            Machine defendingMachine = this.machines.get(defendingMachineName);
            if (attackingMachine.getAttackPoints() > defendingMachine.getDefensePoints()) {
                defendingMachine.setHealthPoints(defendingMachine.getHealthPoints() -
                        (attackingMachine.getAttackPoints() - defendingMachine.getDefensePoints()));
                if (defendingMachine.getHealthPoints() < 0) {
                    defendingMachine.setHealthPoints(0);
                }

            }
            result = String.format(OutputMessages.attackSuccessful,
                    defendingMachineName, attackingMachineName, defendingMachine.getHealthPoints());

            attackingMachine.attack(defendingMachineName);
        } else {
            if (!attackingMachineIsPresent) {
                result = String.format(OutputMessages.machineNotFound, attackingMachineName);
            } else {
                result = String.format(OutputMessages.machineNotFound, defendingMachineName);
            }
        }

        return result;
    }

    @Override
    public String pilotReport(String pilotName) {
        String result = "";
        if (this.pilots.containsKey(pilotName)) {
            result = this.pilots.get(pilotName).report();
        } else {
            result = String.format(OutputMessages.pilotNotFound, pilotName);
        }
        return result;
    }

    @Override
    public String toggleFighterAggressiveMode(String fighterName) {
        String result = "";
        if (this.machines.containsKey(fighterName)) {
            if (this.machines.get(fighterName).getClass().getSimpleName().contains("Fighter")) {
                Fighter fighter = (Fighter) this.machines.get(fighterName);
                fighter.toggleAggressiveMode();
                result = String.format(OutputMessages.fighterOperationSuccessful, fighterName);
            } else {
                result = String.format(OutputMessages.notSupportedOperation, fighterName);
            }
        }
        return result;
    }

    @Override
    public String toggleTankDefenseMode(String tankName) {
        String result = "";
        if (this.machines.containsKey(tankName)) {
            if (this.machines.get(tankName).getClass().getSimpleName().contains("Tank")) {
                Tank tank = (Tank) this.machines.get(tankName);
                tank.toggleDefenseMode();
                result = String.format(OutputMessages.tankOperationSuccessful, tankName);
            } else {
                result = String.format(OutputMessages.notSupportedOperation, tankName);
            }
        }
        return result;
    }
}
