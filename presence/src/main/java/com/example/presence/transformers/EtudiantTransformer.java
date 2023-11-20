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

        return etudiant;
    }

    public static List<EtudiantDto> entityToDtoList(List<Etudiant> etudiants){
        return etudiants.stream()
                .map(EtudiantTransformer::entityToDto)
                .collect(Collectors.toList());
    }
}
