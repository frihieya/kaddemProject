package com.example.demo_fi.services.servicesImpl;

import com.example.demo_fi.entities.Contrat;
import com.example.demo_fi.entities.Etudiant;
import com.example.demo_fi.repositories.ContratRepository;
import com.example.demo_fi.repositories.EtudiantRepository;
import com.example.demo_fi.services.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ContratImpl implements ContratService {

    @Autowired
   ContratRepository contratRepository;
    @Autowired
    EtudiantRepository etudiantRepository;

    @Override
    public List<Contrat> retrieveAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat updateContrat(Contrat ce) {
        return contratRepository.save(ce);
    }

    @Override
    public Contrat addContrat(Contrat ce) {
        return contratRepository.save(ce);
    }

    @Override
    public Optional<Contrat> retrieveContrat(Integer idContrat) {
        return contratRepository.findById(idContrat);
    }

    @Override
    public void removeContrat(Integer idContrat) {
      contratRepository.deleteById(idContrat);
    }



    @Override
    public Contrat affectContratToEtudiant(Integer contratId, String nomE, String prenomE) {
        System.out.println(nomE+prenomE);
        Contrat ce= contratRepository.findById(contratId).orElseThrow();

        Etudiant e = etudiantRepository.findByNomLikeAndPrenomLike(nomE,prenomE);
        ce.setEtudiant(e);
        System.out.println(e);
        contratRepository.save(ce);
        System.out.println(ce);
        return contratRepository.save(ce);
    }
}
