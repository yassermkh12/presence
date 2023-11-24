package com.example.presence.entitiesDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrancheDto {
    private Long id;
    @NotNull(message = "le nom de la branche est obligatoire")
    @NotBlank(message = "le champ nom de la branche ne doit pas etre vide")
    private String nomBranche;
    @NotNull(message = "le nom du responsable de la branche est obligatoire")
    @NotBlank(message = "le champ nom du responsable de la branche ne doit pas etre vide")
    private String responsableDeBranche;
    private DepartementDto departementDto;
}
