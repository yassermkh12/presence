package com.example.presence.security.authentications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResgisterRequest {
    private String nom;
    private String prenom;
    private String numeroTelephone;
    private String username;
    private String cin;
    private String email;
    private String password;
}
