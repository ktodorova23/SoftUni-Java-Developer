package com.softuni.demo.repositories;

import com.softuni.demo.domain.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    /* Query 2 – Cars from make Toyota */
    List<Car> findByMakeOrderByModelAscTravelledDistanceDesc(String make);
}
