package com.softuni.demo.services.base;

import com.softuni.demo.domain.dtos.UserWithSoldProductsDto;
import com.softuni.demo.domain.dtos.UsersAndProductsDto;

import java.io.IOException;
import java.util.Set;

public interface UserService {
    void seedUsers(String path) throws IOException;

    void seedWithFriends();

    /* Query 2 - Successfully Sold Products */
    Set<UserWithSoldProductsDto> getAllUsersWithSoldProductsWithBuyerName();

    /* Query 4 - Users and Products */
    UsersAndProductsDto usersAndProducts();
}
