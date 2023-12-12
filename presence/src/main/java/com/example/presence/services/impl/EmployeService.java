package com.example.presence.services.impl;

import com.example.presence.entities.Employe;
import com.example.presence.entitiesDto.EmployeDto;
import com.example.presence.exceptions.NotFoundException;
import com.example.presence.repositories.IEmployeRepository;
import com.example.presence.services.IEmployeService;
import com.example.presence.transformers.EmployeTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.CompletableFuture;
@Slf4j
@Service
public class EmployeService {
    @Autowired
    private IEmployeRepository employeRepository;

    public List<EmployeDto> getAllEmploye(){
        List<Employe> employes = employeRepository.findAll();
        log.info("les employes dans la base de donnees sont : "+ employes);
        return EmployeTransformer.entityToDtoList(employes);
    }
    public EmployeDto getEmployeById(Long id) throws NotFoundException {
        Employe employe = employeRepository.findById(id).orElse(null);
        if(employe != null){
            log.info("l employe avec l id : "+ id + " existe " + employe);
            return EmployeTransformer.entityToDto(employe);
        }else {
            log.info("il n y a pas d employe avec id "+ id);
            throw new NotFoundException("il n y a pas d employe avec id "+ id);
        }
    }
    public EmployeDto saveEmploye(EmployeDto employeDto){
        Employe employe = EmployeTransformer.dtoToEntity(employeDto);
        employeRepository.save(employe);
        log.info("l employe est enregistres avec id : "+ employe.getId());
        return EmployeTransformer.entityToDto(employe);
    }
    public List<EmployeDto> saveAllEmploye(List<EmployeDto> employeDtos){
        List<Employe> employes = EmployeTransformer.dtoToEntityList(employeDtos);
        employeRepository.saveAll(employes);
        log.info("les employes sont enregistres");
        return EmployeTransformer.entityToDtoList(employes);
    }
    public EmployeDto updateEmploye(Long id, EmployeDto employeDto) throws NotFoundException {
        Employe employe = employeRepository.findById(id).orElse(null);
        if(employe != null){
            log.info("l employe avec l id : "+ id + " existe " + employe);
            employe.setNom(employeDto.getNom());
            employe.setPrenom(employeDto.getPrenom());
            employe.setPoste(employeDto.getPoste());
            employe.setEmail(employeDto.getEmail());
            employe.setNumeroTelephone(employeDto.getNumeroTelephone());


            log.info("l employe est mis a jour "+ employe);
            return EmployeTransformer.entityToDto(employe);
        }else {
            log.info("il n y a pas d employe avec id "+ id);
            throw new NotFoundException("il n y a pas d employe avec id "+ id);
        }
    }
    public void deleteEmploye(Long id){
        employeRepository.deleteById(id);
        log.info("l employe avec id : "+ id + " est supprime");
    }

    @Async
    public CompletableFuture<List<EmployeDto>> getAllEmployeAs(){
        List<Employe> employes = employeRepository.findAll();
        List<EmployeDto> employeDtos = EmployeTransformer.entityToDtoList(employes);
        return CompletableFuture.completedFuture(employeDtos);
    }
    @Async
    public CompletableFuture<EmployeDto> getByIdEmployeAs(Long id) throws NotFoundException {
        Employe employe = employeRepository.findById(id).orElse(null);
        if(employe != null){
            log.info("le thread qui fonctionne est : "+ Thread.currentThread().getName());
            return CompletableFuture.completedFuture(EmployeTransformer.entityToDto(employe));
        }else {
            throw new NotFoundException("il n y a pas d employe avec id "+ id + " (async)");
        }
    }
}
