package org.logistique;

import org.logistique.dao.IChauffeurDao;
import org.logistique.entities.Chauffeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogistiqueApplication implements CommandLineRunner {

	@Autowired
	private IChauffeurDao chauffeurDao;
	
	public static void main(String[] args) {
		SpringApplication.run(LogistiqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Created");
		Chauffeur chauffeur = new Chauffeur(null, "Test", "Test", "Testsdhjqshfdhqsdf", "Tel");
		chauffeurDao.addChauffeur(chauffeur);
	}

}
