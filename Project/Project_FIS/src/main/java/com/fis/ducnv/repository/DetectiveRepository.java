package com.fis.ducnv.repository;

import com.fis.ducnv.entities.Detective;
import com.fis.ducnv.entities.Evidence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface DetectiveRepository extends JpaRepository<Detective, Long> {
    Detective findDetectiveByPersonUsername(String username);



}
