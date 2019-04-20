package org.logistique.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.logistique.dao.IControleVoyageDao;
import org.logistique.entities.ControleVoyage;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.logistique.entities.ControleVoyage;

@Service
@Primary
@Transactional
public class ControleVoyageDao implements IControleVoyageDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<ControleVoyage> getAll() {
		List<ControleVoyage> controles = entityManager.createQuery("SELECT a FROM ControleVoyage a").getResultList();
		return controles;
	}

	@Override
	public ControleVoyage getControleVoyageById(Long id) {
		return entityManager.find(ControleVoyage.class, id);
	}

	@Override
	public void addControleVoyage(ControleVoyage controleVoyage) {
		entityManager.persist(controleVoyage);
	}

	@Override
	public void updateControleVoyage(ControleVoyage controleVoyage) {
		entityManager.merge(controleVoyage);
	}

	@Override
	public void deleteControleVoyage(Long id) {
		ControleVoyage controleVoyage = entityManager.find(ControleVoyage.class, id);
		if(controleVoyage != null) {
			entityManager.remove(controleVoyage);
		}
	}

}
