package com.example.presence.controllers;

import com.example.presence.entities.Etudiant;
import com.example.presence.entitiesDto.EtudiantDto;
import com.example.presence.services.EtudiantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api")
public class EtudiantController {
    @Autowired
    private EtudiantService etudiantService;
    @GetMapping("/all")
    public ResponseEntity<List<EtudiantDto>> getAllEtudiant(){
        List<EtudiantDto> etudiantDtos = etudiantService.getAllEtudiant();
        return new ResponseEntity<>(etudiantDtos, HttpStatus.OK);
    }
}
