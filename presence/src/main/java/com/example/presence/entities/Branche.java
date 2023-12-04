package com.example.presence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Entity
@Table(name = "branche")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Branche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomBranche;
//    private String responsableDeBranche;//Chaque branche peut avoir un responsable administratif ou académique chargé de la superviser.
    @ManyToOne
    private Departement departement;

    @ManyToMany
    @JoinTable(name = "branche_module",
            joinColumns = @JoinColumn(name = "branche_id"),
            inverseJoinColumns = @JoinColumn(name = "module_id")
    )
    private List<Module> modules;

    @OneToOne
    @JoinColumn(name = "responsable_de_branche")
    private Employe responsableDeBranche;
}
