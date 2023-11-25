package com.example.presence.services.impl;

import com.example.presence.entities.Module;
import com.example.presence.entitiesDto.ModuleDto;
import com.example.presence.exceptions.NotFoundException;
import com.example.presence.repositories.IModuleRepository;
import com.example.presence.services.IModuleService;
import com.example.presence.transformers.ModuleTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ModuleService implements IModuleService {
    @Autowired
    private IModuleRepository moduleRepository;
    public List<ModuleDto> getAllModule(){
        List<Module> module = moduleRepository.findAll();
        return ModuleTransformer.entityToDtoList(module);
    }
    public ModuleDto getModuleById(Long id) throws NotFoundException {
        Module module = moduleRepository.findById(id).orElse(null);
        if (module != null){
            return ModuleTransformer.entityToDto(module);
        }else {
            throw new NotFoundException("il n y a pas de module avec id "+ id);
        }
    }
    public ModuleDto saveModule(ModuleDto moduleDto){
        Module module = ModuleTransformer.dtoToEntity(moduleDto);
        moduleRepository.save(module);
        return ModuleTransformer.entityToDto(module);
    }
    public ModuleDto updateModule(Long id, ModuleDto moduleDto) throws NotFoundException {
        Module module = moduleRepository.findById(id).orElse(null);

        if (module != null){
            module.setNomDuModule(moduleDto.getNomDuModule());
            module.setResponsableDuModule(moduleDto.getResponsableDuModule());
            module.setDureDuModule(moduleDto.getDureDuModule());

            moduleRepository.save(module);
            return ModuleTransformer.entityToDto(module);
        }else{
            throw new NotFoundException("il n y a pas de module avec id "+ id);
        }
    }
    public void deleteModule(Long id){
        moduleRepository.deleteById(id);
    }
}
