package com.fis.ducnv.repository;

import com.fis.ducnv.entities.Evidence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface EvidenceRepository extends JpaRepository<Evidence, Long> {
    @Query(value = "select e from evidence e join criminalCase c on e.criminalCase = c.id join dectective d on c.leadInvestigator = d.id where d.rank = 'SENIOR'")
    Set<Evidence> findAllEvidenceOfTheSpecifiedCriminal();
}
