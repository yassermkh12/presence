package com.example.presence.repositories;

import com.example.presence.entities.Branche;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrancheRepository extends JpaRepository<Branche,Long> {
}
