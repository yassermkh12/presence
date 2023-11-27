package com.example.presence.entities;

import com.example.presence.entities.enums.StatusPresence;
import jakarta.persistence.*;
import jdk.jfr.BooleanFlag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "presences")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Presences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private StatusPresence statusPresence;
    private boolean estValide;
    @OneToOne
    @JoinColumn(name = "seance_id")
    private Seance seance;
    @OneToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;
}
