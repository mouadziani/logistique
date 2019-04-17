package org.logistique.dao;

import java.util.List;

import org.logistique.entities.Chauffeur;

public interface IChauffeurDao {
	
	public List<Chauffeur> getAll();
	public Chauffeur getChauffeurById(Long id);
	public void addChauffeur(Chauffeur chauffeur);
	public void updateChauffeur(Chauffeur chauffeur);
	public void deleteChauffeur(Long id);
	
}
