package com.FIS.Ducnv.dao.jdbc;

import com.fis.ducnv.dao.jdbc.JdbcCriminal_Case;
import com.fis.ducnv.entities.CriminalCase;
import com.fis.ducnv.entities.Detective;
import com.fis.ducnv.util.CaseStatus;
import com.fis.ducnv.util.CaseType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class JdbcCriminal_CaseTest {

    JdbcCriminal_Case jdbcCriminal_case = new JdbcCriminal_Case();

    @Test
    void insert() {
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setVersion(1);
        criminalCase.setDetailedDescription("Note 03");
        criminalCase.setNotes("note 01");
        criminalCase.setNumber("0332429178");
        criminalCase.setShortDescription("Done");
        criminalCase.setStatus(CaseStatus.valueOf("SUBMITTED"));
        criminalCase.setType(CaseType.valueOf("UNCATEGORIZED"));
        Detective detective  = new Detective();
        detective.setId(1L);
        criminalCase.setLeadInvestigator(detective);
        jdbcCriminal_case.insert(criminalCase);
    }

    @Test
    void update() {
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setVersion(3);
        criminalCase.setDetailedDescription("ok");
        criminalCase.setNotes("Note 121231");
        criminalCase.setNumber("018312831");
        criminalCase.setShortDescription("shoert");
        criminalCase.setStatus(CaseStatus.valueOf("DISMISSED"));
        criminalCase.setType(CaseType.valueOf("MISDEMEANOR"));
        Detective detective  = new Detective();
        detective.setId(1L);
        criminalCase.setLeadInvestigator(detective);
        criminalCase.setId(2L);
        jdbcCriminal_case.update(criminalCase);
        System.out.println("Done");
    }

    @Test
    void delete() {
        jdbcCriminal_case.delete(2L);
    }

    @Test
    void selectAll() {
        System.out.println(jdbcCriminal_case.selectAll());
    }

    @Test
    void selectById() {
        System.out.println(jdbcCriminal_case.selectById(2L));
    }
}