package com.example.presence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String responsableDeBranche;//Chaque branche peut avoir un responsable administratif ou académique chargé de la superviser.
}
