package com.softuni.xmlprocessing.services.base;

import com.softuni.xmlprocessing.domain.dtos.exportDtos.UserRootDto;
import com.softuni.xmlprocessing.domain.dtos.exportDtos.UsersAndProductsRootDto;
import com.softuni.xmlprocessing.domain.entities.User;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface UserService {
    void seedUsers() throws JAXBException, FileNotFoundException;

    User getRandomBuyer();

    User getRandomSeller();

    void seedFriends();

    UserRootDto getAllUsersWithSoldProductsWithBuyerName();

    UsersAndProductsRootDto usersAndProducts();
}
