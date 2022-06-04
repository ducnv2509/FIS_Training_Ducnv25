package com.fis.ducnv.dto;

import com.fis.ducnv.entities.CriminalCase;
import com.fis.ducnv.entities.Evidence;
import com.fis.ducnv.entities.Storage;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class EvidenceDAO implements DAO<Evidence> {

    private final List<Evidence> evidences = new ArrayList<>();

    public EvidenceDAO() {
        Date now = Calendar.getInstance().getTime();
        Instant instant = now.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        evidences.add(
                new Evidence(new CriminalCase(), new Storage(), "1.1", "iteam01", "Note main", false)
        );
    }

    @Override
    public List<Evidence> getAll() {
        return evidences;
    }

    @Override
    public Optional<Evidence> get(Long id) {
        return evidences.stream().filter(u -> u.getId().equals(id)).findFirst();
    }

    @Override
    public void save(Evidence evidence) {
        evidences.add(evidence);
    }

    @Override
    public void update(Evidence evidence) {
        get(evidence.getId()).ifPresent(e -> {
            e.setCriminalCase(e.getCriminalCase());
            e.setStorage(e.getStorage());
            e.setNumber(e.getNumber());
            e.setItemName(e.getItemName());
            e.setNotes(e.getNotes());
            e.setArchived(e.getArchived());
            e.setArchived(e.getArchived());
        });
    }

    @Override
    public void delete(Evidence evidence) {
        get(evidence.getId()).ifPresent(evidences::remove);
    }
}
