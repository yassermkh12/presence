package com.example.presence.transformers;

import com.example.presence.entities.Seance;
import com.example.presence.entitiesDto.SeanceDto;
import java.util.*;
import java.util.stream.Collectors;

public class SeanceTransformer {
    public static SeanceDto entityToDto(Seance seance){
        SeanceDto seanceDto = new SeanceDto();
        seanceDto.setId(seance.getId());
        seanceDto.setDateSeance(seance.getDateSeance());
        seanceDto.setTypeSeance(seance.getTypeSeance());
        seanceDto.setModuleDto(ModuleTransformer.entityToDto(seance.getModule()));

        return seanceDto;
    }
    public static Seance dtoToEntity(SeanceDto seanceDto){
        Seance seance = new Seance();
        seance.setId(seanceDto.getId());
        seance.setDateSeance(seanceDto.getDateSeance());
        seance.setTypeSeance(seanceDto.getTypeSeance());
        seance.setModule(ModuleTransformer.dtoToEntity(seanceDto.getModuleDto()));

        return seance;
    }
    public static List<SeanceDto> entityToDtoList(List<Seance> seances){
        return seances.stream()
                .map(SeanceTransformer::entityToDto)
                .collect(Collectors.toList());
    }

}
