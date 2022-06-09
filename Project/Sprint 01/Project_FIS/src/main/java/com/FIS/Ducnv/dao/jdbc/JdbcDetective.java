package com.fis.ducnv.dao.jdbc;

import com.fis.ducnv.dao.JdbcDAO;
import com.fis.ducnv.entities.Detective;
import com.fis.ducnv.helper.JdbcHelper;
import com.fis.ducnv.util.EmploymentStatus;
import com.fis.ducnv.util.Rank;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JdbcDetective extends JdbcDAO<Detective, Long> {
    String INSERT = "insert into detective\n" +
            "(create_at, modified_at, version, armed, badge_number, first_name, hiring_date, last_name, password, `rank`, status, username)\n" +
            "values \n" +
            "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String UPDATE = "update detective\n" +
            "set modified_at = ?, version = ?, armed = ?, badge_number = ?" +
            "where id = ?";
    String DELETE = "delete from detective where  id = ?";
    String SELECT_ALL = "select * from detective";
    String SELECT_BY_ID = "select * from detective where id = ?";

    @Override
    public void insert(Detective e) {
        JdbcHelper.update(INSERT, LocalDateTime.now(), LocalDateTime.now(), e.getVersion(), e.getArmed(), e.getBadgeNumber(), e.getFirstName(), e.getHiringDate(), e.getLastName(), e.getPassword(), e.getRank(), e.getStatus(), e.getUsername());
    }

    @Override
    public void update(Detective e) {
        JdbcHelper.update(UPDATE, e.getModifiedAt(), e.getVersion(), e.getArmed(), e.getBadgeNumber(), e.getId());
    }

    @Override
    public void delete(Long k) {
        JdbcHelper.update(DELETE, k);
    }

    @Override
    public List<Detective> selectAll() {
        return null;
    }

    @Override
    public Detective selectById(Long k) {
        List<Detective> list = this.selectBySql(SELECT_BY_ID, k);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<Detective> selectBySql(String sql, Object... args) {
        List<Detective> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                Detective detective = new Detective();
                detective.setId(rs.getLong(1));
                detective.setCreateAt(LocalDateTime.from(rs.getDate(2).toInstant()));
                detective.setModifiedAt(LocalDateTime.from(rs.getDate(3).toInstant()));
                detective.setVersion(rs.getInt(4));
                detective.setArmed(rs.getBoolean(5));
                detective.setBadgeNumber(rs.getString(6));
                detective.setRank(Rank.valueOf(rs.getString(7)));
                detective.setStatus(EmploymentStatus.valueOf(rs.getString(8)));
//                Person p = new Person();
//                p.setId(rs.getLong(9));
//                detective.setPerson(p);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}