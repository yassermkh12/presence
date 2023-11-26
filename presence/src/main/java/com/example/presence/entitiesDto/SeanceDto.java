package com.example.presence.entitiesDto;

import com.example.presence.entities.enums.TypeSeance;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeanceDto {
    private Long id;
    private Date dateSeance;
    private TypeSeance typeSeance;
}
