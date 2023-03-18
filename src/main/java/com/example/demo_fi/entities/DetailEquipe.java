package com.example.demo_fi.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DetailEquipe")
public class DetailEquipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetailEquipe", nullable = false)
    private Integer idDetailEquipe;

    @Column(name = "salle")
    private Integer salle;

    @Column(name = "thematique")
    private String thematique;

    @OneToOne(mappedBy = "detailEquipe")
    private Equipe equipe;


}