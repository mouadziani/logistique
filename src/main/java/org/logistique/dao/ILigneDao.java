package org.logistique.dao;

import java.util.List;

import org.logistique.entities.AutoCar;
import org.logistique.entities.Ligne;

public interface ILigneDao {
	public List<Ligne> getAll();
	public Ligne getLigneById(Long id);
	public void addLigne(Ligne autoCar);
	public void updateLigne(Ligne autoCar);
	public void deleteLigne(Long id);
	public List<Ligne> getLastLignes(int length);
	public int getCountLignes();
}
