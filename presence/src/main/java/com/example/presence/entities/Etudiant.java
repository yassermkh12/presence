package com.example.presence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "etudiant")
@NoArgsConstructor
@Data
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @NotBlank(message = "le champs nom ne doit pas etre vide")
//    @NotNull(message = "le nom ne doit pas etre null")
    private String nom;
//    @NotBlank(message = "le champ prenom ne doit pas etre vide")
//    @NotNull(message = "le prenom ne doit pas etre null")
    private String prenom;
//    @NotBlank(message = "le champ CIN ne doit pas etre vide")
//    @NotNull(message = "CIN est obligatoire")
//    @Pattern(regexp = "[A-Za-z]{2}\\d+$", message = "le code CIN doit comporter deux lettres en premier, suivi d une serie de nombre")
    private String cin;
//    @NotNull(message = "le champ email ne doit pas etre null")
//    @NotBlank(message = "l email est obligatoire")
//    @Email(message = "adresse email est invalide")
    private String email;
//    @NotNull(message = "le champ Password ne doit pas etre null")
//    @NotBlank(message = "le Password est obligatoire")
    private String password;
    @ManyToOne
    private Ecole ecole;
}
