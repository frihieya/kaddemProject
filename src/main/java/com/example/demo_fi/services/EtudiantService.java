package com.example.demo_fi.services;

import com.example.demo_fi.entities.Contrat;
import com.example.demo_fi.entities.Etudiant;
import com.example.demo_fi.exceptions.ExceptionTothrow;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



public interface EtudiantService {
    List<Etudiant> retrieveAllEtudiants();

    Etudiant addEtudiant (Etudiant e);

    Etudiant updateEtudiant (Etudiant e);

    Optional<Etudiant> retrieveEtudiant(Integer idEtudiant);

    void removeEtudiant(Integer idEtudiant);

    void assignEtudiantToDepartement(Integer etudiantId, Integer departementId) throws ExceptionTothrow;

    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe);
}
