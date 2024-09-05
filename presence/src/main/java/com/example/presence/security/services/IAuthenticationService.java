package com.example.presence.security.services;

import com.example.presence.security.authentications.AuthenticationRequest;
import com.example.presence.security.authentications.AuthenticationResponse;
import com.example.presence.security.authentications.RegisterEmpoloyeRequest;
import com.example.presence.security.authentications.ResgisterRequest;
import com.example.presence.security.exceptions.GlobalException;

public interface IAuthenticationService {
    public AuthenticationResponse register(ResgisterRequest resgisterRequest) throws GlobalException;
    public AuthenticationResponse auhenticate(AuthenticationRequest authenticationRequest) throws GlobalException;
    public AuthenticationResponse registerEmploye(RegisterEmpoloyeRequest resgisterRequest) throws GlobalException;
}
