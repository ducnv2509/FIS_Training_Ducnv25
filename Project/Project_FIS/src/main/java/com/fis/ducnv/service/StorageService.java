package com.fis.ducnv.service;

import com.fis.ducnv.entities.Storage;
import com.fis.ducnv.entities.TrackEntry;

import java.util.Set;

public interface StorageService {
    Storage addStorage(Storage storage);

    Storage updateStorage(Storage storage);

    Set<Storage> getStorages();

    Storage getStorage(Long id);

    void deleteStorage(Long id);
}
