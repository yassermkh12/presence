package com.example.presence.services.impl;

import com.example.presence.entities.Departement;
import com.example.presence.entities.Ecole;
import com.example.presence.entitiesDto.DepartementDto;
import com.example.presence.exceptions.NotFoundException;
import com.example.presence.jms.MessageSender;
import com.example.presence.repositories.IDepartementRepository;
import com.example.presence.repositories.IEcoleRepository;
import com.example.presence.services.IDepartementService;
import com.example.presence.services.IEcoleService;
import com.example.presence.transformers.DepartementTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class DepartementService implements IDepartementService {
    @Autowired
    private IDepartementRepository departementRepository;
    @Autowired
    private MessageSender messageSender;
    public List<DepartementDto> getAllDepartement(){
        List<Departement> departements = departementRepository.findAll();
        return DepartementTransformer.entityToDtoList(departements);
    }
    public DepartementDto getDepartementById(Long id) throws NotFoundException {
        Departement departement = departementRepository.findById(id).orElse(null);
        if (departement!=null){
        return DepartementTransformer.entityToDto(departement);
        }else{
            throw new NotFoundException("il n y a pas de departement avec l id: "+ id);
        }
    }
    public DepartementDto saveDepartement(DepartementDto departementDto){
        Departement departement = DepartementTransformer.dtoToEntity(departementDto);
        departementRepository.save(departement);
        messageSender.sendMsg("YM-Queues","la branche est creer : "+ departement.toString());
        return DepartementTransformer.entityToDto(departement);
    }
    public DepartementDto updateDepartement(Long id, DepartementDto departementDtoUpdate) throws NotFoundException {
        Departement departementUpdate = departementRepository.findById(id).orElse(null);

        if(departementUpdate!=null) {
            departementUpdate.setChefDepartement(departementDtoUpdate.getChefDepartement());
            departementUpdate.setNomDepartement(departementDtoUpdate.getNomDepartement());
            departementUpdate.setStatutDepartement(departementDtoUpdate.getStatutDepartement());
            departementUpdate.setAnneCreation(departementDtoUpdate.getAnneCreation());

            departementRepository.save(departementUpdate);
            return DepartementTransformer.entityToDto(departementUpdate);
        }else {
            throw new NotFoundException("il n y a pas de departement avec l id: "+ id);
        }
    }
    public void deleteDepartement(Long id){
        departementRepository.deleteById(id);
    }

}
