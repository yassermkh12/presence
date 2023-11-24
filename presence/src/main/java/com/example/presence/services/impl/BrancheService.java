package com.example.presence.services.impl;

import com.example.presence.entities.Branche;
import com.example.presence.entitiesDto.BrancheDto;
import com.example.presence.exceptions.NotFoundException;
import com.example.presence.repositories.IBrancheRepository;
import com.example.presence.services.IBrancheService;
import com.example.presence.transformers.BrancheTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BrancheService implements IBrancheService {
    @Autowired
    private IBrancheRepository brancheRepository;
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
            branche.setResponsableDeBranche(brancheDtoUpdate.getResponsableDeBranche());

            brancheRepository.save(branche);
            return BrancheTransformer.entityToDto(branche);
        }else {
            throw new NotFoundException("Il n y a pas de branche avec l id : "+ id);
        }
    }
    public void deleteBranche(Long id){
        brancheRepository.deleteById(id);
    }
}
