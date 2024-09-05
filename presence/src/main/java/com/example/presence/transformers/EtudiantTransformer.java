package com.example.presence.transformers;

import com.example.presence.entities.Etudiant;
import com.example.presence.entitiesDto.EtudiantDto;
import com.example.presence.security.transformers.UserTransformer;

import java.util.List;
import java.util.stream.Collectors;

public class EtudiantTransformer {
    public static EtudiantDto entityToDto(Etudiant etudiant){
        EtudiantDto etudiantDto = new EtudiantDto();
        etudiantDto.setId(etudiant.getId());
        etudiantDto.setNom(etudiant.getNom());
        etudiantDto.setPrenom(etudiant.getPrenom());
        etudiantDto.setCin(etudiant.getCin());
        etudiantDto.setEmail(etudiant.getEmail());
        etudiantDto.setCne(etudiant.getCne());
        etudiantDto.setNumeroTelephone(etudiant.getNumeroTelephone());
        etudiantDto.setUserName(etudiant.getUsername());
        etudiantDto.setEcoleDto(EcoleTransformer.entityToDto(etudiant.getEcole()));
//        etudiantDto.setUserDto(UserTransformer.entityToDto(etudiant.getEtudiantUser()));

        return etudiantDto;
    }

    public static Etudiant dtoToEntity(EtudiantDto etudiantDto){
        Etudiant etudiant = new Etudiant();
        etudiant.setId(etudiantDto.getId());
        etudiant.setNom(etudiantDto.getNom());
        etudiant.setPrenom(etudiantDto.getPrenom());
        etudiant.setCin(etudiantDto.getCin());
        etudiant.setEmail(etudiantDto.getEmail());
        etudiant.setCne(etudiantDto.getCne());
        etudiant.setNumeroTelephone(etudiantDto.getNumeroTelephone());
        etudiant.setUserName(etudiantDto.getUserName());
        etudiant.setEcole(EcoleTransformer.dtoToEntity(etudiantDto.getEcoleDto()));
//        etudiant.setEtudiantUser(UserTransformer.dtoToEntity(etudiantDto.getUserDto()));

        return etudiant;
    }

    public static List<EtudiantDto> entityToDtoList(List<Etudiant> etudiants){
        return etudiants.stream()
                .map(EtudiantTransformer::entityToDto)
                .collect(Collectors.toList());
    }
}
