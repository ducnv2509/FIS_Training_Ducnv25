package com.fis.ducnv.dao.jdbc;


import com.fis.ducnv.dao.JdbcDAO;
import com.fis.ducnv.entities.CriminalCase;
import com.fis.ducnv.entities.Detective;
import com.fis.ducnv.helper.JdbcHelper;
import com.fis.ducnv.util.CaseType;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JdbcCriminal_Case extends JdbcDAO<CriminalCase, Long> {

    String INSERT = "insert  into criminal_case\n" +
            "(create_at, modified_at, version, detailed_description, notes, number, short_description, status, type, lead_investigator)\n" +
            "values\n" +
            "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String UPDATE = "update criminal_case\n" +
            "set modified_at = ?, version = ?, detailed_description = ?, notes = ?, number = ?, short_description = ?,\n" +
            "    status = ?, type = ?, lead_investigator = ?\n" +
            "where  id = ?";
    String DELETE = "delete from criminal_case where  id = ?";
    String SELECT_ALL = "select * from criminal_case";
    String SELECT_BY_ID = "select * from criminal_case where id = ?";
    @Override
    public void insert(CriminalCase e) {
        JdbcHelper.update(INSERT, LocalDateTime.now(), LocalDateTime.now(), e.getVersion(), e.getDetailedDescription(), e.getNotes(), e.getNumber(), e.getShortDescription(), e.getStatus(), e.getType(), e.getLeadInvestigator());
    }

    @Override
    public void update(CriminalCase e) {
        JdbcHelper.update(UPDATE, e.getModifiedAt(), e.getVersion(), e.getDetailedDescription(), e.getNotes(), e.getNumber(), e.getShortDescription(), e.getStatus(), e.getType(), e.getLeadInvestigator(), e.getId());
    }

    @Override
    public void delete(Long k) {
        JdbcHelper.update(DELETE, k);
    }

    @Override
    public List<CriminalCase> selectAll() {
        return selectBySql(SELECT_ALL);
    }

    @Override
    public CriminalCase selectById(Long k) {
        List<CriminalCase> list = this.selectBySql(SELECT_BY_ID, k);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<CriminalCase> selectBySql(String sql, Object... args) {
        List<CriminalCase> list  = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()){
                CriminalCase criminalCase = new CriminalCase();
                criminalCase.setId(rs.getLong(1));
                criminalCase.setModifiedAt(LocalDateTime.from(rs.getDate(3).toInstant()));
                criminalCase.setCreateAt(LocalDateTime.from(rs.getDate(2).toInstant()));
                criminalCase.setVersion(rs.getInt(4));
                criminalCase.setDetailedDescription(rs.getString(5));
                criminalCase.setNotes(rs.getString(6));
                criminalCase.setNumber(rs.getString(7));
                criminalCase.setShortDescription(rs.getString(8));
                criminalCase.setStatus(CaseType.valueOf(rs.getString(9)));
                criminalCase.setType(CaseType.valueOf(rs.getString(10)));
                Detective d = new Detective();
                d.setId(rs.getLong(11));
                criminalCase.setLeadInvestigator(d);
                list.add(criminalCase);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
