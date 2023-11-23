package com.example.presence.repositories;

import com.example.presence.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartementRepository extends JpaRepository <Departement,Long> {
}
