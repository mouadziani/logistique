package org.logistique.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.logistique.dao.IAutoCarDao;
import org.logistique.dao.IChauffeurDao;
import org.logistique.dao.ILigneDao;
import org.logistique.dao.IVoyageDao;
import org.logistique.entities.AutoCar;
import org.logistique.entities.Chauffeur;
import org.logistique.entities.Ligne;
import org.logistique.entities.Voyage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("voyage")
public class VoyageController {

	@Autowired
	private IVoyageDao voyageDao;
	@Autowired
	private IChauffeurDao chauffeurDao;
	@Autowired
	private ILigneDao ligneDao;
	@Autowired
	private IAutoCarDao autoCarDao;

	@RequestMapping(path = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("voyages", voyageDao.getAll());
		return "voyages/index";
	}

	@RequestMapping(path = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("chauffeurs", chauffeurDao.getAll());
		model.addAttribute("lignes", ligneDao.getAll());
		model.addAttribute("autocars", autoCarDao.getAll());
		return "voyages/create";
	}

	@RequestMapping(path = "/store", method = RequestMethod.POST)
	public void store(HttpServletResponse response, @RequestParam("chauffeur1_id") Long chauffeur1Id,
			@RequestParam("chauffeur2_id") Long chauffeur2Id, @RequestParam("autocar_id") Long autoCarId,
			@RequestParam("ligne_id") Long ligneId, @RequestParam("date") String date)
			throws IOException, ParseException {
		Ligne ligne = ligneDao.getLigneById(ligneId);
		Chauffeur chauffeurPremier = chauffeurDao.getChauffeurById(chauffeur1Id);
		Chauffeur chauffeurDeuxieme = chauffeurDao.getChauffeurById(chauffeur2Id);
		AutoCar autoCar = autoCarDao.getAutoCarById(autoCarId);
		Date dVoyage = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		Voyage voyage = new Voyage();
		voyage.setDate(dVoyage);
		voyage.setLigne(ligne);
		voyage.setChauffeurPremier(chauffeurPremier);
		voyage.setChauffeurDeuxieme(chauffeurDeuxieme);
		voyage.setChauffeurDeuxieme(chauffeurDeuxieme);
		voyage.setAutoCar(autoCar);
		voyageDao.addVoyage(voyage);
		response.sendRedirect("/voyage/index");
	}

	@RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("voyage", voyageDao.getVoyageById(id));
		model.addAttribute("chauffeurs", chauffeurDao.getAll());
		model.addAttribute("lignes", ligneDao.getAll());
		model.addAttribute("autocars", autoCarDao.getAll());
		return "voyages/edit";
	}

	@RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable Long id, HttpServletResponse response,
			@RequestParam("chauffeur1_id") Long chauffeur1Id, @RequestParam("chauffeur2_id") Long chauffeur2Id,
			@RequestParam("autocar_id") Long autoCarId, @RequestParam("ligne_id") Long ligneId,
			@RequestParam("date") String date) throws IOException, ParseException {
		Ligne ligne = ligneDao.getLigneById(ligneId);
		Chauffeur chauffeurPremier = chauffeurDao.getChauffeurById(chauffeur1Id);
		Chauffeur chauffeurDeuxieme = chauffeurDao.getChauffeurById(chauffeur2Id);
		AutoCar autoCar = autoCarDao.getAutoCarById(autoCarId);
		Date dVoyage = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		Voyage voyage = new Voyage();
		voyage.setDate(dVoyage);
		voyage.setLigne(ligne);
		voyage.setChauffeurPremier(chauffeurPremier);
		voyage.setChauffeurDeuxieme(chauffeurDeuxieme);
		voyage.setChauffeurDeuxieme(chauffeurDeuxieme);
		voyage.setAutoCar(autoCar);
		voyageDao.addVoyage(voyage);
		response.sendRedirect("/voyage/index");
	}

	@RequestMapping(path = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("autoCar", voyageDao.getVoyageById(id));
		return "voyages/show";
	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id, HttpServletResponse response) throws IOException {
		voyageDao.deleteVoyage(id);
		response.sendRedirect("/voyage/index");
	}

}
