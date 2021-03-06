package com.fis.ducnv.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fis.ducnv.entities.CriminalCase;
import com.fis.ducnv.entities.Detective;
import com.fis.ducnv.entities.Evidence;
import com.fis.ducnv.service.DetectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/detective")
@CrossOrigin("*")
public class DetectiveController {
    @Autowired
    DetectiveService detectiveService;



    @GetMapping("/")
    public Set<Detective> getDetectives() {
        return this.detectiveService.getDetectives();
    }

    @PostMapping("/")
    public ResponseEntity<Detective> addDetective(@RequestBody Detective detective) {
        return ResponseEntity.ok(this.detectiveService.addDetective(detective));
    }

    @PutMapping("/")
    public Detective updateDetective(@RequestBody Detective detective) {
        return this.detectiveService.updateDetective(detective);
    }

    @DeleteMapping("/{id}")
    public void deleteDetective(@PathVariable Long id) {
         this.detectiveService.deleteDetective(id);
    }
}
