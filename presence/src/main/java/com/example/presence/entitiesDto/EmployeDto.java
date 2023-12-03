package com.example.presence.entitiesDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeDto {
    private Long id;
    private String nom;
    private String prenom;
    private String numeroTelephone;
    private String email;
    private String poste;
}
