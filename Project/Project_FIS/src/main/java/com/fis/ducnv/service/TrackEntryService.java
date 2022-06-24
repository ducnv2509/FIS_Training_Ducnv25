package com.fis.ducnv.service;

import com.fis.ducnv.entities.Evidence;
import com.fis.ducnv.entities.TrackEntry;

import java.util.Set;

public interface TrackEntryService {
    TrackEntry addTrackEntry(TrackEntry trackEntry);

    TrackEntry updateTrackEntry(TrackEntry trackEntry);

    Set<TrackEntry> getTrackEntries();

    TrackEntry getTrackEntry(Long id);

    void deleteTrackEntry(Long id);
}
