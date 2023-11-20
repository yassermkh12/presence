package com.example.presence.controllers;

import com.example.presence.entities.Etudiant;
import com.example.presence.entitiesDto.EtudiantDto;
import com.example.presence.services.EtudiantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    public ResponseEntity<Optional<EtudiantDto>> getEtudiantById(@PathVariable Long id){
        Optional<EtudiantDto> etudiantDto = etudiantService.getEtudiantById(id);
        if (etudiantDto != null) {
            return new ResponseEntity<>(etudiantDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/save")
    public ResponseEntity<EtudiantDto> saveEtudiant(@RequestBody EtudiantDto etudiantDto){
        EtudiantDto createEtudiantDto = etudiantService.saveEtudiant(etudiantDto);
        return new ResponseEntity<>(createEtudiantDto, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<EtudiantDto> updateEtudiant(@PathVariable Long id, @RequestBody EtudiantDto etudiantDto){
        EtudiantDto etudiantDtoUpdate = etudiantService.updateEtudiant(id,etudiantDto);
        if (etudiantDtoUpdate != null) {
            return new ResponseEntity<>(etudiantDtoUpdate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable Long id){
        etudiantService.deleteEtudiant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
