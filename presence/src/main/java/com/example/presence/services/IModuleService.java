package com.example.presence.services;

import com.example.presence.entitiesDto.ModuleDto;
import com.example.presence.exceptions.NotFoundException;

import java.util.List;

public interface IModuleService {
    public List<ModuleDto> getAllModule();
    public ModuleDto getModuleById(Long id) throws NotFoundException;
    public ModuleDto saveModule(ModuleDto moduleDto);
    public ModuleDto updateModule(Long id, ModuleDto moduleDto) throws NotFoundException;
    public void deleteModule(Long id);
}
