package com.example.springdataintro.repositories;

import com.example.springdataintro.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAllByEmailContaining(String emailProvider);

    List<User> findAllByLastTimeLoggedInBefore(LocalDate date);

    void deleteAllByLastTimeLoggedInBefore(LocalDate date);
}
