package com.fis.ducnv.repository;

import com.fis.ducnv.entities.CriminalCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface CriminalCaseRepository extends JpaRepository<CriminalCase, Long> {

    @Query("select c from CriminalCase c join Detective d on c.leadInvestigator = d.id where d.rank = 'CHIEF_INSPECTOR'")
    Set<CriminalCase> findAllByLeadInvestigatorRank_ChiefInspector();

}
