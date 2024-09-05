package com.example.presence.security.controllers;

import com.example.presence.security.authentications.*;
import com.example.presence.security.services.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    @Autowired
    private IAuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
           @RequestBody ResgisterRequest resgisterRequest
    ){
            return ResponseEntity.ok(authenticationService.register(resgisterRequest));
    }

    @PostMapping("/register-employe")
    public ResponseEntity<AuthenticationResponse> registerEmploye(
            @RequestBody RegisterEmpoloyeRequest resgisterRequest
    ){
        return ResponseEntity.ok(authenticationService.registerEmploye(resgisterRequest));
    }

    @PostMapping("/register-etudiant")
    public ResponseEntity<AuthenticationResponse> registerEtudiant(
            @RequestBody RegisterEtudiantRequest resgisterRequest
    ){
        return ResponseEntity.ok(authenticationService.registerEtudiant(resgisterRequest));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest authenticationRequest
    ){
        return ResponseEntity.ok(authenticationService.auhenticate(authenticationRequest));
    }
}
