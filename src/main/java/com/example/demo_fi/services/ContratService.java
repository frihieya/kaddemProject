package com.example.demo_fi.services;

import com.example.demo_fi.entities.Contrat;

import java.util.List;
import java.util.Optional;


public interface ContratService {
    List<Contrat> retrieveAllContrats();

    Contrat updateContrat (Contrat ce);

    Contrat addContrat (Contrat ce);

    Optional<Contrat> retrieveContrat (Integer idContrat);

    void removeContrat(Integer idContrat);


    Contrat affectContratToEtudiant(Integer contratId, String nomE, String prenomE);
}
