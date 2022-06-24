package com.fis.ducnv.service;

import com.fis.ducnv.entities.CriminalCase;
import com.fis.ducnv.entities.Detective;

import java.util.Set;

public interface DetectiveService {
    Detective addDetective(Detective detective);

    Detective updateDetective(Detective detective);

    Set<Detective> getDetectives();

    Detective getDetective(Long id);

    void deleteDetective(Long id);

}
