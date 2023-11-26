package com.example.presence.services;

import com.example.presence.entitiesDto.SeanceDto;
import com.example.presence.exceptions.NotFoundException;

import java.util.List;

public interface ISeanceService {
    public List<SeanceDto> getAllSeance();
    public SeanceDto getSeanceById(Long id) throws NotFoundException;
    public SeanceDto saveSeance(SeanceDto seanceDto);
    public SeanceDto updateSeance(Long id, SeanceDto seanceDto) throws NotFoundException;
    public void deleteSeance(Long id);
}
