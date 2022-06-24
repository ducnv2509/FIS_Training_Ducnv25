package com.fis.ducnv;

//import com.fis.ducnv.config.DIConfiguration;

import com.fis.ducnv.dao.DAO;
import com.fis.ducnv.dao.jdbc_spring.CriminalCaseDAO;
import com.fis.ducnv.entities.CriminalCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class FIS_Ducnv {
    private static DAO<CriminalCase> dao;

    public FIS_Ducnv(DAO<CriminalCase> dao) {
        FIS_Ducnv.dao = dao;
    }

    public static void main(String[] args) {
        SpringApplication.run(FIS_Ducnv.class, args);
        System.out.println("\n HGet=-----------------------------");
        Optional<CriminalCase> aCase = dao.get(3L);
        System.out.println(aCase.get());

        System.out.println("\n All=-----------------------------");
        List<CriminalCase> criminalCases = dao.getAll();
        criminalCases.forEach(System.out::println);
    }


}
