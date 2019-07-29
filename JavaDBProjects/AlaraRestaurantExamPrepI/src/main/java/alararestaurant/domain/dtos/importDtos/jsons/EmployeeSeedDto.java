package alararestaurant.domain.dtos.importDtos.jsons;

import com.google.gson.annotations.Expose;

public class EmployeeSeedDto {
    @Expose
    private String name;
    @Expose
    private int age;
    @Expose
    private String position;

    public EmployeeSeedDto() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
