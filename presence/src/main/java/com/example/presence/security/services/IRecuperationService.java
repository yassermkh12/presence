package com.example.presence.security.services;

import com.example.presence.security.exceptions.GlobalException;

public interface IRecuperationService {
    public void forgotPassword(String email) throws GlobalException;
    public void verifyCode(String email, String code) throws GlobalException;
    public void updatePasswordByEmail(String email, String password) throws GlobalException;
}
