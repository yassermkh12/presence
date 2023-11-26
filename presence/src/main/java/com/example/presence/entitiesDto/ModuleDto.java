package com.example.presence.entitiesDto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModuleDto {
    private Long id;
    @NotNull(message = "le nom du module est obligatoire")
    @NotBlank(message = "le champ nom du module ne doit pas etre vide")
    private String nomDuModule;
    @NotNull(message = "le nom du responsable du module est obligatoire")
    @NotBlank(message = "le champ nom du responsabe du module ne doit pas etre vide")
    private String responsableDuModule;// La personne responsable de la conception, de l'enseignement ou de la gestion du module.
    @NotNull(message = "la duree du module est obligatoire")
    @NotBlank(message = "le champ duree du module ne doit pas etre vide")
    @Min(value = 1,message = "la duree minimum d un module est 1 mois")
    @Max(value = 12,message = "la duree maximum d un module est 12 mois")
    private String dureDuModule;
}
