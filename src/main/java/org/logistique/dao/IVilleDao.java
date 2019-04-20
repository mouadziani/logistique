package org.logistique.dao;

import java.util.List;

import org.logistique.entities.AutoCar;
import org.logistique.entities.Ligne;
import org.logistique.entities.Ville;

public interface IVilleDao {
	public List<Ville> getAll();
	public Ville getVilleById(Long id);
	public void addVille(Ville ville);
	public void updateVille(Ville ville);
	public void deleteVille(Long id);
}
