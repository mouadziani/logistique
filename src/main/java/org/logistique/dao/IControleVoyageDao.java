package org.logistique.dao;

import java.util.List;

import org.logistique.entities.AutoCar;
import org.logistique.entities.ControleLigne;
import org.logistique.entities.ControleVoyage;
import org.logistique.entities.Ligne;
import org.logistique.entities.Ville;

public interface IControleVoyageDao {
	public List<ControleVoyage> getAll();
	public ControleVoyage getControleVoyageById(Long id);
	public void addControleVoyage(ControleVoyage controleVoyage);
	public void updateControleVoyage(ControleVoyage controleVoyage);
	public void deleteControleVoyage(Long id);
}
