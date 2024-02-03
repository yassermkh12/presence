package com.example.presence.controllers;

import com.example.presence.entitiesDto.SeanceDto;
import com.example.presence.exceptions.NotFoundException;
import com.example.presence.services.ISeanceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/seance")
public class SeanceController {
    @Autowired
    private ISeanceService seanceService;
    @GetMapping("/all")
    public ResponseEntity<List<SeanceDto>> getAllSeance(){
        List<SeanceDto> seanceDtos = seanceService.getAllSeance();
        return new ResponseEntity<>(seanceDtos, HttpStatus.OK);
    }
    @GetMapping("/by-id/{id}")
    public ResponseEntity<SeanceDto> getSeanceById(@PathVariable Long id) throws NotFoundException {
        SeanceDto seanceDto = seanceService.getSeanceById(id);
        return new ResponseEntity<>(seanceDto,HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<SeanceDto> saveSeance(@RequestBody @Valid SeanceDto seanceDto){
        SeanceDto createSeanceDto = seanceService.saveSeance(seanceDto);
        return new ResponseEntity<>(createSeanceDto,HttpStatus.CREATED);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<SeanceDto> updateSeance(@PathVariable Long id, @RequestBody @Valid SeanceDto seanceDto) throws NotFoundException {
        SeanceDto updateSeanceDto = seanceService.updateSeance(id,seanceDto);
        return new ResponseEntity<>(updateSeanceDto,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSeance(@PathVariable Long id){
        seanceService.deleteSeance(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
