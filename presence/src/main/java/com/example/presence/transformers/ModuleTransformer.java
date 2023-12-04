package com.example.presence.transformers;

import com.example.presence.entities.Module;
import com.example.presence.entitiesDto.ModuleDto;
import java.util.*;
import java.util.stream.Collectors;

public class ModuleTransformer {
    public static ModuleDto entityToDto(Module module){
        ModuleDto moduleDto = new ModuleDto();
        moduleDto.setId(module.getId());
        moduleDto.setNomDuModule(module.getNomDuModule());
        moduleDto.setDureDuModule(module.getDureDuModule());
        moduleDto.setResponsableDuModule(EmployeTransformer.entityToDto(module.getResponsableDuModule()));

        return moduleDto;
    }
    public static Module dtoToEntity(ModuleDto moduleDto){
        Module module = new Module();
        module.setId(moduleDto.getId());
        module.setDureDuModule(moduleDto.getDureDuModule());
        module.setNomDuModule(moduleDto.getNomDuModule());
        module.setResponsableDuModule(EmployeTransformer.dtoToEntity(moduleDto.getResponsableDuModule()));

        return module;
    }
    public static List<ModuleDto> entityToDtoList(List<Module> modules){
        return modules.stream()
                .map(ModuleTransformer::entityToDto)
                .collect(Collectors.toList());
    }
}
