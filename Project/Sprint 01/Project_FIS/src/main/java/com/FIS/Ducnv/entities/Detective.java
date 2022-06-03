package com.fis.ducnv.entities;

import com.fis.ducnv.util.EmploymentStatus;
import com.fis.ducnv.util.Rank;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@SequenceGenerator(name = "seqDetectiveGen", allocationSize = 1)
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Detective extends AbstractEntity{

    @OneToOne
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    private String badgeNumber;

    @Enumerated(EnumType.STRING)
    private Rank rank;

    private Boolean armed = false;
    @Enumerated(EnumType.STRING)
    private EmploymentStatus status = EmploymentStatus.ACTIVE;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name="working_detective_case",
            joinColumns=@JoinColumn(name="detective_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="case_id", referencedColumnName="id"))
    private Set<CriminalCase> criminalCases = new HashSet<>();

    @OneToMany(mappedBy = "detective")
    private Set<TrackEntry> trackEntries;


}
