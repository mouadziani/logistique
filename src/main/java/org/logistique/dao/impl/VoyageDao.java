package org.logistique.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.logistique.dao.IVoyageDao;
import org.logistique.entities.Ligne;
import org.logistique.entities.Voyage;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Primary
@Transactional
public class VoyageDao implements IVoyageDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Voyage> getAll() {
		List<Voyage> voyages = entityManager.createQuery("SELECT a FROM Voyage a").getResultList();
		return voyages;
	}

	@Override
	public Voyage getVoyageById(Long id) {
		return entityManager.find(Voyage.class, id);
	}

	@Override
	public void addVoyage(Voyage voyage) {
		entityManager.persist(voyage);
	}

	@Override
	public void updateVoyage(Voyage voyage) {
		entityManager.merge(voyage);
	}

	@Override
	public void deleteVoyage(Long id) {
		Voyage voyage = entityManager.find(Voyage.class, id);
		if(voyage != null) {
			entityManager.remove(voyage);
		}
	}

	@Override
	public List<Voyage> getLastVoyages(int length) {
		return entityManager.createQuery("SELECT a FROM Voyage a").setMaxResults(length).getResultList();
	}

	@Override
	public int getCountVoyages() {
		return ((Long) entityManager.createQuery("SELECT COUNT(a) FROM Voyage a").getSingleResult()).intValue();
	}}
