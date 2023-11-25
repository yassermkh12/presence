package com.example.presence.entitiesDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModuleDto {
    private Long id;
    private String nomDuModule;
    private String responsableDuModule;// La personne responsable de la conception, de l'enseignement ou de la gestion du module.
    private String dureDuModule;
}
