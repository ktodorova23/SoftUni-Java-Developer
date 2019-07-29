package com.softuni.xmlprocessing.repositories;

import com.softuni.xmlprocessing.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    /* Query 2 - Successfully Sold Products */
    Set<User> findBySoldProductsIsNotNullOrderByLastNameAscFirstNameAsc();

    /* Query 4 - Users and Products */
    Set<User> findAllBySoldProductsNotNullOrderBySoldProductsDescLastNameAsc();
}
