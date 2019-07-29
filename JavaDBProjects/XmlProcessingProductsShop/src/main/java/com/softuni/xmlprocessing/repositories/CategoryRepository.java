package com.softuni.xmlprocessing.repositories;

import com.softuni.xmlprocessing.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    /* Query 3 - Categories By Products Count */
    @Query("select c from Category as c order by size(c.products) desc")
    List<Category> findAllOrderByProductsSize();
}
