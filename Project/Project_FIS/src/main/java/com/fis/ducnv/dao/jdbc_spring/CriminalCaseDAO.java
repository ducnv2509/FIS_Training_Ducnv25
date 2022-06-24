package com.fis.ducnv.dao.jdbc_spring;

import com.fis.ducnv.entities.CriminalCase;
import org.springframework.stereotype.Component;

import java.util.List;

public interface CriminalCaseDAO {
    void saveOrUpdate(CriminalCase criminalCase);

    void delete(Long id);

    CriminalCase getCriminalCase(Long id);

    List<CriminalCase> listCriminalCases();
}
