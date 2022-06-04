package com.fis.ducnv.dto;

import com.fis.ducnv.entities.Detective;
import com.fis.ducnv.entities.Person;
import com.fis.ducnv.util.EmploymentStatus;
import com.fis.ducnv.util.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DetectiveDAO implements DAO<Detective> {

    private final List<Detective> detectives = new ArrayList<>();

    @Override
    public List<Detective> getAll() {
        return detectives;
    }

    @Override
    public Optional<Detective> get(Long id) {
        return detectives.stream().filter(u -> u.getId().equals(id)).findFirst();
    }

    @Override
    public void save(Detective detective) {
        detectives.add(detective);
    }

    @Override
    public void update(Detective detective) {
        get(detective.getId()).ifPresent(e -> {
            e.setPerson(e.getPerson());
            e.setBadgeNumber(e.getBadgeNumber());
            e.setRank(e.getRank());
            e.setArmed(e.getArmed());
            e.setStatus(e.getStatus());
        });
    }

    @Override
    public void delete(Detective detective) {
        get(detective.getId()).ifPresent(detectives::remove);
    }
}
