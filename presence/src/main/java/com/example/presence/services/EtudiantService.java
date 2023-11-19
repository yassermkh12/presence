package com.example.presence.services;

import com.example.presence.entitiesDto.EtudiantDto;
import com.example.presence.repositories.IEtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public class EtudiantService {
    @Autowired
    private IEtudiantRepository etudiantRepository;
    //getAll

}
