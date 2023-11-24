package com.example.presence.controllers;

import com.example.presence.entitiesDto.BrancheDto;
import com.example.presence.exceptions.NotFoundException;
import com.example.presence.services.IBrancheService;
import com.example.presence.services.impl.BrancheService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/branche")
public class BrancheController {
    @Autowired
    private IBrancheService brancheService;
    @GetMapping("/all")
    public ResponseEntity<List<BrancheDto>> getAllBranche(){
        List<BrancheDto> brancheDtos = brancheService.getAllBranche();
        return new ResponseEntity<>(brancheDtos, HttpStatus.OK);
    }
    @GetMapping("/by-id/{id}")
    public ResponseEntity<BrancheDto> getBrancheById(@PathVariable Long id) throws NotFoundException {
        BrancheDto brancheDto = brancheService.getBrancheById(id);
        return new ResponseEntity<>(brancheDto, HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<BrancheDto> saveBranche(@RequestBody @Valid BrancheDto brancheDto){
        BrancheDto createBrancheDto = brancheService.saveBranche(brancheDto);
        return new ResponseEntity<>(createBrancheDto, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<BrancheDto> updateBranche(@PathVariable Long id, @RequestBody @Valid BrancheDto brancheDto) throws NotFoundException {
        BrancheDto updateBrancheDto = brancheService.updateBranche(id,brancheDto);
        return new ResponseEntity<>(updateBrancheDto, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBranche(@PathVariable Long id){
        brancheService.deleteBranche(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
