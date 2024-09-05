package com.example.presence.security.services.impl;

import com.example.presence.entities.Employe;
import com.example.presence.entities.Etudiant;
import com.example.presence.repositories.IEtudiantRepository;
import com.example.presence.security.authentications.*;
import com.example.presence.security.entities.Role;
import com.example.presence.security.entities.User;
import com.example.presence.security.exceptions.GlobalException;
import com.example.presence.security.repositories.IRoleRepository;
import com.example.presence.security.repositories.IUserRepository;
import com.example.presence.security.services.IAuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class AuthenticationService implements IAuthenticationService {

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private IEtudiantRepository etudiantRepository;

    @Transactional
    public AuthenticationResponse register(ResgisterRequest resgisterRequest) throws GlobalException {

        if (userRepository.findByUserName(resgisterRequest.getUsername()) != null) {
            log.info("username deja utiliser");
            throw new GlobalException("username deja utiliser");
        }
        if (userRepository.findByEmail(resgisterRequest.getEmail()).isPresent()){
            throw new GlobalException("l email est deja utiliser");
        }
        log.info("*** le processus de REGISTER commence ***");
        User user = new User();
        Role role = roleRepository.findById(2L).orElse(null);

        user.setUserName(resgisterRequest.getUsername());
        user.setPassword(passwordEncoder.encode(resgisterRequest.getPassword()));
        user.setEmail(resgisterRequest.getEmail());
        user.getRoles().add(role);

        log.info("l utilisateur depuis user : "+ user);
        log.info("l utilisateur depuis registerRequest : "+ resgisterRequest);
        userRepository.save(user);

        String jwtToken =  jwtService.generateJwtToken(user);
        String jwtRefrecheToken = jwtService.generateRefrechTokenFromToken(jwtToken);
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setToken(jwtToken);
        authenticationResponse.setRefrechToken(jwtRefrecheToken);

        log.info("authentication reponse est : "+ authenticationResponse);

        return authenticationResponse;

    }

    @Transactional
    public AuthenticationResponse registerEmploye(RegisterEmpoloyeRequest resgisterRequest) throws GlobalException {

        if (userRepository.findByUserName(resgisterRequest.getUsername()) != null) {
            log.info("username deja utiliser");
            throw new GlobalException("username deja utilise");
        }
        if (userRepository.findByEmail(resgisterRequest.getEmail()).isPresent()){
            throw new GlobalException("l email est deja utilise");
        }
        if(userRepository.findByCin(resgisterRequest.getCin()).isPresent()){
            throw new GlobalException("la carte d identite national est deja utilise");
        }
        if (userRepository.findByNumeroTelephone(resgisterRequest.getNumeroTelephone()).isPresent()){
            throw new GlobalException("le numero de telephone est deja utilise");
        }
        log.info("*** le processus de REGISTER commence ***");
        Employe employe = new Employe();
        Role userRole = roleRepository.findByName("USER").orElse(null);
        Role employeRole = roleRepository.findByName("EMPLOYE").orElse(null);

        employe.setUserName(resgisterRequest.getUsername());
        employe.setPrenom(resgisterRequest.getPrenom());
        employe.setNom(resgisterRequest.getNom());
        employe.setNumeroTelephone(resgisterRequest.getNumeroTelephone());
        employe.setCin(resgisterRequest.getCin());
        employe.setPoste(resgisterRequest.getPoste());
        employe.setPassword(passwordEncoder.encode(resgisterRequest.getPassword()));
        employe.setEmail(resgisterRequest.getEmail());
        employe.getRoles().add(userRole);
        employe.getRoles().add(employeRole);

        log.info("l utilisateur depuis user : "+ employe);
        log.info("l utilisateur depuis registerRequest : "+ resgisterRequest);
        userRepository.save(employe);

        String jwtToken =  jwtService.generateJwtToken(employe);
        String jwtRefrecheToken = jwtService.generateRefrechTokenFromToken(jwtToken);
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setToken(jwtToken);
        authenticationResponse.setRefrechToken(jwtRefrecheToken);

        log.info("authentication reponse est : "+ authenticationResponse);

        return authenticationResponse;

    }

    @Transactional
    public AuthenticationResponse registerEtudiant(RegisterEtudiantRequest resgisterRequest) throws GlobalException {

        if (userRepository.findByUserName(resgisterRequest.getUsername()) != null) {
            log.info("username deja utiliser");
            throw new GlobalException("username deja utiliser");
        }
        if (userRepository.findByEmail(resgisterRequest.getEmail()).isPresent()){
            throw new GlobalException("l email est deja utiliser");
        }
        if(userRepository.findByCin(resgisterRequest.getCin()).isPresent()){
            throw new GlobalException("la carte d identite national est deja utilise");
        }
        if (userRepository.findByNumeroTelephone(resgisterRequest.getNumeroTelephone()).isPresent()){
            throw new GlobalException("le numero de telephone est deja utilise");
        }
        if (etudiantRepository.findByCne(resgisterRequest.getCne()).isPresent()){
            throw new GlobalException("le CNE existe deja");
        }
        log.info("*** le processus de REGISTER commence ***");
//        User user = new User();
        Etudiant etudiant = new Etudiant();
        Role userRole = roleRepository.findByName("USER").orElse(null);
        Role etudiantRole = roleRepository.findByName("ETUDIANT").orElse(null);

        etudiant.setNom(resgisterRequest.getNom());
        etudiant.setPrenom(resgisterRequest.getPrenom());
        etudiant.setCin(resgisterRequest.getCin());
        etudiant.setCne(resgisterRequest.getCne());
        etudiant.setNumeroTelephone(resgisterRequest.getNumeroTelephone());
        etudiant.setEcole(resgisterRequest.getEcole());
        etudiant.setUserName(resgisterRequest.getUsername());
        etudiant.setPassword(passwordEncoder.encode(resgisterRequest.getPassword()));
        etudiant.setEmail(resgisterRequest.getEmail());
        etudiant.getRoles().add(userRole);
        etudiant.getRoles().add(etudiantRole);

        log.info("l utilisateur depuis user : "+ etudiant);
        log.info("l utilisateur depuis registerRequest : "+ resgisterRequest);
        userRepository.save(etudiant);

        String jwtToken =  jwtService.generateJwtToken(etudiant);
        String jwtRefrecheToken = jwtService.generateRefrechTokenFromToken(jwtToken);
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setToken(jwtToken);
        authenticationResponse.setRefrechToken(jwtRefrecheToken);

        log.info("authentication reponse est : "+ authenticationResponse);

        return authenticationResponse;

    }


    public AuthenticationResponse auhenticate(AuthenticationRequest authenticationRequest) throws GlobalException{
        log.info("*** le processus d authentification commence ***");

        if(userRepository.findByUserName(authenticationRequest.getUsername()) == null){
            log.info("le username n existe pas dans notre base de donnees");
            throw new GlobalException("le username n existe pas dans notre base de donnees");
        }else {
            if (!passwordEncoder.matches(authenticationRequest.getPassword(),userRepository.findByUserName(authenticationRequest.getUsername()).getPassword())){
                log.info("Mot de passe incorrect pour l'utilisateur : " + authenticationRequest.getUsername());
                throw new GlobalException("Mot de passe incorrect pour l'utilisateur : " + authenticationRequest.getUsername());
            }
        }
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );
        log.info("UsernamePasswordAuthenticationToken : "+ (new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword())));
        User user = userRepository.findByUserName(authenticationRequest.getUsername());


        String jwtToken =  jwtService.generateJwtToken(user);

        String jwtRefrecheToken = jwtService.generateRefrechTokenFromToken(jwtToken);

        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setToken(jwtToken);
        authenticationResponse.setRefrechToken(jwtRefrecheToken);

        return authenticationResponse;
    }
}
