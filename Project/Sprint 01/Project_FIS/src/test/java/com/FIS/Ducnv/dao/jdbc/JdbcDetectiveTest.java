package com.FIS.Ducnv.dao.jdbc;

import com.fis.ducnv.dao.jdbc.JdbcDetective;
import com.fis.ducnv.entities.Detective;
import com.fis.ducnv.util.EmploymentStatus;
import com.fis.ducnv.util.Rank;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class JdbcDetectiveTest {

    @Test
    void insert() {
        JdbcDetective detective = new JdbcDetective();
        Detective dec = new Detective();
        dec.setVersion(2);
        dec.setArmed(true);
        dec.setBadgeNumber("221");
        dec.setFirstName("Duc");
        dec.setHiringDate(LocalDateTime.now());
        dec.setLastName("Nguyen");
        dec.setPassword("12312313");
        dec.setRank(Rank.valueOf("JUNIOR"));
        dec.setStatus(EmploymentStatus.valueOf("ACTIVE"));
        dec.setUsername("ducnv");
        detective.insert(dec);
        System.out.println(dec.toString());
        System.out.println("DONE");
    }

    @Test
    void update() {
        JdbcDetective detective = new JdbcDetective();
        Detective dec = new Detective();
        dec.setModifiedAt(LocalDateTime.now());
        dec.setVersion(4);
        dec.setArmed(false);
        dec.setBadgeNumber("OKKAA");
        dec.setId(1L);
        detective.update(dec);
        System.out.println("OK");
    }

    @Test
    void delete() {
    }

    @Test
    void selectAll() {
    }

    @Test
    void selectById() {
    }

    @Test
    void selectBySql() {
    }
}