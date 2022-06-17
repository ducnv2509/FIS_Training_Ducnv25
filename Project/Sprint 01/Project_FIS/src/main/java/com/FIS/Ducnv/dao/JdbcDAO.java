package com.fis.ducnv.dao;

import com.fis.ducnv.entities.Detective;
import com.fis.ducnv.entities.Person;
import com.fis.ducnv.helper.JdbcHelper;
import com.fis.ducnv.util.EmploymentStatus;
import com.fis.ducnv.util.Rank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class JdbcDAO<Entity, Key> {

    abstract public void insert(Entity e);

    abstract public void update(Entity e);

    abstract public void delete(Key k);

    abstract public List<Entity> selectAll();

    abstract public Entity selectById(Key k);

    abstract protected List<Entity> selectBySql(String sql, Object... args);


    protected abstract void prepareSta(PreparedStatement sttm, Object... args) throws SQLException;

    protected abstract Entity mappingEntity(ResultSet resultSet) throws SQLException;

    public final List<Entity> selectBase(String sql, Object... args) throws SQLException {

        List<Entity> list = new ArrayList<>();
        try (Connection conn = JdbcHelper.getConnection()) {
            try (PreparedStatement sttm = conn.prepareStatement(sql)) {
                prepareSta(sttm, args);
                ResultSet rs = sttm.executeQuery();
                while (rs.next()) {
                    list.add(mappingEntity(rs));
                }
            }
        }
        return list;
    }
}
