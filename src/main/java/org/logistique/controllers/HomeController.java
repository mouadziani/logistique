package org.logistique.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.logistique.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Transactional
public class HomeController {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String index() 
	{
		entityManager.persist(new User("Testststs"));
		return "index";
	}
	
	@RequestMapping(path="test", method=RequestMethod.GET)
	public String test() 
	{
		return "myFile";
	}
	
}
