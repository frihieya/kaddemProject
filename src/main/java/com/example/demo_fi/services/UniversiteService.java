package com.example.demo_fi.services;

import com.example.demo_fi.entities.Universite;

import java.util.List;
import java.util.Optional;

public interface UniversiteService {
    List<Universite> retrieveAllUniversites();
    Universite addUniversite (Universite u);
    Universite updateUniversite (Universite u);
    Optional<Universite> retrieveUniversite (Integer idUniversite);
     void assignUniversiteToDepartement(Integer idUniversite, Integer
            idDepartement);
}
