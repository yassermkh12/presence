package com.example.presence.repositories;

import com.example.presence.entities.Presences;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPresenceRepository extends JpaRepository<Presences,Long> {
}
