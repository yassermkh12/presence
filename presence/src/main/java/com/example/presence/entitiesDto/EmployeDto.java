package com.example.presence.entitiesDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeDto {
    private Long id;
    @NotBlank(message = "le champ nom ne doit pas etre vide")
    @NotNull(message = "le nom est obligatoire")
    private String nom;
    @NotBlank(message = "le champ prenom ne doit pas etre vide")
    @NotNull(message = "le prenom est obligatoire")
    private String prenom;
    @NotBlank(message = "le champ numero de telephone ne doit pas etre vide")
    @NotNull(message = "le numero de telephone est obligatoire")
    @Pattern(regexp = "\\d{10}", message = "Le numéro de téléphone doit avoir 10 chiffres.")
    private String numeroTelephone;
    @NotBlank(message = "l email ne doit pas etre vide")
    @NotNull(message = "l email est obligatoire")
    @Email(message = "adresse email est invalide")
    private String email;
    @NotBlank(message = "le champ poste ne doit pas etre vide")
    @NotNull(message = "le poste est obligatoire")
    private String poste;
}
