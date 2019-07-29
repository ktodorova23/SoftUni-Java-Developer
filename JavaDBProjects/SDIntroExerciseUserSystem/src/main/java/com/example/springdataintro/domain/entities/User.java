package com.example.springdataintro.domain.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Length(min = 4, max = 30)
    @NotNull
    private String username;
    @Length(min = 6, max = 50)
    @NotNull
    private String password;
    @Email(regexp = "^[A-Za-z0-9]([a-zA-Z0-9_.-])+[a-zA-Z0-9]@[A-Za-z0-9]([a-zA-Z0-9-]){0,}[a-zA-Z0-9]+(\\.[A-Za-z0-9]([a-zA-Z0-9-]){0,}[a-zA-Z0-9]+){1,}$")
    @NotNull
    private String email;
    @Column(name = "registered_on")
    private LocalDate registeredOn;
    @Column(name = "last_time_logged_in")
    private LocalDate lastTimeLoggedIn;
    @Min(1)
    @Max(120)
    private int age;
    @Column(name = "is_deleted")
    private boolean isDeleted;

    @ManyToOne
    private Town bornTown;
    @ManyToOne
    private Town currentlyLivingTown;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "friends",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "friend_id")}
    )
    private Set<User> friends;
    @ManyToMany(mappedBy = "friends", targetEntity = User.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<User> isFriendsOf;

    @OneToMany
    public Set<Album> albums;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.chars().noneMatch(Character::isDigit) ||
                password.chars().noneMatch(Character::isLowerCase) ||
                password.chars().noneMatch(Character::isUpperCase) ||
                !this.containsSpecialSymbols(password)) {
            throw new IllegalArgumentException("Invalid password");
        }

        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(LocalDate registeredOn) {
        this.registeredOn = registeredOn;
    }

    public LocalDate getLastTimeLoggedIn() {
        return lastTimeLoggedIn;
    }

    public void setLastTimeLoggedIn(LocalDate lastTimeLoggedIn) {
        this.lastTimeLoggedIn = lastTimeLoggedIn;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Town getBornTown() {
        return bornTown;
    }

    public void setBornTown(Town bornTown) {
        this.bornTown = bornTown;
    }

    public Town getCurrentlyLivingTown() {
        return currentlyLivingTown;
    }

    public void setCurrentlyLivingTown(Town currentlyLivingTown) {
        this.currentlyLivingTown = currentlyLivingTown;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    public Set<User> getIsFriendsOf() {
        return isFriendsOf;
    }

    public void setIsFriendsOf(Set<User> isFriendsOf) {
        this.isFriendsOf = isFriendsOf;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    @Transient()
    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }

    private boolean containsSpecialSymbols(String password) {
        List<Character> specialSymbols = new ArrayList<>();
        Collections.addAll(specialSymbols, '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '+', '<', '>', '?');

        boolean containsAtLeastOneSpecialSymbol = false;
        for (Character symbol : specialSymbols) {
            if (password.contains(symbol + "")) {
                containsAtLeastOneSpecialSymbol = true;
                break;
            }
        }
        return containsAtLeastOneSpecialSymbol;
    }
}
