package org.logistique.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.logistique.dao.IChauffeurDao;
import org.logistique.entities.Chauffeur;
import org.logistique.entities.Voyage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("chauffeur")
public class ChauffeurController {

	@Autowired
	private IChauffeurDao chauffeurDao;

	@RequestMapping(path = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("chauffeurs", chauffeurDao.getAll());
		return "chauffeurs/index";
	}

	@RequestMapping(path = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		return "chauffeurs/create";
	}

	@RequestMapping(path = "/store", method = RequestMethod.POST)
	public void store(HttpServletResponse response, @RequestParam("matricule") String matricule, 
						@RequestParam("nom") String nom,
						@RequestParam("prenom") String prenom, 
						@RequestParam("tel") String tel, 
						@RequestParam("adresse") String adresse) throws IOException 
	{
		Chauffeur chauffeur = new Chauffeur();
		chauffeur.setMatricule(matricule);
		chauffeur.setNom(nom);
		chauffeur.setPrenom(prenom);
		chauffeur.setTel(tel);
		chauffeurDao.addChauffeur(chauffeur);
		response.sendRedirect("/chauffeur/index");
	}

	@RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("chauffeur", chauffeurDao.getChauffeurById(id));
		return "chauffeurs/edit";
	}

	@RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable Long id, HttpServletResponse response, 
						@RequestParam("matricule") String matricule, 
						@RequestParam("nom") String nom,
						@RequestParam("prenom") String prenom, 
						@RequestParam("tel") String tel, 
						@RequestParam("adresse") String adresse) throws IOException 
	{
		Chauffeur chauffeur = new Chauffeur();
		chauffeur.setId(id);
		chauffeur.setMatricule(matricule);
		chauffeur.setNom(nom);
		chauffeur.setPrenom(prenom);
		chauffeur.setTel(tel);
		chauffeurDao.updateChauffeur(chauffeur);
		response.sendRedirect("/chauffeur/index");
	}

	@RequestMapping(path = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable Long id, Model model) 
	{
		model.addAttribute("chauffeur", chauffeurDao.getChauffeurById(id));
		model.addAttribute("voyages", chauffeurDao.getVoyagesChauffeur(id));
		return "chauffeurs/show";
	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id, HttpServletResponse response) throws IOException 
	{
		chauffeurDao.deleteChauffeur(id);
		response.sendRedirect("/chauffeur/index");
	}

}
