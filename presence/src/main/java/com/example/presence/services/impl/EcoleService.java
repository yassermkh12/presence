package com.example.presence.services.impl;

import com.example.presence.entities.Ecole;
import com.example.presence.entitiesDto.EcoleDto;
import com.example.presence.exceptions.NotFoundException;
import com.example.presence.repositories.IEcoleRepository;
import java.util.*;

import com.example.presence.services.IEcoleService;
import com.example.presence.transformers.EcoleTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EcoleService implements IEcoleService {
    @Autowired
    private IEcoleRepository ecoleRepository;
    public List<EcoleDto> getAllEcole(){
        List<Ecole> ecoles = ecoleRepository.findAll();
        return EcoleTransformer.entityToDtoList(ecoles);
    }
    public Optional<EcoleDto> getEcoleById(Long id) throws NotFoundException {
        Optional<Ecole> ecoleOptional = ecoleRepository.findById(id);
        if(ecoleOptional.isPresent()){
            return ecoleOptional.map(EcoleTransformer::entityToDto);
        }
        else {
            throw new NotFoundException("il n y a pas d ecole avec l id : "+ id);
        }
    }
    public EcoleDto saveEcole(EcoleDto ecoleDto){
        Ecole ecole = EcoleTransformer.dtoToEntity(ecoleDto);
        ecoleRepository.save(ecole);
        return EcoleTransformer.entityToDto(ecole);
    }
    public EcoleDto updateEcole(Long id, EcoleDto ecoleDtoUpdate) throws NotFoundException {
        Optional<Ecole> ecoleOptional = ecoleRepository.findById(id);

        if(ecoleOptional.isPresent()){
            Ecole ecole = ecoleOptional.get();
            ecole.setAdresseEcole(ecoleDtoUpdate.getAdresseEcole());
            ecole.setNomDirecteur(ecoleDtoUpdate.getNomDirecteur());
            ecole.setDateDeFondation(ecoleDtoUpdate.getDateDeFondation());
            ecole.setTypeEcole(ecoleDtoUpdate.getTypeEcole());

            ecoleRepository.save(ecole);
            return EcoleTransformer.entityToDto(ecole);
        }
        else throw new NotFoundException("il n y a pas d ecole avec l id : "+ id);
    }
    public void DeleteById(Long id){
        ecoleRepository.deleteById(id);
    }
}
