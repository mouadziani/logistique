package org.logistique.dao;

import java.util.List;

import org.logistique.entities.AutoCar;

public interface IAutoCarDao {
	public List<AutoCar> getAll();
	public AutoCar getAutoCarById(Long id);
	public void addAutoCar(AutoCar autoCar);
	public void updateAutoCar(AutoCar autoCar);
	public void deleteAutoCar(Long id);
	public List<AutoCar> getLastAutocars(int length);
	public int getCountAutocars();
}
