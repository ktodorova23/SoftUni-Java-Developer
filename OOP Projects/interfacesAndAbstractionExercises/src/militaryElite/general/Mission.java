package militaryElite.general;

import militaryElite.enumerations.State;

public class Mission {
    private String codeName;
    private State state;

    public Mission(String codeName, String state) {
        this.codeName = codeName;
        this.state = State.valueOf(state);
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.codeName, this.state.toString());
    }
}
