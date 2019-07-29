package com.example.springdataintro.services.base;

import com.example.springdataintro.domain.entities.User;

import java.util.Date;
import java.util.List;

public interface UserService {
    List<String> findUsersByGivenEmailProvider(String emailProvider);

    void insertUsersIntoDB(List<User> users);

    int findTheCountOfAllInactiveUsersAfterGivenDate(String date);

    void deleteInactives(String date);
}
