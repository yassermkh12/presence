package com.example.presence.controllers;

import java.util.*;

import com.example.presence.entities.Ecole;
import com.example.presence.entitiesDto.EcoleDto;
import com.example.presence.exceptions.NotFoundException;
import com.example.presence.services.IEcoleService;
import com.example.presence.services.impl.EcoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/ecole")
public class EcoleController {
    @Autowired
    private EcoleService ecoleService;

    @GetMapping("/all")
    public ResponseEntity<List<EcoleDto>> getAllEcole(){
        List<EcoleDto> ecoleDtos = ecoleService.getAllEcole();
        return new ResponseEntity<>(ecoleDtos,HttpStatus.OK);
    }
    @GetMapping("/by-id/{id}")
    public ResponseEntity<Optional<EcoleDto>> getEcoleById(@PathVariable Long id) throws NotFoundException {
        Optional<EcoleDto> ecoleDto = ecoleService.getEcoleById(id);
        return new ResponseEntity<>(ecoleDto, HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<EcoleDto> saveEcole(@RequestBody @Valid EcoleDto ecoleDto){
        EcoleDto createEcoleDto = ecoleService.saveEcole(ecoleDto);
        return new ResponseEntity<>(createEcoleDto, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<EcoleDto> updateEcole(@PathVariable Long id, @RequestBody @Valid EcoleDto ecoleDtoUpdate) throws NotFoundException {
        EcoleDto ecoleDto = ecoleService.updateEcole(id,ecoleDtoUpdate);
        return new ResponseEntity<>(ecoleDto,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEcoleById(@PathVariable Long id){
        ecoleService.DeleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
//    @PutMapping("{ecoleId}/departement/{departementId}")
//    public ResponseEntity<EcoleDto> addDepartementToEcole(@PathVariable Long ecoleId, @PathVariable Long departementId){
//        EcoleDto ecoleDto = ecoleService.addDepartementToEcole(ecoleId, departementId);
//        return new ResponseEntity<>(ecoleDto,HttpStatus.OK);
//    }
    @PostMapping("/saveAll")
    public ResponseEntity<List<EcoleDto>> saveAllEcole(@RequestBody List<EcoleDto> ecoleDtos){
        List<EcoleDto> ecoleDtos1 = ecoleService.saveAllEcole(ecoleDtos);
        return new ResponseEntity<>(ecoleDtos1,HttpStatus.OK);
    }
}
