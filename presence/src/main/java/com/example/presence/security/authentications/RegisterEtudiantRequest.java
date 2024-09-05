package com.example.presence.security.authentications;

import com.example.presence.entities.Ecole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterEtudiantRequest extends ResgisterRequest{
    private String cne;
    private Ecole ecole;
}
