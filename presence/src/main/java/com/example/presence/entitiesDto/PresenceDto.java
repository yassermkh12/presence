package com.example.presence.entitiesDto;

import com.example.presence.entities.enums.StatusPresence;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PresenceDto {
    private Long id;
    @NotNull(message = "la presence ne peut pas etre null")
    private StatusPresence statusPresence;
    @NotNull(message = "la validation de la presence doit etre non null")
    private boolean estValide;
    private SeanceDto seanceDto;
    private EtudiantDto etudiantDto;
}
