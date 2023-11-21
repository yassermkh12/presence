package com.example.presence.entitiesDto;

import com.example.presence.entities.enums.TypeEcole;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class EcoleDto {
    private Long id;
    private String adresseEcole;
    private String nomDirecteur;
    private Date dateDeFondation;
    private TypeEcole typeEcole;
}
