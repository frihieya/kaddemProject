package com.example.demo_fi.entities;

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
@Table(name = "equipe")
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEquipe", nullable = false)
    private Integer idEquipe;


    @Column(name = "nomEquipe")
    private String nomEquipe;


    @Column(name = "niveau")
    @Enumerated(EnumType.STRING)
    private Niveau niveau;


    @OneToOne
    private DetailEquipe detailEquipe;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Etudiant> etudiants;


}
