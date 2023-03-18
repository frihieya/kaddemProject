package com.example.demo_fi.controllers;


import com.example.demo_fi.entities.Universite;
import com.example.demo_fi.services.UniversiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/universite")
public class UniversiteController {


    private final UniversiteService universiteService;
    @GetMapping
    public List<Universite> getAll() {
        return universiteService.retrieveAllUniversites();
    }

    @PostMapping
    public Universite add(@RequestBody Universite e) {
        return universiteService.addUniversite(e);
    }

    @PutMapping
    public Universite update (@RequestBody Universite e) {
        return universiteService.updateUniversite(e);
    }

    @GetMapping(path = "/{id}")
    public Universite getById (@PathVariable Integer id) {
        return universiteService.retrieveUniversite(id).orElse(null);
    }
    @PostMapping("/assignDepartment/{idUniv}/{idDept}")
    public void assignUniversiteToDepartement(@PathVariable Integer idUniv ,@PathVariable Integer idDept) {
         universiteService.assignUniversiteToDepartement(idUniv,idDept);
    }
}

