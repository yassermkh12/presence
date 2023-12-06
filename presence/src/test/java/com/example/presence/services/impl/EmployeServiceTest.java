package com.example.presence.services.impl;

import com.example.presence.entities.Employe;
import com.example.presence.entitiesDto.EmployeDto;
import com.example.presence.repositories.IEmployeRepository;
import com.example.presence.services.IEmployeService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class EmployeServiceTest {
    @Mock
    private IEmployeRepository employeRepository;
    @InjectMocks
    private IEmployeService employeService;

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

    }
}