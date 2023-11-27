package com.example.presence.transformers;

import com.example.presence.entities.Presence;
import com.example.presence.entitiesDto.PresenceDto;
import java.util.*;
import java.util.stream.Collectors;

public class PresenceTransformer {
    public static PresenceDto entityToDto(Presence presence){
        PresenceDto presenceDto = new PresenceDto();
        presenceDto.setId(presence.getId());
        presenceDto.setStatusPresence(presence.getStatusPresence());
        presenceDto.setEstValide(presence.isEstValide());

        return presenceDto;
    }
    public static Presence dtoToEntity(PresenceDto presenceDto){
        Presence presence = new Presence();
        presence.setId(presenceDto.getId());
        presence.setStatusPresence(presenceDto.getStatusPresence());
        presence.setEstValide(presenceDto.isEstValide());

        return presence;
    }
    public static List<PresenceDto> entityToDtoList(List<Presence> presences){
        return presences.stream()
                .map(PresenceTransformer::entityToDto)
                .collect(Collectors.toList());
    }
}
