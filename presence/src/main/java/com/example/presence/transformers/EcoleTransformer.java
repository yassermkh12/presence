package com.example.presence.transformers;

import com.example.presence.entities.Ecole;
import com.example.presence.entitiesDto.EcoleDto;
import java.util.*;
import java.util.stream.Collectors;

public class EcoleTransformer {
    public static EcoleDto entityToDto(Ecole ecole){
        EcoleDto ecoleDto = new EcoleDto();
        ecoleDto.setId(ecole.getId());
        ecoleDto.setAdresseEcole(ecole.getAdresseEcole());
        ecoleDto.setNomDirecteur(ecole.getNomDirecteur());
        ecoleDto.setDateDeFondation(ecole.getDateDeFondation());
        ecoleDto.setTypeEcole(ecole.getTypeEcole());

        return ecoleDto;
    }

    public static Ecole dtoToEntity(EcoleDto ecoleDto){
        Ecole ecole = new Ecole();
        ecole.setId(ecoleDto.getId());
        ecole.setAdresseEcole(ecoleDto.getAdresseEcole());
        ecole.setNomDirecteur(ecoleDto.getNomDirecteur());
        ecole.setDateDeFondation(ecoleDto.getDateDeFondation());
        ecole.setTypeEcole(ecoleDto.getTypeEcole());

        return ecole;
    }

    public static List<EcoleDto> entityToDtoList(List<Ecole> ecoles){
        return ecoles.stream()
                .map(EcoleTransformer::entityToDto)
                .collect(Collectors.toList());
    }
}
