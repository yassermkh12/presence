package com.example.presence.transformers;

import com.example.presence.entities.Etudiant;
import com.example.presence.entitiesDto.EtudiantDto;

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
        etudiantDto.setPassword(etudiant.getPassword());
        etudiantDto.setEcoleDto(EcoleTransformer.entityToDto(etudiant.getEcole()));

        return etudiantDto;
    }

    public static Etudiant dtoToEntity(EtudiantDto etudiantDto){
        Etudiant etudiant = new Etudiant();
        etudiant.setId(etudiantDto.getId());
        etudiant.setNom(etudiantDto.getNom());
        etudiant.setPrenom(etudiantDto.getPrenom());
        etudiant.setCin(etudiantDto.getCin());
        etudiant.setEmail(etudiantDto.getEmail());
        etudiant.setPassword(etudiantDto.getPassword());
        etudiant.setEcole(EcoleTransformer.dtoToEntity(etudiantDto.getEcoleDto()));
        return etudiant;
    }

    public static List<EtudiantDto> entityToDtoList(List<Etudiant> etudiants){
        return etudiants.stream()
                .map(EtudiantTransformer::entityToDto)
                .collect(Collectors.toList());
    }
    public static List<Etudiant> dtoToEntityList(List<EtudiantDto> etudiantDtos){
        return etudiantDtos.stream()
                .map(EtudiantTransformer::dtoToEntity)
                .collect(Collectors.toList());
    }
}
