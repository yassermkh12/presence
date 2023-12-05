package com.example.presence.services.impl;

import com.example.presence.entitiesDto.EmployeDto;
import com.example.presence.repositories.IEmployeRepository;
import com.example.presence.services.IEmployeService;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeServiceTest {
    @Mock
    private IEmployeRepository employeRepository;
    @InjectMocks
    private IEmployeService employeService;
    @Test
    public void testSaveEmploye(){
        EmployeDto employeDto = new EmployeDto();
        employeDto.setNom("mokhtari");
        employeDto.setPrenom("yasser");
        employeDto.setEmail("yasser.mokhtari@gmail.com");
        employeDto.setNumeroTelephone("0654421314");
        employeDto.setPoste("java");

    }
}