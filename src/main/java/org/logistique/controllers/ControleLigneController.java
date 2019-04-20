package org.logistique.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.logistique.dao.IAutoCarDao;
import org.logistique.dao.IChauffeurDao;
import org.logistique.dao.IControleLigneDao;
import org.logistique.dao.ILigneDao;
import org.logistique.entities.AutoCar;
import org.logistique.entities.Chauffeur;
import org.logistique.entities.ControleLigne;
import org.logistique.entities.Ligne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("controle-ligne")
public class ControleLigneController {

	@Autowired
	private IControleLigneDao controleLigneDao;

	@Autowired
	private IChauffeurDao chauffeurDao;

	@Autowired
	private IAutoCarDao autoCarDao;

	@Autowired
	private ILigneDao ligneDao;

	@RequestMapping(path = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("controles", controleLigneDao.getAll());
		return "controles-lignes/index";
	}

	@RequestMapping(path = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("chauffeurs", chauffeurDao.getAll());
		model.addAttribute("lignes", ligneDao.getAll());
		model.addAttribute("autocars", autoCarDao.getAll());
		return "controles-lignes/create";
	}

	@RequestMapping(path = "/store", method = RequestMethod.POST)
	public void store(HttpServletResponse response, @RequestParam("date") String date,
			@RequestParam("heur") double heur, @RequestParam("lieu") String lieu,
			@RequestParam("nbreVoyageurs") int nbreVoyageurs,
			@RequestParam("nbreVoyageursControle") int nbreVoyageursControle,
			@RequestParam("numFeuilleRoute") String numFeuilleRoute,
			@RequestParam("numSerieControle") String numSerieControle,
			@RequestParam(value = "boiteFarmain", required = false) String boiteFarmain,
			@RequestParam(value = "disponibiliteExtructeur", required = false) String disponibiliteExtructeur,
			@RequestParam(value = "ceintureSecuriteChauffeur", required = false) String ceintureSecuriteChauffeur,
			@RequestParam(value = "ceinture_securite_voyageur", required = false) String ceinture_securite_voyageur,
			@RequestParam(value = "tachygraphe", required = false) String tachygraphe,
			@RequestParam("chauffeur1_id") Long chauffeur1Id, @RequestParam("chauffeur2_id") Long chauffeur2Id,
			@RequestParam("ligne_id") Long ligneId, @RequestParam("autocar_id") Long autocarId) throws Exception 
	{
		Chauffeur chauffeurPremier = chauffeurDao.getChauffeurById(chauffeur1Id);
		Chauffeur chauffeurDeuxieme = chauffeurDao.getChauffeurById(chauffeur2Id);
		AutoCar autoCar = autoCarDao.getAutoCarById(autocarId);
		Ligne ligne = ligneDao.getLigneById(ligneId);
		Date dControle = new SimpleDateFormat("yyyy-MM-dd").parse(date);

		ControleLigne controleLigne = new ControleLigne();
		controleLigne.setDate(dControle);
		controleLigne.setHeur(heur);
		controleLigne.setLieu(lieu);
		controleLigne.setNbreVoyageurs(nbreVoyageurs);
		controleLigne.setNbreVoyageursControle(nbreVoyageursControle);
		controleLigne.setNumFeuilleRoute(numFeuilleRoute);
		controleLigne.setNumSerieControle(numSerieControle);
		controleLigne.setBoiteFarmain((boiteFarmain != null));
		controleLigne.setDisponibiliteExtructeur((disponibiliteExtructeur != null));
		controleLigne.setCeintureSecuriteChauffeur((ceintureSecuriteChauffeur != null));
		controleLigne.setCeinture_securite_voyageur((ceinture_securite_voyageur != null));
		controleLigne.setTachygraphe((tachygraphe != null));
		controleLigne.setChauffeurPremier(chauffeurPremier);
		controleLigne.setChauffeurDeuxieme(chauffeurDeuxieme);
		controleLigne.setLigne(ligne);
		controleLigne.setAutoCar(autoCar);
		controleLigneDao.addControleLigne(controleLigne);

		response.sendRedirect("/controle-ligne/index");
	}

	@RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("controle", controleLigneDao.getControleLigneById(id));
		return "controles-lignes/edit";
	}

	@RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable Long id, HttpServletResponse response, @RequestParam("date") String date,
			@RequestParam("heur") double heur, @RequestParam("lieu") String lieu,
			@RequestParam("nbreVoyageurs") int nbreVoyageurs,
			@RequestParam("nbreVoyageursControle") int nbreVoyageursControle,
			@RequestParam("numFeuilleRoute") String numFeuilleRoute,
			@RequestParam("numSerieControle") String numSerieControle,
			@RequestParam(value = "boiteFarmain", required = false) String boiteFarmain,
			@RequestParam(value = "disponibiliteExtructeur", required = false) String disponibiliteExtructeur,
			@RequestParam(value = "ceintureSecuriteChauffeur", required = false) String ceintureSecuriteChauffeur,
			@RequestParam(value = "ceinture_securite_voyageur", required = false) String ceinture_securite_voyageur,
			@RequestParam(value = "tachygraphe", required = false) String tachygraphe,
			@RequestParam("chauffeur1_id") Long chauffeur1Id, @RequestParam("chauffeur2_id") Long chauffeur2Id,
			@RequestParam("ligne_id") Long ligneId, @RequestParam("autocar_id") Long autocarId) throws Exception 
	{
		Chauffeur chauffeurPremier = chauffeurDao.getChauffeurById(chauffeur1Id);
		Chauffeur chauffeurDeuxieme = chauffeurDao.getChauffeurById(chauffeur2Id);
		AutoCar autoCar = autoCarDao.getAutoCarById(autocarId);
		Ligne ligne = ligneDao.getLigneById(ligneId);
		Date dControle = new SimpleDateFormat("yyyy-MM-dd").parse(date);

		ControleLigne controleLigne = new ControleLigne();
		controleLigne.setId(id);
		controleLigne.setDate(dControle);
		controleLigne.setHeur(heur);
		controleLigne.setLieu(lieu);
		controleLigne.setNbreVoyageurs(nbreVoyageurs);
		controleLigne.setNbreVoyageursControle(nbreVoyageursControle);
		controleLigne.setNumFeuilleRoute(numFeuilleRoute);
		controleLigne.setNumSerieControle(numSerieControle);
		controleLigne.setBoiteFarmain((boiteFarmain != null));
		controleLigne.setDisponibiliteExtructeur((disponibiliteExtructeur != null));
		controleLigne.setCeintureSecuriteChauffeur((ceintureSecuriteChauffeur != null));
		controleLigne.setCeinture_securite_voyageur((ceinture_securite_voyageur != null));
		controleLigne.setTachygraphe((tachygraphe != null));
		controleLigne.setChauffeurPremier(chauffeurPremier);
		controleLigne.setChauffeurDeuxieme(chauffeurDeuxieme);
		controleLigne.setLigne(ligne);
		controleLigne.setAutoCar(autoCar);
		controleLigneDao.updateControleLigne(controleLigne);
		
		response.sendRedirect("/controle-ligne/index");
	}

	@RequestMapping(path = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("controle", controleLigneDao.getControleLigneById(id));
		return "controles-lignes/show";
	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id, HttpServletResponse response) throws IOException {
		controleLigneDao.deleteControleLigne(id);
		response.sendRedirect("/autocar/index");
	}

}

