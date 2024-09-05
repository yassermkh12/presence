package com.example.presence.entitiesDto;

import com.example.presence.security.entitiesDto.UserDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

@Data
@NoArgsConstructor
public class EtudiantDto {
    private Long id;
    @NotBlank(message = "le champs nom ne doit pas etre vide")
    @NotNull(message = "le nom ne doit pas etre null")
    private String nom;
    @NotBlank(message = "le champ prenom ne doit pas etre vide")
    @NotNull(message = "le prenom ne doit pas etre null")
    private String prenom;
    @NotBlank(message = "le champ CIN ne doit pas etre vide")
    @NotNull(message = "CIN est obligatoire")
    @Pattern(regexp = "[A-Za-z]{2}\\d+$", message = "le code CIN doit comporter deux lettres en premier, suivi d une serie de nombre")
    private String cin;
    @NotNull(message = "le champ email ne doit pas etre null")
    @NotBlank(message = "l email est obligatoire")
    @Email(message = "adresse email est invalide")
    private String email;
    @NotNull(message = "le champ CNE ne doit pas etre null")
    @NotBlank(message = "le CNE est obligatoire")
    private String cne;
    private String userName;
    @NotBlank(message = "le champ numero de telephone ne doit pas etre vide")
    @NotNull(message = "le numero de telephone est obligatoire")
    @Pattern(regexp = "\\d{10}", message = "Le numéro de téléphone doit avoir 10 chiffres.")
    private String numeroTelephone;
    private EcoleDto ecoleDto;
//    private UserDto userDto;
}
