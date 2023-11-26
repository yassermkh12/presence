package com.example.presence.controllers;

import com.example.presence.entitiesDto.SeanceDto;
import com.example.presence.services.ISeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

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
}
