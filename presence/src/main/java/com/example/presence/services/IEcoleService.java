package com.example.presence.services;

import com.example.presence.entities.Ecole;
import com.example.presence.entitiesDto.EcoleDto;
import com.example.presence.exceptions.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface IEcoleService {
    public List<EcoleDto> getAllEcole();
    public Optional<EcoleDto> getEcoleById(Long id) throws NotFoundException;
    public EcoleDto saveEcole(EcoleDto ecoleDto);
    public EcoleDto updateEcole(Long id, EcoleDto ecoleDtoUpdate) throws NotFoundException;
    public void DeleteById(Long id);
//    public EcoleDto addDepartementToEcole(Long ecoleId, Long departementId);
}
