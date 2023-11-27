package com.example.presence.entitiesDto;

import com.example.presence.entities.enums.StatusPresence;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PresenceDto {
    private Long id;
    private StatusPresence statusPresence;
    private boolean estValide;
}
