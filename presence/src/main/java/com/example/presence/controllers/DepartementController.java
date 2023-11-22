package com.example.presence.controllers;

import com.example.presence.entitiesDto.DepartementDto;
import com.example.presence.services.IDepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping("/api/departement")
public class DepartementController {
    @Autowired
    private IDepartementService departementService;
    @GetMapping("/all")
    public ResponseEntity<List<DepartementDto>> getAllDepartement(){
        List<DepartementDto> departementDtos = departementService.getAllDepartement();
        return new ResponseEntity<>(departementDtos, HttpStatus.OK);
    }

}
