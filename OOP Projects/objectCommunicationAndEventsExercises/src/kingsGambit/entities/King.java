package kingsGambit.entities;

import kingsGambit.interfaces.Defender;
import kingsGambit.interfaces.Target;

import java.util.Map;

public class King extends Unit implements Target {
    private Map<String, Defender> guards;

    public King(String name, Map<String, Defender> guards) {
        super(name);
        this.guards = guards;
    }

    @Override
    public void uponAttack() {
        System.out.printf("King %s is under attack!%n", super.getName());

        this.fireUponAttack();
    }
//
//    @Override
//    public void killDefender(String name) {
//        this.guards.remove(name);
//    }

    private void fireUponAttack() {
        for (Defender defender : guards.values()) {
            System.out.println(defender.respondToAttack());
        }
    }


}
