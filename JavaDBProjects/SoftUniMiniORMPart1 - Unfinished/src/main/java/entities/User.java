package entities;

import java.util.Date;

public class User {
    private int id;
    private String username;
    private String password;
    private int age;
    private Date registrationDate;

    public User(String username, String password, int age, Date registrationDate) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.registrationDate = registrationDate;
    }

    private int getId() {
        return this.id;
    }

    private String getUsername() {
        return this.username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    private String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private Date getRegistrationDate() {
        return this.registrationDate;
    }

    private void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
