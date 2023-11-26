package com.example.presence.controllers;

import com.example.presence.entitiesDto.ModuleDto;
import com.example.presence.exceptions.NotFoundException;
import com.example.presence.services.IModuleService;
import com.example.presence.services.impl.ModuleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/api/module")
public class ModuleController {
    @Autowired
    private IModuleService moduleService;
    @GetMapping("/all")
    public ResponseEntity<List<ModuleDto>> getAllModule(){
        List<ModuleDto> moduleDtos = moduleService.getAllModule();
        return new ResponseEntity<>(moduleDtos, HttpStatus.OK);
    }
    @GetMapping("/by-id/{id}")
    public ResponseEntity<ModuleDto> getModuleById(@PathVariable Long id) throws NotFoundException {
        ModuleDto moduleDto = moduleService.getModuleById(id);
        return new ResponseEntity<>(moduleDto,HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<ModuleDto> saveModule(@RequestBody @Valid ModuleDto moduleDto){
        ModuleDto createModuleDto = moduleService.saveModule(moduleDto);
        return new ResponseEntity<>(createModuleDto,HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ModuleDto> updateModule(@PathVariable Long id, @RequestBody @Valid ModuleDto moduleDto) throws NotFoundException {
        ModuleDto updateModuleDto = moduleService.updateModule(id,moduleDto);
        return new ResponseEntity<>(updateModuleDto,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable Long id){
        moduleService.deleteModule(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
