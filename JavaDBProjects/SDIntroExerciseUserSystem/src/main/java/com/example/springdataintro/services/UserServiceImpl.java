package com.example.springdataintro.services;

import com.example.springdataintro.domain.entities.User;
import com.example.springdataintro.repositories.UserRepository;
import com.example.springdataintro.services.base.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<String> findUsersByGivenEmailProvider(String emailProvider) {
        List<String> emails = new ArrayList<>();

        List<User> users = this.userRepository
                .findAllByEmailContaining(emailProvider);

        if (!users.isEmpty()) {
            return users.stream()
                    .map(user -> String.format("%s %s",
                            user.getUsername(),
                            user.getEmail()))
                    .collect(Collectors.toList());
        }

        emails.add("No users found with email domain " + emailProvider);
        return emails;

    }

    @Override
    public void insertUsersIntoDB(List<User> users) {
        for (User user : users) {
            this.userRepository.saveAndFlush(user);
        }
    }

    @Override
    public int findTheCountOfAllInactiveUsersAfterGivenDate(String dateString) {
        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        List<User> allByLastTimeLoggedInAfter = this.userRepository
                .findAllByLastTimeLoggedInBefore(date);

        for (User user : allByLastTimeLoggedInAfter) {
            user.setDeleted(true);
        }

        return allByLastTimeLoggedInAfter.size();
    }

    @Override
    public void deleteInactives(String dateString) {
        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.userRepository
                .deleteAllByLastTimeLoggedInBefore(date);
    }
}
