package com.example.presence.services.impl;

import com.example.presence.entities.Employe;
import com.example.presence.entitiesDto.EmployeDto;
import com.example.presence.exceptions.NotFoundException;
import com.example.presence.repositories.IEmployeRepository;
import com.example.presence.security.entities.Role;
import com.example.presence.security.entities.User;
import com.example.presence.security.exceptions.GlobalException;
import com.example.presence.security.repositories.IRoleRepository;
import com.example.presence.security.repositories.IUserRepository;
import com.example.presence.services.IEmployeService;
import com.example.presence.transformers.EmployeTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.*;
@Slf4j
@Service
public class EmployeService implements IEmployeService {
    @Autowired
    private IEmployeRepository employeRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<EmployeDto> getAllEmploye(){
        List<Employe> employes = employeRepository.findAll();
        return EmployeTransformer.entityToDtoList(employes);
    }
    public EmployeDto getEmployeById(Long id) throws NotFoundException {
        Employe employe = employeRepository.findById(id).orElse(null);
        if(employe != null){
            return EmployeTransformer.entityToDto(employe);
        }else {
            throw new NotFoundException("il n y a pas d employe avec id "+ id);
        }
    }
    public EmployeDto saveEmploye(EmployeDto employeDto) throws GlobalException {
        Employe employe = EmployeTransformer.dtoToEntity(employeDto);
        if (userRepository.findByUserName(employe.getUsername()) != null) {
            log.info("username deja utiliser");
            throw new GlobalException("username deja utilise");
        }
        if (userRepository.findByEmail(employe.getEmail()).isPresent()){
            throw new GlobalException("l email est deja utilise");
        }
        if(userRepository.findByCin(employe.getCin()).isPresent()){
            throw new GlobalException("la carte d identite national est deja utilise");
        }
        if (userRepository.findByNumeroTelephone(employe.getNumeroTelephone()).isPresent()){
            throw new GlobalException("le numero de telephone est deja utilise");
        }
        Role userRole = roleRepository.findByName("USER").orElse(null);
        Role employeRole = roleRepository.findByName("EMPLOYE").orElse(null);

        employe.getRoles().add(userRole);
        employe.getRoles().add(employeRole);
        employe.setPassword(passwordEncoder.encode(employe.getUsername()));
        userRepository.save(employe);

        return EmployeTransformer.entityToDto(employe);
    }
    public List<EmployeDto> saveAllEmploye(List<EmployeDto> employeDtos){
        List<Employe> employes = EmployeTransformer.dtoToEntityList(employeDtos);
        employeRepository.saveAll(employes);
        return EmployeTransformer.entityToDtoList(employes);
    }
    public EmployeDto updateEmploye(Long id, EmployeDto employeDto) throws NotFoundException,GlobalException {
        Employe employe = employeRepository.findById(id).orElse(null);
        if(employe != null){

            User employeWithSameUsername = userRepository.findByUserName(employeDto.getUserName());
            Optional<User> employeWithSameEmail = userRepository.findByEmail(employeDto.getEmail());
            Optional<User> employeWithSameCin = userRepository.findByCin(employeDto.getCin());
            Optional<User> employeWithSameNumeroTelephone = userRepository.findByNumeroTelephone(employeDto.getNumeroTelephone());

            if (employeWithSameUsername != null && !employeWithSameUsername.getId().equals(id)){
                throw new GlobalException("le username est deja utilise");
            }
            if (employeWithSameEmail.isPresent() && !employeWithSameEmail.get().getId().equals(id)){
                throw new GlobalException("l email est deja utilise");
            }
            if (employeWithSameCin.isPresent() && !employeWithSameCin.get().getId().equals(id)){
                throw new GlobalException("la CIN est deja utilise");
            }
            if (employeWithSameNumeroTelephone.isPresent() && !employeWithSameNumeroTelephone.get().getId().equals(id)){
                throw new GlobalException("le numero de telephone est deja utilise");
            }

            employe.setUserName(employeDto.getUserName());
            employe.setNom(employeDto.getNom());
            employe.setPrenom(employeDto.getPrenom());
            employe.setPoste(employeDto.getPoste());
            employe.setEmail(employeDto.getEmail());
            employe.setNumeroTelephone(employeDto.getNumeroTelephone());
            employe.setCin(employeDto.getCin());

            userRepository.save(employe);

            return EmployeTransformer.entityToDto(employe);
        }else {
            throw new NotFoundException("il n y a pas d employe avec id "+ id);
        }
    }
    public void deleteEmploye(Long id){
        employeRepository.deleteById(id);
    }
}
