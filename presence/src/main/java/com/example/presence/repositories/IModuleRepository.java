package com.example.presence.repositories;

import com.example.presence.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IModuleRepository extends JpaRepository<Module,Long> {
}
