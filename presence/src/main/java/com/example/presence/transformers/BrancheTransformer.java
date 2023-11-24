package com.example.presence.transformers;

import com.example.presence.entities.Branche;
import com.example.presence.entitiesDto.BrancheDto;

import javax.xml.transform.Transformer;
import java.util.*;
import java.util.stream.Collectors;

public class BrancheTransformer {
    public static BrancheDto entityToDto(Branche branche){
        BrancheDto brancheDto = new BrancheDto();
        brancheDto.setId(branche.getId());
        brancheDto.setNomBranche(branche.getNomBranche());
        brancheDto.setResponsableDeBranche(branche.getResponsableDeBranche());
        brancheDto.setDepartementDto(DepartementTransformer.entityToDto(branche.getDepartement()));
        return brancheDto;
    }
    public static Branche dtoToEntity(BrancheDto brancheDto){
        Branche branche = new Branche();
        branche.setId(brancheDto.getId());
        branche.setNomBranche(brancheDto.getNomBranche());
        branche.setResponsableDeBranche(brancheDto.getResponsableDeBranche());
        branche.setDepartement(DepartementTransformer.dtoToEntity(brancheDto.getDepartementDto()));

        return branche;
    }

    public static List<BrancheDto> entityToDtoList(List<Branche> branches){
        return branches.stream()
                .map(BrancheTransformer::entityToDto)
                .collect(Collectors.toList());
    }
}
