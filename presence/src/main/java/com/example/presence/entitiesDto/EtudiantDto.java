package com.example.presence.entitiesDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EtudiantDto {
    private Long id;
    private String nom;
    private String prenom;
    private String cin;
    private String email;
    private String password;
}
