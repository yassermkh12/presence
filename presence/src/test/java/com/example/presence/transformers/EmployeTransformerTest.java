package com.example.presence.transformers;

import com.example.presence.PresenceApplication;
import com.example.presence.entities.Employe;
import com.example.presence.entitiesDto.EmployeDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
//@RunWith(PresenceTransformer.class)
@SpringBootTest
public class EmployeTransformerTest {
    @Test
    public void testEntityToDto(){
        //instencier l objet
        Employe employe = new Employe();
        //remplir l objet
        employe.setId(1L);
        employe.setNom("mokhtari");
        employe.setPrenom("yassir");
        employe.setPoste("pes");
        employe.setNumeroTelephone("0654421314");
        employe.setEmail("yassir@gmail.com");
//        transformer l entite en dto
        EmployeDto employeDto = EmployeTransformer.entityToDto(employe);
//        verification des assertion
        assertEquals(employe.getId(),employeDto.getId());
        assertEquals(employe.getNom(),employeDto.getNom());
        assertEquals(employe.getPrenom(),employeDto.getPrenom());
        assertEquals(employe.getPoste(),employeDto.getPoste());
        assertEquals(employe.getNumeroTelephone(),employeDto.getNumeroTelephone());
        assertEquals(employe.getEmail(),employeDto.getEmail());
    }
    @Test
    public void testDtoToEntity(){
        EmployeDto employeDto = new EmployeDto();

        employeDto.setId(1L);
        employeDto.setPoste("pes");
        employeDto.setNom("mokhtari");
        employeDto.setPrenom("yassir");
        employeDto.setEmail("yassir@gmail.com");
        employeDto.setNumeroTelephone("0654421314");

        Employe employe = EmployeTransformer.dtoToEntity(employeDto);

        assertEquals(employeDto.getId(),employe.getId());
        assertEquals(employeDto.getNom(),employe.getNom());
        assertEquals(employeDto.getPrenom(),employe.getPrenom());
        assertEquals(employeDto.getPoste(),employe.getPoste());
        assertEquals(employeDto.getEmail(),employe.getEmail());
        assertEquals(employeDto.getNumeroTelephone(),employe.getNumeroTelephone());
    }
    @Test
    public void testEntityToDtoList(){
        Employe employe1 = new Employe();
        Employe employe2 = new Employe();

        employe1.setId(1L);
        employe1.setNom("mokhtari");
        employe1.setPrenom("yassir");
        employe1.setPoste("pes");
        employe1.setNumeroTelephone("0654421314");
        employe1.setEmail("yassir@gmail.com");

        employe2.setId(2L);
        employe2.setNom("mokhtari");
        employe2.setPrenom("yassir");
        employe2.setPoste("pes");
        employe2.setNumeroTelephone("0654421314");
        employe2.setEmail("yassir@gmail.com");

        List<Employe> employes = Arrays.asList(
                employe1,employe2
        );

        List<EmployeDto> employeDtos = EmployeTransformer.entityToDtoList(employes);

        assertEquals(employes.size(),employeDtos.size());

        for(int i=0;i<employes.size();i++){
            Employe employe = employes.get(i);
            EmployeDto employeDto = employeDtos.get(i);

            assertEquals(employe.getId(),employeDto.getId());
            assertEquals(employe.getNom(),employeDto.getNom());
            assertEquals(employe.getPrenom(),employeDto.getPrenom());
            assertEquals(employe.getPoste(),employeDto.getPoste());
            assertEquals(employe.getNumeroTelephone(),employeDto.getNumeroTelephone());
            assertEquals(employe.getEmail(),employeDto.getEmail());
        }
    }
    @Test
    public void testDtoToEntityList() {
        EmployeDto employeDto1 = new EmployeDto();

        employeDto1.setId(1L);
        employeDto1.setPoste("pes");
        employeDto1.setNom("mokhtari");
        employeDto1.setPrenom("yassir");
        employeDto1.setEmail("yassir@gmail.com");
        employeDto1.setNumeroTelephone("0654421314");

        EmployeDto employeDto2 = new EmployeDto();

        employeDto2.setId(1L);
        employeDto2.setPoste("pes");
        employeDto2.setNom("mokhtari");
        employeDto2.setPrenom("yassir");
        employeDto2.setEmail("yassir@gmail.com");
        employeDto2.setNumeroTelephone("0654421314");

        List<EmployeDto> employeDtos = Arrays.asList(
                employeDto1, employeDto2
        );

        List<Employe> employes = EmployeTransformer.dtoToEntityList(employeDtos);

        assertEquals(employes.size(), employeDtos.size());

        for (int i = 0; i < employes.size(); i++) {
            Employe employe = employes.get(i);
            EmployeDto employeDto = employeDtos.get(i);

            assertEquals(employe.getId(), employeDto.getId());
            assertEquals(employe.getNom(), employeDto.getNom());
            assertEquals(employe.getPrenom(), employeDto.getPrenom());
            assertEquals(employe.getPoste(), employeDto.getPoste());
            assertEquals(employe.getNumeroTelephone(), employeDto.getNumeroTelephone());
            assertEquals(employe.getEmail(), employeDto.getEmail());
        }
    }
}