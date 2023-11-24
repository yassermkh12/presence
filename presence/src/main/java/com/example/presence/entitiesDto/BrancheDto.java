package com.example.presence.entitiesDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrancheDto {
    private Long id;
    private String nomBranche;
    private String responsableDeBranche;
}
