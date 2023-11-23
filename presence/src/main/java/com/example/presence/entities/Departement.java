package com.example.presence.entities;

import com.example.presence.entities.enums.StatutDepartement;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

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
    @Enumerated(EnumType.STRING)
    private StatutDepartement statutDepartement;

    @JsonIgnore
    @ManyToMany(mappedBy = "departements", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Ecole> ecoles;
}
