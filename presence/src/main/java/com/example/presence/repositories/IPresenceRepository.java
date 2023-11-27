package com.example.presence.repositories;

import com.example.presence.entities.Presence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPresenceRepository extends JpaRepository<Presence,Long> {
}
