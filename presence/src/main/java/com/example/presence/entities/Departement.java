package com.example.presence.entities;

import com.example.presence.entities.enums.StatutDepartement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "departement")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomDepartement;
    private String chefDepartement;
    private String anneCreation;
    private StatutDepartement statutDepartement;
}
