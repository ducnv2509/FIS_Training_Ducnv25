package com.fis.ducnv.repository;

import com.fis.ducnv.entities.Detective;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetectiveRepository extends JpaRepository<Detective, Long> {
    Detective findDetectiveByPersonUsername(String username);
}
