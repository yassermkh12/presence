package com.example.presence.services;

import com.example.presence.entities.Etudiant;
import com.example.presence.entitiesDto.EtudiantDto;
import com.example.presence.repositories.IEtudiantRepository;
import com.example.presence.transformers.EtudiantTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EtudiantService {
    @Autowired
    private IEtudiantRepository etudiantRepository;
    //getAll
    public List<EtudiantDto> getAllEtudiant(){
        List<Etudiant> etudiants = etudiantRepository.findAll();
        return EtudiantTransformer.entityToDtoList(etudiants);
    }
    public Optional<EtudiantDto> getEtudiantById(Long id){
        Optional<Etudiant> etudiant = etudiantRepository.findById(id);
        return Optional.ofNullable(etudiant.map(EtudiantTransformer::entityToDto).orElse(null));
    }
    public EtudiantDto saveEtudiant(EtudiantDto etudiantDto) {
            Etudiant etudiant = EtudiantTransformer.dtoToEntity(etudiantDto);
            etudiantRepository.save(etudiant);
            return EtudiantTransformer.entityToDto(etudiant);
    }
    public EtudiantDto updateEtudiant(Long id, EtudiantDto etudiantDtoUpdate){
        Optional<Etudiant> etudiantOptional = etudiantRepository.findById(id);

        if(etudiantOptional.isPresent()){
            Etudiant etudiant = etudiantOptional.get();
            etudiant.setNom(etudiantDtoUpdate.getNom());
            etudiant.setPrenom(etudiantDtoUpdate.getPrenom());
            etudiant.setCin(etudiantDtoUpdate.getCin());
            etudiant.setEmail(etudiantDtoUpdate.getEmail());
            etudiant.setPassword(etudiantDtoUpdate.getPassword());

            etudiantRepository.save(etudiant);
            return EtudiantTransformer.entityToDto(etudiant);
        }else {
            return null;
        }
    }
    public void deleteEtudiant(Long id){
        etudiantRepository.deleteById(id);
    }
}
