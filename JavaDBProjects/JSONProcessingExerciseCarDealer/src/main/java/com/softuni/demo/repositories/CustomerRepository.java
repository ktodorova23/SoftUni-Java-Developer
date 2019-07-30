package com.softuni.demo.repositories;

import com.softuni.demo.domain.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    /* Query 1 – Ordered Customers */
    @Query("select c from Customer as c order by c.birthDate asc, c.isYoungDriver desc ")
    Set<Customer> findAllOrderedByBirthDate();

    /* Query 5 – Total Sales by Customer */
    Set<Customer> findAllBySalesNotNull();
}
