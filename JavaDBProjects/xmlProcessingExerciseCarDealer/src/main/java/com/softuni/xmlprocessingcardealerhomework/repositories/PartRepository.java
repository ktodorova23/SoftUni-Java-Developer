package com.softuni.xmlprocessingcardealerhomework.repositories;

import com.softuni.xmlprocessingcardealerhomework.domain.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<Part, Integer> {
}
