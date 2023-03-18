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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDpart", nullable = false)
    private Integer idDpart;

    private String nomDepart;

  @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "department")
    List<Etudiant> etudiants;


}
