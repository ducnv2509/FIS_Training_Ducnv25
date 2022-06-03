package com.fis.ducnv.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fis.ducnv.util.DateFormatter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import java.time.LocalDateTime;


//@SequenceGenerator(name = "seqPersonGen", allocationSize = 1)
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Person extends AbstractEntity {
    private String username;
    private String firstName;
    private String lastName;
    private String password;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateFormatter.DATE_FORMAT)
    @DateTimeFormat(pattern = DateFormatter.DATE_FORMAT)
    @Column(nullable = false)
    private LocalDateTime hiringDate;

    public Person(String username, String firstName, String lastName, String password, LocalDateTime hiringDate) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.hiringDate = hiringDate;
    }
}
