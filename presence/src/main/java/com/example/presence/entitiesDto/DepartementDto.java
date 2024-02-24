package com.example.presence.entitiesDto;

import com.example.presence.entities.enums.StatutDepartement;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartementDto {
    private Long id;
    @NotBlank(message = "le champ nom du departement ne doit pas etre vide")
    @NotNull(message = "le nom du departement est obligatoire")
    private String nomDepartement;
//    @NotBlank(message = "le champ nom du chef de departement ne doit pas etre vide")
//    @NotNull(message = "le nom du chef de departement est obligatoire")
//    private String chefDepartement;
    @NotBlank(message = "l annee de creation du departement ne doit pas etre vide")
    @NotNull(message = "l annee de creation du departement est obligatoire")
//    @Pattern(regexp = "\\d$")
    @Min(1970)
    private String anneCreation;
    @NotNull(message = "le statut du departement est obligatoire")
    private StatutDepartement statutDepartement;
    private EmployeDto chefDepartement;
    private EcoleDto ecoleDto;
}
