package com.example.presence.security.controllers;

import com.example.presence.security.entitiesDto.UserDto;
import com.example.presence.security.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private IUserService accountService;
    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUser(){
        List<UserDto> userDtos = accountService.getAllUser();
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }
    @GetMapping("/by-user-name/{userName}")
    public ResponseEntity<UserDto> getUserByUserName(@PathVariable String userName){
        UserDto userDto = accountService.getByUserName(userName);
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }
    @GetMapping("/by-id/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
        UserDto userDto = accountService.getById(id);
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }
    @PostMapping("/save-user")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto createUserDto = accountService.addNewUser(userDto);
        return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
    }
    @PostMapping("/add-role-to-user/{userId}/{roleId}")
    public ResponseEntity<Void> addRoleToUser(@PathVariable Long userId,@PathVariable Long roleId){
        accountService.addRoleToUser(userId,roleId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/remove-role-to-user/{userId}/{roleId}")
    public ResponseEntity<Void> removeRoleToUser(@PathVariable Long userId,@PathVariable Long roleId){
        accountService.removeRoleToUser(userId,roleId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find-by-email/{email}")
    public ResponseEntity<UserDto> getByEmail(@PathVariable String email){
        UserDto userDto = accountService.getByEmail(email);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
    @PutMapping("/update-password-by-email/{email}/{password}")
    public ResponseEntity<Void> updatePasswordByEmail(@PathVariable String email,@PathVariable String password){
        accountService.updatePasswordByEmail(email,password);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
