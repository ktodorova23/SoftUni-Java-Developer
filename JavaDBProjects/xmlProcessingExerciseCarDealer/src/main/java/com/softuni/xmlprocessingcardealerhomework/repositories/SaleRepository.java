package com.softuni.xmlprocessingcardealerhomework.repositories;

import com.softuni.xmlprocessingcardealerhomework.domain.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {
}