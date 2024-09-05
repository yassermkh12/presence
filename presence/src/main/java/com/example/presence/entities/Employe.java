package com.example.presence.entities;

import com.example.presence.security.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employe")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employe extends User{
    private String poste;
    @OneToOne(mappedBy = "directeurEcole", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Ecole ecole;
    @OneToOne(mappedBy = "chefDepartement", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Departement departement;
    @OneToOne(mappedBy = "responsableDeBranche", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Branche branche;
    @OneToOne(mappedBy = "responsableDuModule", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Module module;

//    @OneToOne
//    @JoinColumn(name = "user_id")
//    private User employeUser;
}
