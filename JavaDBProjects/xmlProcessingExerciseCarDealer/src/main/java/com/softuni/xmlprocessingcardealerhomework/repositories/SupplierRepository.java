package com.softuni.xmlprocessingcardealerhomework.repositories;

import com.softuni.xmlprocessingcardealerhomework.domain.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    /* Query 3 – Local Suppliers */
    @Query("select s from Supplier as s where s.isImporter = false")
    Set<Supplier> findAllByImporterIsFalse();
}
