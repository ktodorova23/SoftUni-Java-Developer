package com.softuni.demo.repositories;

import com.softuni.demo.domain.entities.Order;
import com.softuni.demo.domain.entities.User;
import com.softuni.demo.domain.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    Order findByUserAndStatus(User user, Status status);
}
