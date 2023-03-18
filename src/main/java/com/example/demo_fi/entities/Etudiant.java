package com.example.demo_fi.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {

    @Id
    private Integer id;

    private String nom;
    private  String prenom;

    @Enumerated(EnumType.STRING)
    private  Niveau niveau;
   @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "etudiant")
    private List<Contrat> contrats;
    @JsonIgnore
    @ManyToOne
    private Department department;
    @JsonIgnore
    @ManyToMany(mappedBy = "etudiants",cascade = CascadeType.ALL)
    private List<Equipe> equipes;
}
