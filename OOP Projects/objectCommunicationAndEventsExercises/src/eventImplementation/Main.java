package eventImplementation;

import eventImplementation.interfaces.NameChangeListener;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Dispatcher dispatcher = new Dispatcher();

        NameChangeListener changeListener = new Handler();

        dispatcher.addNameChangeListener(changeListener);

        String line = console.nextLine();

        while (!line.equals("End")) {
            dispatcher.setName(line);

            line = console.nextLine();
        }
    }
}
