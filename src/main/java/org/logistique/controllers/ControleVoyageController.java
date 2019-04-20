package org.logistique.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.logistique.dao.IAutoCarDao;
import org.logistique.dao.IChauffeurDao;
import org.logistique.dao.IControleLigneDao;
import org.logistique.dao.IControleVoyageDao;
import org.logistique.dao.ILigneDao;
import org.logistique.entities.AutoCar;
import org.logistique.entities.Chauffeur;
import org.logistique.entities.ControleLigne;
import org.logistique.entities.ControleVoyage;
import org.logistique.entities.Ligne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("controle-voyage")
public class ControleVoyageController {

	@Autowired
	private IControleVoyageDao controleVoyageDao;

	@Autowired
	private IChauffeurDao chauffeurDao;

	@Autowired
	private IAutoCarDao autoCarDao;

	@Autowired
	private ILigneDao ligneDao;

	@RequestMapping(path = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("controles", controleVoyageDao.getAll());
		return "controles-voyages/index";
	}

	@RequestMapping(path = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("chauffeurs", chauffeurDao.getAll());
		model.addAttribute("lignes", ligneDao.getAll());
		model.addAttribute("autocars", autoCarDao.getAll());
		return "controles-voyages/create";
	}

	@RequestMapping(path = "/store", method = RequestMethod.POST)
	public void store(HttpServletResponse response, @RequestParam("date") String date,
			@RequestParam(value = "ficheIteneraire", required = false) String ficheIteneraire,
			@RequestParam(value = "feuilleControleBagage", required = false) String feuilleControleBagage,
			@RequestParam(value = "presentationChauffeur", required = false) String presentationChauffeur,
			@RequestParam(value = "climatisation", required = false) String climatisation,
			@RequestParam(value = "chauffage", required = false) String chauffage,
			@RequestParam(value = "propreteAutocar", required = false) String propreteAutocar,
			@RequestParam(value = "observation", required = false) String observation,
			@RequestParam("chauffeur1_id") Long chauffeur1Id, @RequestParam("chauffeur2_id") Long chauffeur2Id,
			@RequestParam("ligne_depart_id") Long ligneDepartId, @RequestParam("ligne_arrive_id") Long ligneArriveId, @RequestParam("autocar_id") Long autocarId) throws Exception 
	{
		Chauffeur chauffeurPremier = chauffeurDao.getChauffeurById(chauffeur1Id);
		Chauffeur chauffeurDeuxieme = chauffeurDao.getChauffeurById(chauffeur2Id);
		AutoCar autoCar = autoCarDao.getAutoCarById(autocarId);
		Ligne ligneDepart = ligneDao.getLigneById(ligneDepartId);
		Ligne ligneArrive = ligneDao.getLigneById(ligneArriveId);
		Date dControle = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		
		ControleVoyage controleVoyage = new ControleVoyage();
		controleVoyage.setDate(dControle);
		controleVoyage.setFicheIteneraire((ficheIteneraire != null));
		controleVoyage.setFeuilleControleBagage((feuilleControleBagage != null));
		controleVoyage.setPresentationChauffeur((presentationChauffeur != null));
		controleVoyage.setClimatisation((climatisation != null));
		controleVoyage.setChauffage(chauffage != null);
		controleVoyage.setObservation(observation);
		controleVoyage.setPropreteAutocar(propreteAutocar != null);
		controleVoyage.setChauffeurPremier(chauffeurPremier);
		controleVoyage.setChauffeurDeuxieme(chauffeurDeuxieme);
		controleVoyage.setLigneDepart(ligneDepart);
		controleVoyage.setLigneArrive(ligneArrive);
		controleVoyage.setAutoCar(autoCar);
		controleVoyageDao.addControleVoyage(controleVoyage);
		
		response.sendRedirect("/controle-voyage/index");
	}

	@RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("controle", controleVoyageDao.getControleVoyageById(id));
		return "controles-voyages/edit";
	}

	@RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable Long id, HttpServletResponse response, @RequestParam("date") String date,
			@RequestParam(value = "ficheIteneraire", required = false) String ficheIteneraire,
			@RequestParam(value = "feuilleControleBagage", required = false) String feuilleControleBagage,
			@RequestParam(value = "presentationChauffeur", required = false) String presentationChauffeur,
			@RequestParam(value = "climatisation", required = false) String climatisation,
			@RequestParam(value = "chauffage", required = false) String chauffage,
			@RequestParam(value = "propreteAutocar", required = false) String propreteAutocar,
			@RequestParam(value = "observation", required = false) String observation,
			@RequestParam("chauffeur1_id") Long chauffeur1Id, @RequestParam("chauffeur2_id") Long chauffeur2Id,
			@RequestParam("ligne_depart_id") Long ligneDepartId, @RequestParam("ligne_arrive_id") Long ligneArriveId, @RequestParam("autocar_id") Long autocarId) throws Exception 
	{
		Chauffeur chauffeurPremier = chauffeurDao.getChauffeurById(chauffeur1Id);
		Chauffeur chauffeurDeuxieme = chauffeurDao.getChauffeurById(chauffeur2Id);
		AutoCar autoCar = autoCarDao.getAutoCarById(autocarId);
		Ligne ligneDepart = ligneDao.getLigneById(ligneDepartId);
		Ligne ligneArrive = ligneDao.getLigneById(ligneArriveId);
		Date dControle = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		
		ControleVoyage controleVoyage = new ControleVoyage();
		controleVoyage.setId(id);
		controleVoyage.setDate(dControle);
		controleVoyage.setFicheIteneraire((ficheIteneraire != null));
		controleVoyage.setFeuilleControleBagage((feuilleControleBagage != null));
		controleVoyage.setPresentationChauffeur((presentationChauffeur != null));
		controleVoyage.setClimatisation((climatisation != null));
		controleVoyage.setChauffage(chauffage != null);
		controleVoyage.setObservation(observation);
		controleVoyage.setPropreteAutocar(propreteAutocar != null);
		controleVoyage.setChauffeurPremier(chauffeurPremier);
		controleVoyage.setChauffeurDeuxieme(chauffeurDeuxieme);
		controleVoyage.setLigneDepart(ligneDepart);
		controleVoyage.setLigneArrive(ligneArrive);
		controleVoyage.setAutoCar(autoCar);
		controleVoyageDao.updateControleVoyage(controleVoyage);
		
		response.sendRedirect("/controle-voyage/index");
	}

	@RequestMapping(path = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("controle", controleVoyageDao.getControleVoyageById(id));
		return "controles-voyages/show";
	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id, HttpServletResponse response) throws IOException {
		controleVoyageDao.deleteControleVoyage(id);
		response.sendRedirect("/controle-voyage/index");
	}

}