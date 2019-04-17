package org.logistique.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.logistique.entities.Chauffeur;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Primary
@Transactional
public class ChauffeurDao implements IChauffeurDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Chauffeur> getAll() {
		List<Chauffeur> chauffeurs = entityManager.createQuery("SELECT c FROM Chauffeur c").getResultList();
		return chauffeurs;
	}

	@Override
	public Chauffeur getChauffeurById(Long id) {
		return entityManager.find(Chauffeur.class, id);
	}

	@Override
	public void addChauffeur(Chauffeur chauffeur) {
		entityManager.persist(chauffeur);
	}

	@Override
	public void updateChauffeur(Chauffeur chauffeur) {
		entityManager.merge(chauffeur);
	}

	@Override
	public void deleteChauffeur(Long id) {
		Chauffeur chauffeur = entityManager.find(Chauffeur.class, id);
		if(chauffeur != null) {
			entityManager.remove(chauffeur);
		}
	}	
}
