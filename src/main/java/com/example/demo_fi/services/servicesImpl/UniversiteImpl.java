package com.example.demo_fi.services.servicesImpl;

import com.example.demo_fi.entities.Department;
import com.example.demo_fi.entities.Universite;
import com.example.demo_fi.repositories.DepartmentRepository;
import com.example.demo_fi.repositories.UniversiteRepository;
import com.example.demo_fi.services.UniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversiteImpl implements UniversiteService {


    @Autowired
    UniversiteRepository universiteRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<Universite> retrieveAllUniversites() {
      return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Optional<Universite> retrieveUniversite(Integer idUniversite) {
        return universiteRepository.findById(idUniversite);
    }

    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
        Universite universite = universiteRepository.findById(idUniversite).orElseThrow();
        Department dept = departmentRepository.findById(idDepartement).orElseThrow();
        universite.getDepartments().add(dept);
        universiteRepository.save(universite);
    }
}
