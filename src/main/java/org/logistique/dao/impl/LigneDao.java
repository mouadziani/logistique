package org.logistique.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.logistique.entities.Ligne;
import org.logistique.dao.ILigneDao;
import org.logistique.entities.AutoCar;
import org.logistique.entities.Chauffeur;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Primary
@Transactional
public class LigneDao implements ILigneDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Ligne> getAll() {
		List<Ligne> lignes = entityManager.createQuery("SELECT a FROM Ligne a").getResultList();
		return lignes;
	}

	@Override
	public Ligne getLigneById(Long id) {
		return entityManager.find(Ligne.class, id);
	}

	@Override
	public void addLigne(Ligne ligne) {
		entityManager.persist(ligne);
	}

	@Override
	public void updateLigne(Ligne ligne) {
		entityManager.merge(ligne);
	}

	@Override
	public void deleteLigne(Long id) {
		Ligne ligne = entityManager.find(Ligne.class, id);
		if(ligne != null) {
			entityManager.remove(ligne);
		}
	}

	@Override
	public List<Ligne> getLastLignes(int length) {
		return entityManager.createQuery("SELECT a FROM Ligne a").setMaxResults(length).getResultList();
	}

	@Override
	public int getCountLignes() {
		return ((Long) entityManager.createQuery("SELECT COUNT(a) FROM Ligne a").getSingleResult()).intValue();
	}
}
