package com.example.presence;

import com.example.presence.security.entities.Role;
import com.example.presence.security.repositories.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PresenceApplication implements CommandLineRunner {

	@Autowired
	private IRoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(PresenceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (roleRepository.count() == 0) {
			Role adminRole = new Role(1L,"ADMIN");
			Role userRole = new Role(2L,"USER");
			roleRepository.save(adminRole);
			roleRepository.save(userRole);
		}
	}
}
