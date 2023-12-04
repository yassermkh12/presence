package com.example.presence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employe")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String numeroTelephone;
    private String email;
    private String poste;
    @OneToOne(mappedBy = "directeurEcole", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Ecole ecole;
    @OneToOne(mappedBy = "chefDepartement", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Departement departement;
    @OneToOne(mappedBy = "responsableDeBranche", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Branche branche;
    @OneToOne(mappedBy = "responsableDuModule", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Module module;
}
