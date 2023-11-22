package com.example.presence.services;

import com.example.presence.entitiesDto.DepartementDto;
import com.example.presence.exceptions.NotFoundException;

import java.util.List;

public interface IDepartementService {
    public List<DepartementDto> getAllDepartement();
    public DepartementDto getDepartementById(Long id) throws NotFoundException;
    public DepartementDto saveDepartement(DepartementDto departementDto);
    public DepartementDto updateDepartement(Long id, DepartementDto departementDtoUpdate) throws NotFoundException;
    public void deleteDepartement(Long id);
}
