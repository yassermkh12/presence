package com.example.presence.security.services;

import com.example.presence.security.authentications.*;
import com.example.presence.security.exceptions.GlobalException;

public interface IAuthenticationService {
    public AuthenticationResponse register(ResgisterRequest resgisterRequest) throws GlobalException;
    public AuthenticationResponse auhenticate(AuthenticationRequest authenticationRequest) throws GlobalException;
    public AuthenticationResponse registerEmploye(RegisterEmpoloyeRequest resgisterRequest) throws GlobalException;
    public AuthenticationResponse registerEtudiant(RegisterEtudiantRequest resgisterRequest) throws GlobalException;
}
