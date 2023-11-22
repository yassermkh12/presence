package com.example.presence.entitiesDto;

import com.example.presence.entities.enums.StatutDepartement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartementDto {
    private Long id;
    private String nomDepartement;
    private String chefDepartement;
    private String anneCreation;
    private StatutDepartement statutDepartement;
}
