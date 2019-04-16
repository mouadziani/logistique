package org.logistique.services;

import org.logistique.entities.AutoCar;
import org.logistique.repositories.AutoCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AutoCarService {

	@Autowired
	private AutoCarRepository autoCarRepository;
	
	public AutoCar save(AutoCar autoCar) {
		return autoCarRepository.save(autoCar);
	}
	
}
