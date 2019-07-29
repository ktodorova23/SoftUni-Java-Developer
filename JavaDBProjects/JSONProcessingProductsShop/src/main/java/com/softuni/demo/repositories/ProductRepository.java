package com.softuni.demo.repositories;

import com.softuni.demo.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.support.AbstractLobStreamingResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    /* Query 1 - Products In Range */
    List<Product> findAllByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal lower, BigDecimal higher);
}
