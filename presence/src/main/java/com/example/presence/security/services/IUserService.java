package com.example.presence.security.services;

import com.example.presence.security.entitiesDto.UserDto;
import com.example.presence.security.exceptions.GlobalException;

import java.util.List;

public interface IUserService {
    public List<UserDto> getAllUser();
    public UserDto addNewUser(UserDto userDto);
    public UserDto getById(Long id);
    public UserDto getByUserName(String userName);
    public void addRoleToUser(Long userId,Long roleId);
    public void removeRoleToUser(Long userId, Long roleId);
    public UserDto getByEmail(String email) throws GlobalException;
    public void updatePasswordByEmail(String email, String password) throws GlobalException;
}
