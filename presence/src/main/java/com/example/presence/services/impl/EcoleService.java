package com.example.presence.services.impl;

import com.example.presence.entities.Departement;
import com.example.presence.entities.Ecole;
import com.example.presence.entitiesDto.EcoleDto;
import com.example.presence.exceptions.NotFoundException;
import com.example.presence.repositories.IDepartementRepository;
import com.example.presence.repositories.IEcoleRepository;
import java.util.*;

import com.example.presence.services.IEcoleService;
import com.example.presence.transformers.EcoleTransformer;
import com.example.presence.transformers.EmployeTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class EcoleService implements IEcoleService {
    @Autowired
    private IEcoleRepository ecoleRepository;
    @Autowired
    private IDepartementRepository departementRepository;
    public List<EcoleDto> getAllEcole(){
        List<Ecole> ecoles = ecoleRepository.findAll();
        log.info("les ecole dans la base de donnees sont : "+ ecoles);
        return EcoleTransformer.entityToDtoList(ecoles);
    }
    public Optional<EcoleDto> getEcoleById(Long id) throws NotFoundException {
        Optional<Ecole> ecoleOptional = ecoleRepository.findById(id);
        if(ecoleOptional.isPresent()){
            log.info("l ecole avec l id : "+ id + " existe " + ecoleOptional);
            return ecoleOptional.map(EcoleTransformer::entityToDto);
        }
        else {
            log.info("il n y a pas d ecole avec id "+ id);
            throw new NotFoundException("il n y a pas d ecole avec l id : "+ id);
        }
    }
    public EcoleDto saveEcole(EcoleDto ecoleDto){
        Ecole ecole = EcoleTransformer.dtoToEntity(ecoleDto);
        ecoleRepository.save(ecole);
        log.info("l ecole est enregistres avec id : "+ ecole.getId());
        return EcoleTransformer.entityToDto(ecole);
    }
    public EcoleDto updateEcole(Long id, EcoleDto ecoleDtoUpdate) throws NotFoundException {
        Optional<Ecole> ecoleOptional = ecoleRepository.findById(id);

        if(ecoleOptional.isPresent()){
            log.info("l ecole avec l id : "+ id + " existe " + ecoleOptional);
            Ecole ecole = ecoleOptional.get();
            ecole.setAdresseEcole(ecoleDtoUpdate.getAdresseEcole());
//            ecole.setNomDirecteur(ecoleDtoUpdate.getNomDirecteur());
            ecole.setDateDeFondation(ecoleDtoUpdate.getDateDeFondation());
            ecole.setTypeEcole(ecoleDtoUpdate.getTypeEcole());
            ecole.setDirecteurEcole(EmployeTransformer.dtoToEntity(ecoleDtoUpdate.getDirecteurEcole()));

            ecoleRepository.save(ecole);
            log.info("l ecole est mis a jour "+ ecole);
            return EcoleTransformer.entityToDto(ecole);
        }
        else{
            log.info("il n y a pas d ecole avec id "+ id);
            throw new NotFoundException("il n y a pas d ecole avec l id : "+ id);
        }
    }
    public void DeleteById(Long id){
        ecoleRepository.deleteById(id);
        log.info("l ecole avec id : "+ id + " est supprime");
    }

    public EcoleDto addDepartementToEcole(Long ecoleId,Long departementId){
        Ecole ecole = ecoleRepository.findById(ecoleId).get();
        log.info("l ecole avec l id : " + ecoleId + " est : "+ ecole);
        Departement departement = departementRepository.findById(departementId).get();
        log.info("le departement avec l id : " + departementId + " est : "+ departement);

        List<Departement> departementSet = null;
        departementSet = ecole.getDepartements();
        departementSet.add(departement);
        ecole.setDepartements(departementSet);

        ecoleRepository.save(ecole);
        log.info("l ecole est enregistre");

        return EcoleTransformer.entityToDto(ecole);
    }

    public List<EcoleDto> saveAllEcole(List<EcoleDto> ecoleDtos){
        List<Ecole> ecoles = EcoleTransformer.dtoToEntityList(ecoleDtos);
        ecoleRepository.saveAll(ecoles);
        return EcoleTransformer.entityToDtoList(ecoles);
    }
}
