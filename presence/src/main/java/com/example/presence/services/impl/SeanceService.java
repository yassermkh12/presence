package com.example.presence.services.impl;

import com.example.presence.entities.Seance;
import com.example.presence.entitiesDto.SeanceDto;
import com.example.presence.exceptions.NotFoundException;
import com.example.presence.repositories.ISeanceRepository;
import com.example.presence.services.ISeanceService;
import com.example.presence.transformers.SeanceTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SeanceService implements ISeanceService {
    @Autowired
    private ISeanceRepository seanceRepository;

    public List<SeanceDto> getAllSeance(){
        List<Seance> seances = seanceRepository.findAll();
        return SeanceTransformer.entityToDtoList(seances);
    }
    public SeanceDto getSeanceById(Long id) throws NotFoundException {
        Seance seance = seanceRepository.findById(id).orElse(null);
        if (seance != null){
            return SeanceTransformer.entityToDto(seance);
        }else {
            throw new NotFoundException("il n y a pas de seance avec id "+ id);
        }
    }
    public SeanceDto saveSeance(SeanceDto seanceDto){
        Seance seance = SeanceTransformer.dtoToEntity(seanceDto);
        seanceRepository.save(seance);
        return SeanceTransformer.entityToDto(seance);
    }
    public SeanceDto updateSeance(Long id, SeanceDto seanceDto) throws NotFoundException {
        Seance seance = seanceRepository.findById(id).orElse(null);
        if (seance != null){
            seance.setTypeSeance(seanceDto.getTypeSeance());
            seance.setDateSeance(seanceDto.getDateSeance());

            seanceRepository.save(seance);
            return SeanceTransformer.entityToDto(seance);
        }else {
            throw new NotFoundException("il n y a pas de seance avec id "+ id);
        }
    }
    public void deleteSeance(Long id){
        seanceRepository.deleteById(id);
    }
}
