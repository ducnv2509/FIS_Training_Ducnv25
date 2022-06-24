package com.fis.ducnv.controller;

import com.fis.ducnv.entities.CriminalCase;
import com.fis.ducnv.service.CriminalCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/criminalCase")
@CrossOrigin("*")
public class CriminalCaseController {

    @Autowired
    private CriminalCaseService criminalCaseService;

    @PostMapping("/")
    public ResponseEntity<CriminalCase> addCriminalCase(@RequestBody CriminalCase criminalCase) {
        CriminalCase criminalCase1 = this.criminalCaseService.addCriminalCase(criminalCase);
        return ResponseEntity.ok(criminalCase1);
    }

    @PutMapping("/")
    public CriminalCase updateCriminalCase(@RequestBody CriminalCase criminalCase) {
        return this.criminalCaseService.updateCriminalCase(criminalCase);
    }

    @DeleteMapping("/{id}")
    public void deleteCriminalCase(@PathVariable Long id) {
        this.criminalCaseService.deleteCriminalCase(id);
    }

    @GetMapping("/")
    public Set<CriminalCase> getCriminalCases() {
        return this.criminalCaseService.getCriminalCases();
    }
}
