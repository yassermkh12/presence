package com.example.presence.services.impl;

import com.example.presence.entities.Employe;
import com.example.presence.entitiesDto.EmployeDto;
import com.example.presence.exceptions.NotFoundException;
import com.example.presence.jms.MessageSender;
import com.example.presence.repositories.IEmployeRepository;
import com.example.presence.services.IEmployeService;
import com.example.presence.transformers.EmployeTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Slf4j
@Service
public class EmployeService implements IEmployeService {
    @Autowired
    private IEmployeRepository employeRepository;
    @Autowired
    private MessageSender messageSender;

    public List<EmployeDto> getAllEmploye(){
        List<Employe> employes = employeRepository.findAll();
        return EmployeTransformer.entityToDtoList(employes);
    }
    public EmployeDto getEmployeById(Long id) throws NotFoundException {
        Employe employe = employeRepository.findById(id).orElse(null);
        if(employe != null){
            messageSender.sendMsg("Queues-1",employe.toString());
            return EmployeTransformer.entityToDto(employe);
        }else {
            throw new NotFoundException("il n y a pas d employe avec id "+ id);
        }
    }
    public EmployeDto saveEmploye(EmployeDto employeDto){
        Employe employe = EmployeTransformer.dtoToEntity(employeDto);
        employeRepository.save(employe);
        return EmployeTransformer.entityToDto(employe);
    }
    public List<EmployeDto> saveAllEmploye(List<EmployeDto> employeDtos){
        List<Employe> employes = EmployeTransformer.dtoToEntityList(employeDtos);
        employeRepository.saveAll(employes);
        return EmployeTransformer.entityToDtoList(employes);
    }
    public EmployeDto updateEmploye(Long id, EmployeDto employeDto) throws NotFoundException {
        Employe employe = employeRepository.findById(id).orElse(null);
        if(employe != null){
            employe.setNom(employeDto.getNom());
            employe.setPrenom(employeDto.getPrenom());
            employe.setPoste(employeDto.getPoste());
            employe.setEmail(employeDto.getEmail());
            employe.setNumeroTelephone(employeDto.getNumeroTelephone());

            return EmployeTransformer.entityToDto(employe);
        }else {
            throw new NotFoundException("il n y a pas d employe avec id "+ id);
        }
    }
    public void deleteEmploye(Long id){
        employeRepository.deleteById(id);
    }
}
