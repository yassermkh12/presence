package com.example.presence.security.repositories;

import com.example.presence.security.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User,Long> {
    public User findByUserName(String userName);
    public Optional<User> findByEmail(String email);
    public Optional<User> findByCin(String cin);
    public Optional<User> findByNumeroTelephone(String numeroTelephone);
}
