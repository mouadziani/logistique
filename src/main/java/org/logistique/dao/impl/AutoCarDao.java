package org.logistique.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.logistique.dao.IAutoCarDao;
import org.logistique.entities.AutoCar;
import org.logistique.entities.Chauffeur;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Primary
@Transactional
public class AutoCarDao implements IAutoCarDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<AutoCar> getAll() {
		List<AutoCar> autoCars = entityManager.createQuery("SELECT a FROM AutoCar a").getResultList();
		return autoCars;
	}

	@Override
	public AutoCar getAutoCarById(Long id) {
		return entityManager.find(AutoCar.class, id);
	}

	@Override
	public void addAutoCar(AutoCar autoCar) {
		entityManager.persist(autoCar);
	}

	@Override
	public void updateAutoCar(AutoCar autoCar) {
		entityManager.merge(autoCar);
	}

	@Override
	public void deleteAutoCar(Long id) {
		AutoCar autoCar = entityManager.find(AutoCar.class, id);
		if(autoCar != null) {
			entityManager.remove(autoCar);
		}
	}

	@Override
	public List<AutoCar> getLastAutocars(int length) {
		return entityManager.createQuery("SELECT a FROM AutoCar a").setMaxResults(length).getResultList();
	}

	@Override
	public int getCountAutocars() {
		return ((Long) entityManager.createQuery("SELECT COUNT(a) FROM AutoCar a").getSingleResult()).intValue();
	}

}
