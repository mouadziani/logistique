package org.logistique.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.logistique.dao.IVilleDao;
import org.logistique.entities.Ville;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.logistique.entities.Ville;

@Service
@Primary
@Transactional
public class VilleDao implements IVilleDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Ville> getAll() {
		List<Ville> villes = entityManager.createQuery("SELECT a FROM Ville a").getResultList();
		return villes;
	}

	@Override
	public Ville getVilleById(Long id) {
		return entityManager.find(Ville.class, id);
	}

	@Override
	public void addVille(Ville ville) {
		entityManager.persist(ville);
	}

	@Override
	public void updateVille(Ville ville) {
		entityManager.merge(ville);
	}

	@Override
	public void deleteVille(Long id) {
		Ville ville = entityManager.find(Ville.class, id);
		if(ville != null) {
			entityManager.remove(ville);
		}
	}

}
