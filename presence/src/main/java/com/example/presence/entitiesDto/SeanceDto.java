package com.example.presence.entitiesDto;

import com.example.presence.entities.enums.TypeSeance;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeanceDto {
    private Long id;
    @NotNull(message = "La date ne peut pas être nulle")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Le format de la date doit être yyyy-MM-dd")
    private String dateSeance;
    @NotNull(message = "le type de seance est obligatoire")
    private TypeSeance typeSeance;
    private ModuleDto moduleDto;
}
