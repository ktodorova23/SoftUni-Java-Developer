package models;

public class SystemImpl {
    private String name;
    private String type;


    protected SystemImpl(String name, String type) {
        this.name = name;
        this.type = type;
    }

    //TODO: needs Interface:
    public String getName() {
        return this.name;
    }

    protected void setName(String name) {
        this.name = this.name;
    }

    protected String getType() {
        return this.type;
    }

    protected void setType(String type) {
        this.type = type;
    }


}
