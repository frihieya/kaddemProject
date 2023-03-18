package com.example.demo_fi.controllers;

import com.example.demo_fi.entities.Etudiant;
import com.example.demo_fi.exceptions.ExceptionTothrow;
import com.example.demo_fi.services.EtudiantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantController {

    private final EtudiantService etudiantService;
    @GetMapping
    public List<Etudiant> getAll() {
        return etudiantService.retrieveAllEtudiants();
    }

    @PostMapping
    public Etudiant add(@RequestBody Etudiant e) {
        return etudiantService.addEtudiant(e);
    }

    @PutMapping
    public Etudiant update (@RequestBody Etudiant e) {
        return etudiantService.updateEtudiant(e);
    }

    @DeleteMapping(path = "/{id}")
    public void delete (@PathVariable Integer id) {
        etudiantService.removeEtudiant(id);
    }

    @GetMapping(path = "/{id}")
    public Etudiant getById(@PathVariable Integer id) {
        return etudiantService.retrieveEtudiant(id).orElse(null);
    }

    @PostMapping("/{etudiantId}/{departementId}")
    public void assignEtudiantToDepartement(@PathVariable Integer etudiantId,@PathVariable Integer departementId) {
       try {
           etudiantService.assignEtudiantToDepartement(etudiantId, departementId);
       }catch (Exception e) {
           throw new RuntimeException("not existing id ");
       }
    }

    @PostMapping("addAndAssign/{idContrat}/{idEquipe}")
    Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant e,@PathVariable Integer idContrat,
                                                     @PathVariable Integer idEquipe){
        return etudiantService.addAndAssignEtudiantToEquipeAndContract(e,idContrat,idEquipe);
    }

}
