package com.FIS.Ducnv.dao.jdbc;

import com.fis.ducnv.dao.jdbc.JdbcDetective;
import com.fis.ducnv.entities.Detective;
import com.fis.ducnv.entities.Person;
import com.fis.ducnv.util.EmploymentStatus;
import com.fis.ducnv.util.Rank;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class JdbcDetectiveTest {

    @Test
    void insert() {
        JdbcDetective detective = new JdbcDetective();
        Detective dec = new Detective();
        Person person = new Person();
        person.setCreateAt(LocalDateTime.now());
        person.setModifiedAt(LocalDateTime.now());
        person.setVersion(1);
        person.setFirstName("Ducnana");
        person.setHiringDate(LocalDateTime.now());
        person.setLastName("Dang Dinh Duc ");
        person.setPassword("838383");
        person.setUsername("mamamam");
        dec.setVersion(1);
        dec.setArmed(true);
        dec.setBadgeNumber("774744");
        dec.setRank(Rank.valueOf("JUNIOR"));
        dec.setStatus(EmploymentStatus.valueOf("ACTIVE"));
        dec.setPerson(person);
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
        JdbcDetective detective = new JdbcDetective();
        detective.delete(8L);
    }

    @Test
    void selectAll() {
        JdbcDetective detective = new JdbcDetective();
        System.out.println(detective.selectAll());
    }

    @Test
    void selectById() {
        JdbcDetective detective = new JdbcDetective();
        System.out.println(detective.selectById(8L));
    }

}