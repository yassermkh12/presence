package com.example.presence.entities;

import com.example.presence.security.entities.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "etudiant")
@NoArgsConstructor
@Data
public class Etudiant extends User{
    private String cne;
    @ManyToOne
    private Ecole ecole;
    @OneToOne(mappedBy = "etudiant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Presences presences;

//    @OneToOne
//    @JoinColumn(name = "user_id")
//    private User etudiantUser;
}
