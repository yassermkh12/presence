package com.example.presence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Entity
@Table(name = "module")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomDuModule;
//    private String responsableDuModule;// La personne responsable de la conception, de l'enseignement ou de la gestion du module.
    private String dureDuModule;
    @ManyToMany(mappedBy = "modules", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Branche> branches;
    @OneToOne(mappedBy = "module", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Seance seance;
    @OneToOne
    @JoinColumn(name = "responsable_de_module")
    private Employe responsableDuModule;
}
