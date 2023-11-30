package com.example.presence.services.impl;

import com.example.presence.entities.Ecole;
import com.example.presence.entities.Etudiant;
import com.example.presence.entitiesDto.EtudiantDto;
import com.example.presence.exceptions.NotFoundException;
import com.example.presence.repositories.IEcoleRepository;
import com.example.presence.repositories.IEtudiantRepository;
import com.example.presence.services.IEcoleService;
import com.example.presence.services.IEtudiantService;
import com.example.presence.transformers.EcoleTransformer;
import com.example.presence.transformers.EtudiantTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EtudiantService implements IEtudiantService {
    @Autowired
    private IEtudiantRepository etudiantRepository;

    @Autowired
    private IEcoleRepository ecoleRepository;
    public List<EtudiantDto> getAllEtudiant() throws NotFoundException {
        List<Etudiant> etudiants = etudiantRepository.findAll();
        if (etudiants != null) {
            return EtudiantTransformer.entityToDtoList(etudiants);
        }else {
            throw new NotFoundException("la base de donnee est encore vide");
        }
    }
    public Optional<EtudiantDto> getEtudiantById(Long id) throws NotFoundException {
        Optional<Etudiant> etudiant = etudiantRepository.findById(id);
        if(etudiant.isPresent()){
            return etudiant.map(EtudiantTransformer::entityToDto);
        }else{
            throw new NotFoundException("il n y a pas d etudiant avec id "+ id);
        }
    }
    public EtudiantDto saveEtudiant(EtudiantDto etudiantDto){
            Etudiant etudiant = EtudiantTransformer.dtoToEntity(etudiantDto);
            etudiantRepository.save(etudiant);
            return EtudiantTransformer.entityToDto(etudiant);
    }
    public EtudiantDto updateEtudiant(Long id, EtudiantDto etudiantDtoUpdate) throws NotFoundException {
        Optional<Etudiant> etudiantOptional = etudiantRepository.findById(id);

        if(etudiantOptional.isPresent()){
            Etudiant etudiant = etudiantOptional.get();
            etudiant.setNom(etudiantDtoUpdate.getNom());
            etudiant.setPrenom(etudiantDtoUpdate.getPrenom());
            etudiant.setCin(etudiantDtoUpdate.getCin());
            etudiant.setEmail(etudiantDtoUpdate.getEmail());
            etudiant.setPassword(etudiantDtoUpdate.getPassword());
            etudiant.setEcole(EcoleTransformer.dtoToEntity(etudiantDtoUpdate.getEcoleDto()));

            etudiantRepository.save(etudiant);
            return EtudiantTransformer.entityToDto(etudiant);
        }else {
            throw new NotFoundException("il n y a pas d etudiant avec id "+ id);
        }
    }
    public void deleteEtudiant(Long id){
        etudiantRepository.deleteById(id);
    }
}
