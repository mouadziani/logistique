package org.logistique.controllers.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

	@RequestMapping("/login")
	public String login() 
	{
		return "auth/login";
	}
	
//	@RequestMapping("/")
//	public String index() 
//	{
//		return "dashboard/index";
//	}
}
