package com.example.presence.transformers;

import com.example.presence.entities.Employe;
import com.example.presence.entitiesDto.EmployeDto;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeTransformer {
    public static EmployeDto entityToDto(Employe employe){
        EmployeDto employeDto = new EmployeDto();
        employeDto.setId(employe.getId());
        employeDto.setNom(employe.getNom());
        employeDto.setPrenom(employe.getPrenom());
        employeDto.setEmail(employe.getEmail());
        employeDto.setNumeroTelephone(employe.getNumeroTelephone());
        employeDto.setPoste(employe.getPoste());

        return employeDto;
    }
    public static Employe dtoToEntity(EmployeDto employeDto){
        Employe employe = new Employe();
        employe.setId(employeDto.getId());
        employe.setEmail(employeDto.getEmail());
        employe.setNom(employeDto.getNom());
        employe.setPrenom(employeDto.getPrenom());
        employe.setPoste(employeDto.getPoste());
        employe.setNumeroTelephone(employeDto.getNumeroTelephone());

        return employe;
    }
    public static List<EmployeDto> entityToDtoList(List<Employe> employes){
        return employes.stream()
                .map(EmployeTransformer::entityToDto)
                .collect(Collectors.toList());
    }
    public static List<Employe> dtoToEntityList(List<EmployeDto> employeDtos){
        return employeDtos.stream()
                .map(EmployeTransformer::dtoToEntity)
                .collect(Collectors.toList());
    }
}
