package com.fis.ducnv.dao.jdbc_spring;

import com.fis.ducnv.entities.CriminalCase;
import org.springframework.stereotype.Component;

import java.util.List;

public interface CriminalCaseDAO {
    public void saveOrUpdate(CriminalCase criminalCase);

    public void delete(Long id);

    public CriminalCase getCriminalCase(Long id);

    public List<CriminalCase> listCriminalCases();
}
