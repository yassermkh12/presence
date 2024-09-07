package com.example.presence.services.impl;

import com.example.presence.entities.Etudiant;
import com.example.presence.entitiesDto.EtudiantDto;
import com.example.presence.exceptions.NotFoundException;
import com.example.presence.repositories.IEtudiantRepository;
import com.example.presence.security.entities.Role;
import com.example.presence.security.entities.User;
import com.example.presence.security.exceptions.GlobalException;
import com.example.presence.security.repositories.IRoleRepository;
import com.example.presence.security.repositories.IUserRepository;
import com.example.presence.services.IEtudiantService;
import com.example.presence.transformers.EcoleTransformer;
import com.example.presence.transformers.EtudiantTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EtudiantService implements IEtudiantService {
    @Autowired
    private IEtudiantRepository etudiantRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IRoleRepository roleRepository;

    public List<EtudiantDto> getAllEtudiant() throws NotFoundException {
        List<Etudiant> etudiants = etudiantRepository.findAll();
        if (etudiants != null) {
            return EtudiantTransformer.entityToDtoList(etudiants);
        }else {
            throw new NotFoundException("la base de donnee est encore vide");
        }
    }
    public Optional<EtudiantDto> getEtudiantById(Long id) throws NotFoundException {
        Optional<Etudiant> etudiant = etudiantRepository.findById(id);
        if(etudiant.isPresent()){
            return etudiant.map(EtudiantTransformer::entityToDto);
        }else{
            throw new NotFoundException("il n y a pas d etudiant avec id "+ id);
        }
    }
    public EtudiantDto saveEtudiant(EtudiantDto etudiantDto) throws GlobalException {
            Etudiant etudiant = EtudiantTransformer.dtoToEntity(etudiantDto);

            if (userRepository.findByUserName(etudiant.getUsername()) != null){
                throw new GlobalException("le username est deja utilise");
            }
            if (etudiantRepository.findByCne(etudiant.getCne()).isPresent()){
                throw new GlobalException("le CNE est deja utilise");
            }
            if (userRepository.findByEmail(etudiant.getEmail()).isPresent()){
                throw new GlobalException("l email est deja utilise");
            }
            if (userRepository.findByCin(etudiant.getCin()).isPresent()){
                throw new GlobalException("la CIN est deja utilise");
            }
            if (userRepository.findByNumeroTelephone(etudiant.getNumeroTelephone()).isPresent()){
                throw new GlobalException("le numero de telephone est deja utilise");
            }

            Role userRole = roleRepository.findByName("USER").orElse(null);
            Role etudiantRole = roleRepository.findByName("ETUDIANT").orElse(null);

            etudiant.setPassword(passwordEncoder.encode(etudiant.getUsername()));
            etudiant.getRoles().add(userRole);
            etudiant.getRoles().add(etudiantRole);

            userRepository.save(etudiant);

            return EtudiantTransformer.entityToDto(etudiant);
    }
    public EtudiantDto updateEtudiant(Long id, EtudiantDto etudiantDtoUpdate) throws NotFoundException,GlobalException {
        Optional<Etudiant> etudiantOptional = etudiantRepository.findById(id);

        if(etudiantOptional.isPresent()){

            User etudiantWithSameUsername = userRepository.findByUserName(etudiantDtoUpdate.getUserName());
            Optional<User> etudiantWithSameEmail = userRepository.findByEmail(etudiantDtoUpdate.getEmail());
            Optional<User> etudiantWithSameCin = userRepository.findByCin(etudiantDtoUpdate.getCin());
            Optional<User> etudiantWithSameNumeroTelephone = userRepository.findByNumeroTelephone(etudiantDtoUpdate.getNumeroTelephone());
            Optional<Etudiant> etudiantWithSameCne = etudiantRepository.findByCne(etudiantDtoUpdate.getCne());

            if (etudiantWithSameUsername != null && !etudiantWithSameUsername.getId().equals(id)){
                throw new GlobalException("le username est deja utilise");
            }
            if (etudiantWithSameEmail.isPresent() && !etudiantWithSameEmail.get().getId().equals(id)){
                throw new GlobalException("l email est deja utilise");
            }
            if (etudiantWithSameCin.isPresent() && !etudiantWithSameCin.get().getId().equals(id)){
                throw new GlobalException("la CIN est deja utilise");
            }
            if (etudiantWithSameNumeroTelephone.isPresent() && !etudiantWithSameNumeroTelephone.get().getId().equals(id)){
                throw new GlobalException("le numero de telephone est deja utilise");
            }
            if (etudiantWithSameCne.isPresent() && !etudiantWithSameCne.get().getId().equals(id)){
                throw new GlobalException("le CNE est deja utilise");
            }

            Etudiant etudiant = etudiantOptional.get();
            etudiant.setNom(etudiantDtoUpdate.getNom());
            etudiant.setPrenom(etudiantDtoUpdate.getPrenom());
            etudiant.setCin(etudiantDtoUpdate.getCin());
            etudiant.setEmail(etudiantDtoUpdate.getEmail());
            etudiant.setNumeroTelephone(etudiantDtoUpdate.getNumeroTelephone());
            etudiant.setCne(etudiantDtoUpdate.getCne());
            etudiant.setUserName(etudiantDtoUpdate.getUserName());
            etudiant.setEcole(EcoleTransformer.dtoToEntity(etudiantDtoUpdate.getEcoleDto()));

            userRepository.save(etudiant);
            return EtudiantTransformer.entityToDto(etudiant);
        }else {
            throw new NotFoundException("il n y a pas d etudiant avec id "+ id);
        }
    }
    public void deleteEtudiant(Long id){
        etudiantRepository.deleteById(id);
    }
}
