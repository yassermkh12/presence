package com.example.presence.repositories;

import com.example.presence.entities.Ecole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEcoleRepository extends JpaRepository<Ecole,Long> {
}
