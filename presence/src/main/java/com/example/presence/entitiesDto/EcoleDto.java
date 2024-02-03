package com.example.presence.entitiesDto;

import com.example.presence.entities.enums.TypeEcole;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.*;

@Data
@NoArgsConstructor
public class EcoleDto {
    private Long id;
    @NotBlank(message = "le champ adresse ecole ne doit pas etre vide")
    @NotNull(message = "adresse de l ecole est obligatoire")
    private String adresseEcole;
    @NotBlank(message = "le champ nom ecole ne doit pas etre vide")
    @NotNull(message = "nom de l ecole est obligatoire")
    private String nomEcole;
//    @NotBlank(message = "le champ nom du directeur ne doit pas etre vide")
//    @NotNull(message = "Nom du directeur de l ecole est obligatoire")
//    private String nomDirecteur;
    @NotBlank(message = "le champ date de fondation ne doit pas etre vide")
    @NotNull(message = "la date de fondation est obligatoire est obligatoire")
//    @Pattern(regexp = "\\d+5$", message = "la date de fondation ne doit depasser 4 chiffre")
    @Min(value = 1970, message = "la date ne doit pas etre inferieur a 1970")
    @Max(value = 2023, message = "la date ne doit pas depasser la date actuelle")
    private String dateDeFondation;
//    @NotBlank(message = "le champ adresse ecole ne doit pas etre vide")
    @NotNull(message = "le type d ecole est obligatoire")
    private TypeEcole typeEcole;
//    private List<DepartementDto> departementDtos;
    private EmployeDto directeurEcole;
}
