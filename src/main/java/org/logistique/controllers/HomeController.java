package org.logistique.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String index() 
	{
		return "index";
	}
	
	@RequestMapping(path="test", method=RequestMethod.GET)
	public String test() 
	{
		return "test2.jsp";
	}
	
}
