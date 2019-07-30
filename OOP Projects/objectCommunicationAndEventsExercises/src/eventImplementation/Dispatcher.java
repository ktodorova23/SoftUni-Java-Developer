package eventImplementation;

import eventImplementation.interfaces.NameChangeListener;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {
    private String name;
    private List<NameChangeListener> changeListeners;

    public Dispatcher() {
        this.name = "";
        this.changeListeners = new ArrayList<>();
    }

    public void addNameChangeListener(NameChangeListener changeListener) {
        this.changeListeners.add(changeListener);
    }

    public void removeNameChangeListener(NameChangeListener changeListener) {
        this.changeListeners.remove(changeListener);
    }

    public void setName (String name) {
        this.name = name;
        this.fireNameChangeEvent();
    }

    public void fireNameChangeEvent() {
        Event event = new Event(this, this.name);
        for (NameChangeListener changeListener : changeListeners) {
            changeListener.handleChangedName(event);
        }
    }
}
