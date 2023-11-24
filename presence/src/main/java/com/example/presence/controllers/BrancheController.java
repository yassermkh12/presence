package com.example.presence.controllers;

import com.example.presence.entitiesDto.BrancheDto;
import com.example.presence.services.IBrancheService;
import com.example.presence.services.impl.BrancheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
