package org.logistique.dao;

import java.util.List;

import org.logistique.entities.AutoCar;
import org.logistique.entities.Voyage;

public interface IVoyageDao {
	public List<Voyage> getAll();
	public Voyage getVoyageById(Long id);
	public void addVoyage(Voyage voyage);
	public void updateVoyage(Voyage voyage);
	public void deleteVoyage(Long id);
	public List<Voyage> getLastVoyages(int length);
	public int getCountVoyages();
}
