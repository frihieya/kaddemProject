package com.example.demo_fi.controllers;

import com.example.demo_fi.entities.Equipe;
import com.example.demo_fi.services.EquipeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/equipe")
public class EquipeController {

    @Autowired
    EquipeService equipeService;

    @GetMapping
    public List<Equipe> getEquipes() {
        return equipeService.retrieveAllEquipes();
    }

    @PostMapping
    public Equipe addEquipe(@RequestBody Equipe e) {
        return equipeService.addEquipe(e);
    }

    @PutMapping
    public Equipe updateEquipe (@RequestBody Equipe e) {
        return equipeService.updateEquipe(e);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteEquipe (@PathVariable Integer id) {
        equipeService.deleteEquipe(id);
    }

    @GetMapping(path = "/{id}")
    public Equipe getById(@PathVariable Integer id) {
        return equipeService.retrieveEquipe(id).orElse(null);
    }


}
