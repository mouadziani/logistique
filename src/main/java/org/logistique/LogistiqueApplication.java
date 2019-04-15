package org.logistique;

import org.logistique.dao.UserRepository;
import org.logistique.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogistiqueApplication implements CommandLineRunner {

	@Autowired
	UserRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(LogistiqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.save(new User("Test"));
		
	}

}
