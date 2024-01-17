package com.example.presence.controllers;

import com.example.presence.entitiesDto.PresenceDto;
import com.example.presence.exceptions.NotFoundException;
import com.example.presence.services.IPresenceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/presence")
public class PresenceController {
    @Autowired
    private IPresenceService presenceService;
    @GetMapping("/all")
    public ResponseEntity<List<PresenceDto>> getAllPresence(){
        List<PresenceDto> presenceDtos = presenceService.getAllPresence();
        return new ResponseEntity<>(presenceDtos, HttpStatus.OK);
    }
    @GetMapping("/by-id/{id}")
    public ResponseEntity<PresenceDto> getPresenceById(@PathVariable Long id) throws NotFoundException {
        PresenceDto presenceDto = presenceService.getPresenceById(id);
        return new ResponseEntity<>(presenceDto,HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<PresenceDto> savePresence(@RequestBody @Valid PresenceDto presenceDto){
        PresenceDto createPresenceDto = presenceService.savePresence(presenceDto);
        return new ResponseEntity<>(createPresenceDto,HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<PresenceDto> updatePresence(@PathVariable Long id ,@RequestBody @Valid PresenceDto presenceDto) throws NotFoundException {
        PresenceDto updatePresenceDto = presenceService.updatePresence(id,presenceDto);
        return new ResponseEntity<>(updatePresenceDto,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePresence(@PathVariable Long id){
        presenceService.deletePresence(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
