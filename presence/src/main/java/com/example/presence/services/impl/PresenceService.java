package com.example.presence.services.impl;

import com.example.presence.entities.Presences;
import com.example.presence.entitiesDto.PresenceDto;
import com.example.presence.exceptions.NotFoundException;
import com.example.presence.repositories.IPresenceRepository;
import com.example.presence.services.IPresenceService;
import com.example.presence.transformers.PresenceTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PresenceService implements IPresenceService{
    @Autowired
    private IPresenceRepository presenceRepository;
    public List<PresenceDto> getAllPresence(){
        List<Presences> presences = presenceRepository.findAll();
        return PresenceTransformer.entityToDtoList(presences);
    }
    public PresenceDto getPresenceById(Long id) throws NotFoundException {
        Presences presence = presenceRepository.findById(id).orElse(null);
        if(presence != null) {
            return PresenceTransformer.entityToDto(presence);
        }else {
            throw new NotFoundException("il n y a pas de presence avec id "+ id);
        }
    }
    public PresenceDto savePresence(PresenceDto presenceDto){
        Presences presence = PresenceTransformer.dtoToEntity(presenceDto);
        presenceRepository.save(presence);
        return PresenceTransformer.entityToDto(presence);
    }
    public PresenceDto updatePresence(Long id, PresenceDto presenceDto) throws NotFoundException {
        Presences presence = presenceRepository.findById(id).orElse(null);
        if (presence != null){
            presence.setStatusPresence(presenceDto.getStatusPresence());
            presence.setEstValide(presenceDto.isEstValide());

            presenceRepository.save(presence);
            return PresenceTransformer.entityToDto(presence);
        }else {
            throw new NotFoundException("il n y a pas de presence avec id "+ id);
        }
    }
    public void deletePresence(Long id){
        presenceRepository.deleteById(id);
    }
}
