package com.example.presence.controllers;

import com.example.presence.entitiesDto.DepartementDto;
import com.example.presence.exceptions.NotFoundException;
import com.example.presence.services.IDepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/by-id/{id}")
    public ResponseEntity<DepartementDto> getDepartementById(@PathVariable Long id) throws NotFoundException {
        DepartementDto departementDto = departementService.getDepartementById(id);
        return new ResponseEntity<>(departementDto, HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<DepartementDto> saveDepartement(@RequestBody DepartementDto departementDto){
        DepartementDto createDepartementDto = departementService.saveDepartement(departementDto);
        return new ResponseEntity<>(departementDto, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<DepartementDto> updateDepartement(@PathVariable Long id,@RequestBody DepartementDto departementDto) throws NotFoundException {
        DepartementDto updateDepartementDto = departementService.updateDepartement(id,departementDto);
        return new ResponseEntity<>(departementDto, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDepartement(@PathVariable Long id){
        departementService.deleteDepartement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
