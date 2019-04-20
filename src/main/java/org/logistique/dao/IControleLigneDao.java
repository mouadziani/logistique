package org.logistique.dao;

import java.util.List;

import org.logistique.entities.AutoCar;
import org.logistique.entities.ControleLigne;
import org.logistique.entities.Ligne;
import org.logistique.entities.Ville;

public interface IControleLigneDao {
	public List<ControleLigne> getAll();
	public ControleLigne getControleLigneById(Long id);
	public void addControleLigne(ControleLigne controleLigne);
	public void updateControleLigne(ControleLigne controleLigne);
	public void deleteControleLigne(Long id);
}
