package com.example.presence.transformers;

import com.example.presence.entities.Departement;
import com.example.presence.entities.Ecole;
import com.example.presence.entitiesDto.DepartementDto;
import com.example.presence.entitiesDto.EcoleDto;

import java.util.List;
import java.util.stream.Collectors;

public class DepartementTransformer {
    public static DepartementDto entityToDto(Departement departement){
        DepartementDto departementDto = new DepartementDto();
        departementDto.setId(departement.getId());
//        departementDto.setChefDepartement(departement.getChefDepartement());
        departementDto.setNomDepartement(departement.getNomDepartement());
        departementDto.setAnneCreation(departement.getAnneCreation());
        departementDto.setStatutDepartement(departement.getStatutDepartement());
        departementDto.setChefDepartement(EmployeTransformer.entityToDto(departement.getChefDepartement()));
        departementDto.setEcoleDto(EcoleTransformer.entityToDto(departement.getEcole()));

        return departementDto;
    }
    public static Departement dtoToEntity(DepartementDto departementDto){
        Departement departement = new Departement();
        departement.setId(departementDto.getId());
//        departement.setChefDepartement(departementDto.getChefDepartement());
        departement.setNomDepartement(departementDto.getNomDepartement());
        departement.setAnneCreation(departementDto.getAnneCreation());
        departement.setStatutDepartement(departementDto.getStatutDepartement());
        departement.setChefDepartement(EmployeTransformer.dtoToEntity(departementDto.getChefDepartement()));
        departement.setEcole(EcoleTransformer.dtoToEntity(departementDto.getEcoleDto()));

        return departement;
    }
    public static List<DepartementDto> entityToDtoList(List<Departement> departements){
        return departements.stream()
                .map(DepartementTransformer::entityToDto)
                .collect(Collectors.toList());
    }
}
