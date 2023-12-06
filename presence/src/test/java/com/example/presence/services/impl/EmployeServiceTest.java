package com.example.presence.services.impl;

import com.example.presence.PresenceApplication;
import com.example.presence.entities.Employe;
import com.example.presence.entitiesDto.EmployeDto;
import com.example.presence.exceptions.NotFoundException;
import com.example.presence.repositories.IEmployeRepository;
import com.example.presence.services.IEmployeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
//@RunWith(EmployeServiceTest.class)
@SpringBootTest
final
class EmployeServiceTest {
    @Mock
    private IEmployeRepository employeRepository;
    @InjectMocks
    private EmployeService employeService;
    private Employe employe;
    @BeforeEach
    public void setUp(){
        employe = new Employe();
        employe.setId(1L);
        employe.setNom("mokhtari");
        employe.setPrenom("yassir");
        employe.setPoste("pes");
        employe.setNumeroTelephone("0654421314");
        employe.setEmail("yassir@gmail.com");
    }
    @Test
    public void testGetAllEmploye(){
        when(employeRepository.findAll()).thenReturn(Arrays.asList(employe));

        List<EmployeDto> employeDtos = employeService.getAllEmploye();

        assertEquals(1,employeDtos.size());
        assertEquals(employe.getId(),employeDtos.get(0).getId());
        assertEquals(employe.getNom(),employeDtos.get(0).getNom());
        assertEquals(employe.getPrenom(),employeDtos.get(0).getPrenom());
        assertEquals(employe.getEmail(),employeDtos.get(0).getEmail());
        assertEquals(employe.getPoste(),employeDtos.get(0).getPoste());
        assertEquals(employe.getNumeroTelephone(),employeDtos.get(0).getNumeroTelephone());
    }
    @Test
    public void testGetById() throws NotFoundException {
        when(employeRepository.findById(1L))
                .thenReturn(Optional.of(employe));

        EmployeDto employeDto = employeService.getEmployeById(1L);

        assertEquals(employe.getId(),employeDto.getId());
        assertEquals(employe.getNom(),employeDto.getNom());
        assertEquals(employe.getPrenom(),employeDto.getPrenom());
        assertEquals(employe.getEmail(),employeDto.getEmail());
        assertEquals(employe.getPoste(),employeDto.getPoste());
        assertEquals(employe.getNumeroTelephone(),employeDto.getNumeroTelephone());
    }
}