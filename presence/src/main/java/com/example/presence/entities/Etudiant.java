package com.example.presence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "etudiant")
@NoArgsConstructor
@Data
public class Etudiant {
    @Id
    private Long id;
    private String nom;
    private String prenom;
    private String cin;
    private String email;
    private String password;
}
