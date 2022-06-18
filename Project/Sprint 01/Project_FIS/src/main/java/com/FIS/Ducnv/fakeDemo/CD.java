package com.fis.ducnv.fakeDemo;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
public class CD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameCD;

//    @OneToMany(mappedBy = "cd")
//    private Set<Musician> musicians = new HashSet<>();;

        @ManyToOne
    private Musician musician;
}
