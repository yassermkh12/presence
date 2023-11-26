package com.example.presence.entities;

import com.example.presence.entities.enums.TypeSeance;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.*;

@Entity
@Table(name = "seance")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dateSeance;
    @Enumerated(EnumType.STRING)
    private TypeSeance typeSeance;
    @OneToOne
    @JoinColumn(name = "module_id")
    private Module module;
}
