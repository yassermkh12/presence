package com.example.presence.services;

import com.example.presence.entitiesDto.EtudiantDto;
import com.example.presence.exceptions.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface IEtudiantService {
    public List<EtudiantDto> getAllEtudiant() throws NotFoundException;
    public Optional<EtudiantDto> getEtudiantById(Long id) throws NotFoundException;
    public EtudiantDto saveEtudiant(EtudiantDto etudiantDto);
    public EtudiantDto updateEtudiant(Long id, EtudiantDto etudiantDtoUpdate) throws NotFoundException;
    public void deleteEtudiant(Long id);
    public List<EtudiantDto> saveAllEtudiant(List<EtudiantDto> etudiantDtos);
}
