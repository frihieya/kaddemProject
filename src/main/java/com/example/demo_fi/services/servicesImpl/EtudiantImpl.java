package com.example.demo_fi.services.servicesImpl;

import com.example.demo_fi.entities.Contrat;
import com.example.demo_fi.entities.Department;
import com.example.demo_fi.entities.Equipe;
import com.example.demo_fi.entities.Etudiant;
import com.example.demo_fi.exceptions.ExceptionTothrow;
import com.example.demo_fi.repositories.ContratRepository;
import com.example.demo_fi.repositories.DepartmentRepository;
import com.example.demo_fi.repositories.EquipeRepository;
import com.example.demo_fi.repositories.EtudiantRepository;
import com.example.demo_fi.services.EtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EtudiantImpl implements EtudiantService {


   private final EtudiantRepository etudiantRepository;

    private final DepartmentRepository departmentRepository;

    private final ContratRepository contratRepository;
    private final EquipeRepository equipeRepository;


    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Optional<Etudiant> retrieveEtudiant(Integer idEtudiant) {
        return etudiantRepository.findById(idEtudiant);
    }

    @Override
    public void removeEtudiant(Integer idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);

    }

    @Override
    public void assignEtudiantToDepartement(Integer etudiantId, Integer departementId) throws ExceptionTothrow {
        Etudiant e = etudiantRepository.findById(etudiantId).orElseThrow();
        Department d = departmentRepository.findById(departementId).orElseThrow(()->new ExceptionTothrow("not existing id etudiant"));
        e.setDepartment(d);
        etudiantRepository.save(e);
    }

    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {
        Equipe equipe = equipeRepository.findById(idEquipe).orElseThrow();
        Contrat contrat = contratRepository.findById(idContrat).orElseThrow();
        Etudiant etudiant = etudiantRepository.save(e);
        equipe.getEtudiants().add(etudiant);
        contrat.setEtudiant(etudiant);
        equipeRepository.save(equipe);
        contratRepository.save(contrat);
        return etudiant;
    }


}
