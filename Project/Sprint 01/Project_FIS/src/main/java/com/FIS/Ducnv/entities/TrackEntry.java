package com.fis.ducnv.entities;

import com.fis.ducnv.util.TrackAction;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;

@SequenceGenerator(name = "seqStorageGen", allocationSize = 1)
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class TrackEntry extends AbstractEntity {

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "evidence_fk", nullable = false)
    private Evidence evidence;

    @ManyToOne
    @JoinColumn(name = "detective_fk", nullable = false)
    private Detective detective;

    @Enumerated(EnumType.STRING)
    private TrackAction action;

    private String reason;
}
