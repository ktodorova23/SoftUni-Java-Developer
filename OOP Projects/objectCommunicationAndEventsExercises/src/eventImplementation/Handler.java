package eventImplementation;

import eventImplementation.interfaces.NameChangeListener;

public class Handler implements NameChangeListener {
    @Override
    public void handleChangedName(Event event) {
        System.out.printf("Dispatcher's name changed to %s.%n", event.getChangedName());
    }
}
