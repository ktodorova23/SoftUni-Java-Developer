package com.softuni.demo.repositories;

import com.softuni.demo.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    /* Query 3 - Categories By Products Count */
    @Query("select c from Category as c order by size(c.products) desc")
    List<Category> findAllOrOrderByProductsSize();
}
