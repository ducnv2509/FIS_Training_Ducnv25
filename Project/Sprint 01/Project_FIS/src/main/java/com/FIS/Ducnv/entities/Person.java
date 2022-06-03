package com.fis.ducnv.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

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
    private LocalDateTime hiringDate;
}
