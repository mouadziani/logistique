package org.logistique.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.logistique.dao.IAutoCarDao;
import org.logistique.entities.AutoCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("autocar")
public class AutoCarController {

	@Autowired
	private IAutoCarDao autoCarDao;

	@RequestMapping(path = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("autoCars", autoCarDao.getAll());
		return "autocars/index";
	}

	@RequestMapping(path = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		return "autocars/create";
	}

	@RequestMapping(path = "/store", method = RequestMethod.POST)
	public void store(HttpServletResponse response, 
						@RequestParam("matricule") String matricule, 
						@RequestParam("designation") String designation,
						@RequestParam("descriptionPanne") String descriptionPanne, 
						@RequestParam("duree") double duree, 
						@RequestParam(value="statut", required = false) String statut) throws IOException 
	{
		AutoCar autoCar = new AutoCar();
		autoCar.setMatricule(matricule);
		autoCar.setDescriptionPanne(descriptionPanne);
		autoCar.setDesignation(designation);
		autoCar.setDuree(duree);
		autoCar.setStatut((statut == null));
		autoCarDao.addAutoCar(autoCar);
		response.sendRedirect("/autocar/index");
	}

	@RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("autocar", autoCarDao.getAutoCarById(id));
		return "autocars/edit";
	}

	@RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable Long id, HttpServletResponse response, 
			@RequestParam("matricule") String matricule, 
			@RequestParam("designation") String designation,
			@RequestParam("descriptionPanne") String descriptionPanne, 
			@RequestParam("duree") double duree, 
			@RequestParam(value="statut", required = false) String statut) throws IOException 
	{
		AutoCar autoCar = new AutoCar();
		autoCar.setId(id);
		autoCar.setMatricule(matricule);
		autoCar.setDescriptionPanne(descriptionPanne);
		autoCar.setDesignation(designation);
		autoCar.setDuree(duree);
		autoCar.setStatut((statut == null));
		autoCarDao.updateAutoCar(autoCar);
		response.sendRedirect("/autocar/index");
	}

	@RequestMapping(path = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable Long id, Model model) 
	{
		model.addAttribute("autoCar", autoCarDao.getAutoCarById(id));
		return "autocars/show";
	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id, HttpServletResponse response) throws IOException 
	{
		autoCarDao.deleteAutoCar(id);
		response.sendRedirect("/autocar/index");
	}

}
