package com.example.presence.entities;

import com.example.presence.entities.enums.TypeEcole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Table(name = "ecole")
@Data
@NoArgsConstructor
public class Ecole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String adresseEcole;
    private String nomDirecteur;
    private String dateDeFondation;
    @Enumerated(EnumType.STRING)
    private TypeEcole typeEcole;
    @OneToMany(mappedBy = "ecole", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "ecole_id")
    private List<Etudiant> etudiants;
}
