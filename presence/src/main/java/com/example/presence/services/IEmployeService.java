package com.example.presence.services;

import com.example.presence.entitiesDto.EmployeDto;
import com.example.presence.exceptions.NotFoundException;

import java.util.List;

public interface IEmployeService {
    public List<EmployeDto> getAllEmploye();
    public EmployeDto getEmployeById(Long id) throws NotFoundException;
    public EmployeDto saveEmploye(EmployeDto employeDto);
    public List<EmployeDto> saveAllEmploye(List<EmployeDto> employeDtos);
    public EmployeDto updateEmploye(Long id, EmployeDto employeDto) throws NotFoundException;
    public void deleteEmploye(Long id);
}
