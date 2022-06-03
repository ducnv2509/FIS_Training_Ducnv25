package com.fis.ducnv.entities;

import com.fis.ducnv.util.CaseType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@SequenceGenerator(name = "seqCriminalCaseGen", allocationSize = 1)
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class CriminalCase extends AbstractEntity{

    private String number;
    private CaseType type;
    private String shortDescription;
    private String detailedDescription;

    @Enumerated(EnumType.STRING)
    private CaseType status;

    private String notes;

    @OneToMany(mappedBy = "criminalCase", cascade = CascadeType.PERSIST)
    private Set<Evidence> evidences = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "LEAD_INVESTIGATOR", nullable = false)
    private Detective leadInvestigator;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name="working_detective_case",
            joinColumns=@JoinColumn(name="case_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="detective_id", referencedColumnName="id"))
    private Set<Detective> assigned = new HashSet<>();
}
