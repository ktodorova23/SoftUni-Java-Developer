package com.softuni.demo.domain.dtos;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.Set;

public class UsersAndProductsDto implements Serializable {
    @Expose
    private int usersCount;
    @Expose
    private Set<UserSimpleViewDto> users;

    public UsersAndProductsDto() {}

    public int getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }

    public Set<UserSimpleViewDto> getUsers() {
        return users;
    }

    public void setUsers(Set<UserSimpleViewDto> users) {
        this.users = users;
    }
}
