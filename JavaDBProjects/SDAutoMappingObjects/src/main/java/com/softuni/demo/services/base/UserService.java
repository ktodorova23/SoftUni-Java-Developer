package com.softuni.demo.services.base;

import com.softuni.demo.domain.dtos.UserLoginDto;
import com.softuni.demo.domain.dtos.UserRegistrationDto;
import com.softuni.demo.domain.entities.User;

public interface UserService {
    String registerUser(UserRegistrationDto userRegistrationDto);

    String loginUser(UserLoginDto userLoginDto);

    String logoutUser();

    User findByEmail(String email);


}
