package com.example.presence.repositories;

import com.example.presence.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeRepository extends JpaRepository<Employe,Long> {
}
