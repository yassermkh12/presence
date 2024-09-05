package com.example.presence.repositories;

import com.example.presence.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IEtudiantRepository extends JpaRepository<Etudiant,Long> {
    public Optional<Etudiant> findByCne(String cne);
}
