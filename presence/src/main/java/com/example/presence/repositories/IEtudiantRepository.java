package com.example.presence.repositories;

import com.example.presence.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEtudiantRepository extends JpaRepository<Etudiant,Long> {
}
