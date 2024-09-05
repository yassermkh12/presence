package com.example.presence.security.authentications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterEmpoloyeRequest extends ResgisterRequest{
    private String poste;
}
