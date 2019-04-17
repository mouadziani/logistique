package org.logistique.controllers;

import org.logistique.dao.IChauffeurDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("chauffeur")
public class ChauffeurController {

	@Autowired
	private IChauffeurDao chauffeurDao; 
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String index(Model model)
	{
		model.addAttribute("chauffeurs", chauffeurDao.getAll());
		return "chauffeurs/index";
	}
	
	@RequestMapping(path="/create", method=RequestMethod.GET)
	public String create(Model model)
	{
		return "chauffeurs/create";
	}
	
	@RequestMapping(path="/store", method=RequestMethod.POST)
	public void store(@RequestParam("nom") String nom)
	{
		System.out.println(nom);
		//return "chauffeurs/create";
	}
	
}
