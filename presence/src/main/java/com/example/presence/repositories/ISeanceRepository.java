package com.example.presence.repositories;

import com.example.presence.entities.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISeanceRepository extends JpaRepository<Seance,Long> {
}
