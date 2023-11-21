package com.example.presence.entities;

import com.example.presence.entities.enums.TypeEcole;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    private Date dateDeFondation;
    @Enumerated(EnumType.STRING)
    private TypeEcole typeEcole;
}
