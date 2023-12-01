package com.example.presence.controllers;

import com.example.presence.entitiesDto.EtudiantDto;
import com.example.presence.exceptions.NotFoundException;
import com.example.presence.services.IEtudiantService;
import com.example.presence.services.impl.EtudiantService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/etudiant")
public class EtudiantController {
    @Autowired
    private IEtudiantService etudiantService;
    @GetMapping("/all")
    public ResponseEntity<List<EtudiantDto>> getAllEtudiant() throws NotFoundException {
        List<EtudiantDto> etudiantDtos = etudiantService.getAllEtudiant();
        return new ResponseEntity<>(etudiantDtos, HttpStatus.OK);
    }
    @GetMapping("/by-id/{id}")
    public ResponseEntity<Optional<EtudiantDto>> getEtudiantById(@PathVariable Long id) throws NotFoundException {
        Optional<EtudiantDto> etudiantDto = etudiantService.getEtudiantById(id);
        return new ResponseEntity<>(etudiantDto, HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<EtudiantDto> saveEtudiant(@RequestBody @Valid EtudiantDto etudiantDto){
        EtudiantDto createEtudiantDto = etudiantService.saveEtudiant(etudiantDto);
        return new ResponseEntity<>(createEtudiantDto, HttpStatus.CREATED);
    }
    @PostMapping("/saveAll")
    public ResponseEntity<List<EtudiantDto>> saveAllEtudiant(@RequestBody @Valid List<EtudiantDto> etudiantDtos){
        List<EtudiantDto> createEtudiantDtos = etudiantService.saveAllEtudiant(etudiantDtos);
        return new ResponseEntity<>(createEtudiantDtos,HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<EtudiantDto> updateEtudiant(@PathVariable Long id, @RequestBody @Valid EtudiantDto etudiantDto) throws NotFoundException {
        EtudiantDto etudiantDtoUpdate = etudiantService.updateEtudiant(id,etudiantDto);
        return new ResponseEntity<>(etudiantDtoUpdate, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable Long id){
        etudiantService.deleteEtudiant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
