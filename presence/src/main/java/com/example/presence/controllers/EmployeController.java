package com.example.presence.controllers;

import com.example.presence.entitiesDto.EmployeDto;
import com.example.presence.exceptions.NotFoundException;
import com.example.presence.services.IEmployeService;
import com.example.presence.services.impl.EmployeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/employe")
public class EmployeController {
    @Autowired
    private EmployeService employeService;
    @GetMapping("/all")
    public ResponseEntity<List<EmployeDto>> getAllEmploye(){
        List<EmployeDto> employeDtos = employeService.getAllEmploye();
        return new ResponseEntity<>(employeDtos, HttpStatus.OK);
    }
    @GetMapping("/by-id/{id}")
    public ResponseEntity<EmployeDto> getEmployeById(@PathVariable Long id) throws NotFoundException {
        EmployeDto employeDto = employeService.getEmployeById(id);
        return new ResponseEntity<>(employeDto,HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<EmployeDto> saveEmploye(@RequestBody @Valid EmployeDto employeDto){
        EmployeDto createEmployeDto = employeService.saveEmploye(employeDto);
        return new ResponseEntity<>(createEmployeDto, HttpStatus.CREATED);
    }
    @PostMapping("/saveAll")
    public ResponseEntity<List<EmployeDto>> saveAllEmploye(@RequestBody @Valid List<EmployeDto> employeDtos){
        List<EmployeDto> createEmployeDtos = employeService.saveAllEmploye(employeDtos);
        return new ResponseEntity<>(createEmployeDtos,HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeDto> updateEmploye(@PathVariable Long id, @RequestBody @Valid EmployeDto employeDto) throws NotFoundException {
        EmployeDto updateEmployeDto = employeService.updateEmploye(id,employeDto);
        return new ResponseEntity<>(updateEmployeDto, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmploye(@PathVariable Long id){
        employeService.deleteEmploye(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/async/all")
    public ResponseEntity<CompletableFuture<List<EmployeDto>>> getAllEmployeAsy() {
//        return employeService.getAllEmployeAs()
//                .thenApply(employeDtos -> new ResponseEntity<>(employeDtos, HttpStatus.OK));
        CompletableFuture<List<EmployeDto>> employeDto = employeService.getAllEmployeAs();
        return new ResponseEntity<>(employeDto,HttpStatus.OK);
    }
    @GetMapping("/async/by-id/{id}")
    public ResponseEntity<EmployeDto> getByIdEmployeAs(@PathVariable Long id) throws NotFoundException, ExecutionException, InterruptedException {
//        return employeService.getByIdEmployeAs(id)
//                .thenApply(employeDto -> new ResponseEntity<>(employeDto,HttpStatus.OK));
        CompletableFuture<EmployeDto> employeDto = employeService.getByIdEmployeAs(id);
        EmployeDto employeDto1 = employeDto.get();
        return new ResponseEntity<>(employeDto1,HttpStatus.OK);
    }

}
