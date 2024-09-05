package com.example.presence.services;

import com.example.presence.entitiesDto.EmployeDto;
import com.example.presence.exceptions.NotFoundException;
import com.example.presence.security.exceptions.GlobalException;

import java.util.List;

public interface IEmployeService {
    public List<EmployeDto> getAllEmploye();
    public EmployeDto getEmployeById(Long id) throws NotFoundException;
    public EmployeDto saveEmploye(EmployeDto employeDto) throws GlobalException;
    public List<EmployeDto> saveAllEmploye(List<EmployeDto> employeDtos);
    public EmployeDto updateEmploye(Long id, EmployeDto employeDto) throws NotFoundException,GlobalException;
    public void deleteEmploye(Long id);
}
