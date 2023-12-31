package com.example.presence.services.impl;

import com.example.presence.entities.Branche;
import com.example.presence.entities.Departement;
import com.example.presence.entities.Ecole;
import com.example.presence.entities.Module;
import com.example.presence.entitiesDto.BrancheDto;
import com.example.presence.entitiesDto.EcoleDto;
import com.example.presence.exceptions.NotFoundException;
import com.example.presence.repositories.IBrancheRepository;
import com.example.presence.repositories.IModuleRepository;
import com.example.presence.services.IBrancheService;
import com.example.presence.transformers.BrancheTransformer;
import com.example.presence.transformers.EcoleTransformer;
import com.example.presence.transformers.EmployeTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BrancheService implements IBrancheService {
    @Autowired
    private IBrancheRepository brancheRepository;
    @Autowired
    private IModuleRepository moduleRepository;
    public List<BrancheDto> getAllBranche(){
        List<Branche> branches = brancheRepository.findAll();
        return BrancheTransformer.entityToDtoList(branches);
    }
    public BrancheDto getBrancheById(Long id) throws NotFoundException {
        Branche branche = brancheRepository.findById(id).orElse(null);
        if(branche != null){
            return BrancheTransformer.entityToDto(branche);
        }else {
            throw new NotFoundException("Il n y a pas de branche avec l id : "+ id);
        }
    }
    public BrancheDto saveBranche(BrancheDto brancheDto){
        Branche branche = BrancheTransformer.dtoToEntity(brancheDto);
        brancheRepository.save(branche);
        return BrancheTransformer.entityToDto(branche);
    }
    public BrancheDto updateBranche(Long id, BrancheDto brancheDtoUpdate) throws NotFoundException {
        Branche branche = brancheRepository.findById(id).orElse(null);
        if(branche != null){
            branche.setNomBranche(brancheDtoUpdate.getNomBranche());
            branche.setResponsableDeBranche(EmployeTransformer.dtoToEntity(brancheDtoUpdate.getResponsableDeBranche()));

            brancheRepository.save(branche);
            return BrancheTransformer.entityToDto(branche);
        }else {
            throw new NotFoundException("Il n y a pas de branche avec l id : "+ id);
        }
    }
    public void deleteBranche(Long id){
        brancheRepository.deleteById(id);
    }

    public BrancheDto addModuleToBranche(Long brancheId, Long moduleId){
        Branche branche = brancheRepository.findById(brancheId).get();
        Module module = moduleRepository.findById(moduleId).get();

        List<Module> moduleList = null;
        moduleList = branche.getModules();
        moduleList.add(module);
        branche.setModules(moduleList);

        brancheRepository.save(branche);

        return BrancheTransformer.entityToDto(branche);
    }
}
