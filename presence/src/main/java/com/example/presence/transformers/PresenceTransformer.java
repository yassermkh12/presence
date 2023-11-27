package com.example.presence.transformers;

import com.example.presence.entities.Presences;
import com.example.presence.entitiesDto.PresenceDto;
import java.util.*;
import java.util.stream.Collectors;

public class PresenceTransformer {
    public static PresenceDto entityToDto(Presences presence){
        PresenceDto presenceDto = new PresenceDto();
        presenceDto.setId(presence.getId());
        presenceDto.setStatusPresence(presence.getStatusPresence());
        presenceDto.setEstValide(presence.isEstValide());
        presenceDto.setEtudiantDto(EtudiantTransformer.entityToDto(presence.getEtudiant()));
        presenceDto.setSeanceDto(SeanceTransformer.entityToDto(presence.getSeance()));

        return presenceDto;
    }
    public static Presences dtoToEntity(PresenceDto presenceDto){
        Presences presence = new Presences();
        presence.setId(presenceDto.getId());
        presence.setStatusPresence(presenceDto.getStatusPresence());
        presence.setEstValide(presenceDto.isEstValide());
        presence.setEtudiant(EtudiantTransformer.dtoToEntity(presenceDto.getEtudiantDto()));
        presence.setSeance(SeanceTransformer.dtoToEntity(presenceDto.getSeanceDto()));

        return presence;
    }
    public static List<PresenceDto> entityToDtoList(List<Presences> presences){
        return presences.stream()
                .map(PresenceTransformer::entityToDto)
                .collect(Collectors.toList());
    }
}
