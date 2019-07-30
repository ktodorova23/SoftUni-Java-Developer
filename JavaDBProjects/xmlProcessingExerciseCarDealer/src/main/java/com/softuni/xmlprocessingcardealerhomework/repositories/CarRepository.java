package com.softuni.xmlprocessingcardealerhomework.repositories;

import com.softuni.xmlprocessingcardealerhomework.domain.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    /* Query 2 – Cars from make Toyota */
    List<Car> findByMakeOrderByModelAscTravelledDistanceDesc(String make);
}
