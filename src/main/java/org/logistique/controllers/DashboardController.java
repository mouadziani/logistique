package org.logistique.controllers;

import org.logistique.dao.IAutoCarDao;
import org.logistique.dao.IChauffeurDao;
import org.logistique.dao.ILigneDao;
import org.logistique.dao.IVoyageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

	@Autowired
	private IVoyageDao voyageDao;
	@Autowired
	private IChauffeurDao chauffeurDao;
	@Autowired
	private IAutoCarDao autocarDao;
	@Autowired
	private ILigneDao ligneVoyageDao;
	
	@RequestMapping("/dashboard")
	public String index(Model model) {
		model.addAttribute("nbrVoyages", voyageDao.getCountVoyages());
		model.addAttribute("nbrChauffeurs", chauffeurDao.getCountChauffeurs());
		model.addAttribute("nbrAutocars", autocarDao.getCountAutocars());
		model.addAttribute("nbrLigneVoyage", ligneVoyageDao.getCountLignes());
		model.addAttribute("lastVoyages", voyageDao.getLastVoyages(5));
		model.addAttribute("lastChauffeurs", chauffeurDao.getLastChauffeurs(5));
		model.addAttribute("lastLignes", ligneVoyageDao.getLastLignes(5));
		model.addAttribute("lastAutocars", autocarDao.getLastAutocars(5));
		
		return "dashboard/index";
	}
	
}
