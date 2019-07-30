package com.softuni.demo.services;

import com.softuni.demo.domain.dtos.UserLoginDto;
import com.softuni.demo.domain.dtos.UserRegistrationDto;
import com.softuni.demo.domain.entities.User;
import com.softuni.demo.domain.enums.Role;
import com.softuni.demo.repositories.UserRepository;
import com.softuni.demo.services.base.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.*;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    public static String loggedInEmail = "";

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public String registerUser(UserRegistrationDto userRegistrationDto) {
        StringBuilder sb = new StringBuilder();

        User user = this.modelMapper.map(userRegistrationDto, User.class);

        //Validate if the user is already registered
        User inDb = this.userRepository.findByEmail(user.getEmail())
                .orElse(null);

        if (inDb == null) {
            ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
            Validator validator = vf.getValidator();

            Set<ConstraintViolation<User>> violations = validator.validate(user);

            if (violations.size() == 0) {
                if (this.userRepository.count() == 0) {
                    user.setRole(Role.ADMIN);
                } else {
                    user.setRole(Role.USER);
                }
                this.userRepository.saveAndFlush(user);
                sb.append(String.format("%s was registered!", user.getFullName()));
            } else {
                for (ConstraintViolation<User> violation : violations) {
                    sb.append(violation.getMessage());
                }
            }
        } else {
            sb.append("User is already registered in DB!");
        }

        return sb.toString();
    }

    @Override
    public String loginUser(UserLoginDto userLoginDto) {
        StringBuilder sb = new StringBuilder();

        User inDb = this.userRepository.findByEmail(userLoginDto.getEmail())
                .orElse(null);

        if (inDb == null) {
            return sb.append("No registered user with this email in DB!").toString();
        } else {
            if (!inDb.getPassword().equals(userLoginDto.getPassword())) {
                return sb.append("Incorrect password!").toString();
            }

            if (UserServiceImpl.loggedInEmail.equals("")) {
                UserServiceImpl.loggedInEmail = inDb.getEmail();
                sb.append(String.format("Successfully logged in %s!", inDb.getFullName()));
            } else {
                if (UserServiceImpl.loggedInEmail.equals(inDb.getEmail())) {
                    sb.append("This user is already logged in!");
                } else {
                    sb.append("Only one user can be logged in at a time!");
                }
            }
        }
        return sb.toString();
    }

    @Override
    public String logoutUser() {
        StringBuilder sb = new StringBuilder();

        if (UserServiceImpl.loggedInEmail.isEmpty()) {
            sb.append("Cannot log out! No user was logged in!");
        } else {
            User currentlyLoggedInUser = this.userRepository
                    .findByEmail(UserServiceImpl.loggedInEmail)
                    .get();
            UserServiceImpl.loggedInEmail = "";
            sb.append(String.format("User %s successfully logged out!",
                    currentlyLoggedInUser.getFullName()));
        }
        return sb.toString();
    }

    @Override
    public User findByEmail(String email) {
        return this.userRepository.findByEmail(email).orElse(null);
    }
}
