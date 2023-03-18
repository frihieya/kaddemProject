package com.example.demo_fi.repositories;

import com.example.demo_fi.entities.Department;
import com.example.demo_fi.entities.Etudiant;
import com.example.demo_fi.entities.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EtudiantRepository  extends JpaRepository<Etudiant,Integer> {
    List<Etudiant> findByDepartment(Department department);
    List<Etudiant> findByEquipesNiveau(Niveau niveau);
 //
    //   Etudiant findByNomELikeAndPrenomELike(String nomE,String prenomE);

    Etudiant findByNomLikeAndPrenomLike(String nom , String prenom);

}
