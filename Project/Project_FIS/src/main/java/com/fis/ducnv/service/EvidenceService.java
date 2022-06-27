package com.fis.ducnv.service;

import com.fis.ducnv.entities.Detective;
import com.fis.ducnv.entities.Evidence;

import java.util.Set;

public interface EvidenceService {
    Evidence addEvidence(Evidence evidence);

    Evidence updateEvidence(Evidence evidence);

    Set<Evidence> getEvidences();

    Evidence getEvidence(Long id);

    void deleteEvidence(Long id);

    Set<Evidence> findAllEvidenceOfTheSpecifiedCriminal();


}
