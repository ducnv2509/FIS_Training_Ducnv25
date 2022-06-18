package com.fis.ducnv.fakeDemo;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Musician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    @ManyToOne
//    private CD cd;

    @OneToMany(mappedBy = "musician")
    private Set<CD> cdSet = new HashSet<>();

}
