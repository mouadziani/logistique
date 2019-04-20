package org.logistique.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.logistique.dao.IControleLigneDao;
import org.logistique.entities.ControleLigne;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.logistique.entities.ControleLigne;

@Service
@Primary
@Transactional
public class ControleLigneDao implements IControleLigneDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<ControleLigne> getAll() {
		List<ControleLigne> controles = entityManager.createQuery("SELECT a FROM ControleLigne a").getResultList();
		return controles;
	}

	@Override
	public ControleLigne getControleLigneById(Long id) {
		return entityManager.find(ControleLigne.class, id);
	}

	@Override
	public void addControleLigne(ControleLigne controleLigne) {
		entityManager.persist(controleLigne);
	}

	@Override
	public void updateControleLigne(ControleLigne controleLigne) {
		entityManager.merge(controleLigne);
	}

	@Override
	public void deleteControleLigne(Long id) {
		ControleLigne controleLigne = entityManager.find(ControleLigne.class, id);
		if(controleLigne != null) {
			entityManager.remove(controleLigne);
		}
	}

}
