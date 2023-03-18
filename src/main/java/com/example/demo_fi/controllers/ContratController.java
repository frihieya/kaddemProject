package com.example.demo_fi.controllers;


import com.example.demo_fi.entities.Contrat;
import com.example.demo_fi.entities.Equipe;
import com.example.demo_fi.services.ContratService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name="contrat api ")
@RestController
@AllArgsConstructor
@RequestMapping("/contract")
public class ContratController {


    @Autowired
    ContratService contratService;

    @Operation(description = "get all contrats")
    @GetMapping
    public List<Contrat> getAll() {
        return contratService.retrieveAllContrats();
    }

    @PostMapping
    public Contrat add(@RequestBody Contrat e) {
        return contratService.addContrat(e);
    }

    @PutMapping
    public Contrat update (@RequestBody Contrat e) {
        return contratService.updateContrat(e);
    }

    @DeleteMapping(path = "/{id}")
    public void delete (@PathVariable Integer id) {
        contratService.removeContrat(id);
    }

    @GetMapping(path = "/{id}")
    public Contrat getById(@PathVariable Integer id) {
        return contratService.retrieveContrat(id).orElse(null);
    }

    @PostMapping(path ="/assign/{id}/{nomE}/{prenomE}" )
    public Contrat affectContratToEtudiant(@PathVariable("id") Integer contratId,
                                           @PathVariable("nomE") String nomE,
                                           @PathVariable ("prenomE")String prenomE) {
        return contratService.affectContratToEtudiant(contratId, nomE, prenomE);
    }
}
