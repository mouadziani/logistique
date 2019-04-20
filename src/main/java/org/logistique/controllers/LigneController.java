package org.logistique.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.logistique.dao.ILigneDao;
import org.logistique.dao.IVilleDao;
import org.logistique.entities.Ligne;
import org.logistique.entities.Ville;
import org.logistique.entities.Voyage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("ligne")
public class LigneController {

	@Autowired
	private ILigneDao ligneDao;

	@Autowired
	private IVilleDao villeDao;

	@RequestMapping(path = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("lignes", ligneDao.getAll());
		return "lignes/index";
	}

	@RequestMapping(path = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("villes", villeDao.getAll());
		return "lignes/create";
	}

	@RequestMapping(path = "/store", method = RequestMethod.POST)
	public void store(HttpServletResponse response, @RequestParam("ville_depart_id") Long villeDepartId,
			@RequestParam("ville_arrive_id") Long villeArriveId, @RequestParam("ville_escale_id") Long villeEscaleId,
			@RequestParam("date_depart") String dateDepart, @RequestParam("date_arrive") String dateArrive,
			@RequestParam("date_retour") String dateRetour, @RequestParam("heur_depart") double heurDepart,
			@RequestParam("heur_arrive") double heurArrive, @RequestParam("heur_retour") double heurRetour,
			@RequestParam("duree_voyage") int dureeVoyage, @RequestParam("duree_repos") int dureeRepos,
			@RequestParam("duree_immob") int dureeImmob, @RequestParam("killometrage") int killometrage)
			throws IOException, ParseException {
		System.out.println(dateDepart);
		Date dDepart = new SimpleDateFormat("yyyy-MM-dd").parse(dateDepart);
		Date dArrive = new SimpleDateFormat("yyyy-MM-dd").parse(dateArrive);
		Date dRetour = new SimpleDateFormat("yyyy-MM-dd").parse(dateRetour);
		Ville villeDepart = villeDao.getVilleById(villeDepartId);
		Ville villeArrive = villeDao.getVilleById(villeArriveId);
		Ville villeEscale = villeDao.getVilleById(villeEscaleId);
		Ligne ligne = new Ligne();
		ligne.setVilleDepart(villeDepart);
		ligne.setVilleArrive(villeArrive);
		ligne.setVilleEscale(villeEscale);
		ligne.setDateDepart(dDepart);
		ligne.setHeurDepart(heurDepart);
		ligne.setDateArrive(dArrive);
		ligne.setHeurArrive(heurArrive);
		ligne.setDateRetour(dRetour);
		ligne.setHeurRetour(heurRetour);
		ligne.setDureeVoyage(dureeVoyage);
		ligne.setDureeRepos(dureeRepos);
		ligne.setDureeImmob(dureeImmob);
		ligne.setKilometrage(killometrage);
		ligneDao.addLigne(ligne);
		response.sendRedirect("/ligne/index");
	}

	@RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("ligne", ligneDao.getLigneById(id));
		return "lignes/edit";
	}

	@RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable Long id, HttpServletResponse response,
			@RequestParam("ville_depart_id") Long villeDepartId,
			@RequestParam("ville_arrive_id") Long villeArriveId, @RequestParam("ville_escale_id") Long villeEscaleId,
			@RequestParam("date_depart") String dateDepart, @RequestParam("date_arrive") String dateArrive,
			@RequestParam("date_retour") String dateRetour, @RequestParam("heur_depart") double heurDepart,
			@RequestParam("heur_arrive") double heurArrive, @RequestParam("heur_retour") double heurRetour,
			@RequestParam("duree_voyage") int dureeVoyage, @RequestParam("duree_repos") int dureeRepos,
			@RequestParam("duree_immob") int dureeImmob, @RequestParam("killometrage") int killometrage)
			throws IOException, ParseException {
		System.out.println(dateDepart);
		Date dDepart = new SimpleDateFormat("yyyy-MM-dd").parse(dateDepart);
		Date dArrive = new SimpleDateFormat("yyyy-MM-dd").parse(dateArrive);
		Date dRetour = new SimpleDateFormat("yyyy-MM-dd").parse(dateRetour);
		Ville villeDepart = villeDao.getVilleById(villeDepartId);
		Ville villeArrive = villeDao.getVilleById(villeArriveId);
		Ville villeEscale = villeDao.getVilleById(villeEscaleId);
		Ligne ligne = new Ligne();
		ligne.setId(id);
		ligne.setVilleDepart(villeDepart);
		ligne.setVilleArrive(villeArrive);
		ligne.setVilleEscale(villeEscale);
		ligne.setDateDepart(dDepart);
		ligne.setHeurDepart(heurDepart);
		ligne.setDateArrive(dArrive);
		ligne.setHeurArrive(heurArrive);
		ligne.setDateRetour(dRetour);
		ligne.setHeurRetour(heurRetour);
		ligne.setDureeVoyage(dureeVoyage);
		ligne.setDureeRepos(dureeRepos);
		ligne.setDureeImmob(dureeImmob);
		ligne.setKilometrage(killometrage);
		ligneDao.updateLigne(ligne);
		response.sendRedirect("/ligne/index");
	}

	@RequestMapping(path = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("ligne", ligneDao.getLigneById(id));
		return "lignes/show";
	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id, HttpServletResponse response) throws IOException {
		ligneDao.deleteLigne(id);
		response.sendRedirect("/ligne/index");
	}

}
