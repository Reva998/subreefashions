package com.flm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.flm.serviceImp.LoginService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
@Autowired
private LoginService ls;
	@GetMapping("/home")
	public String loginPage() {
	    return "loginpage";  // No .jsp, no path prefix
	}
	
	@GetMapping("/logout")
	public String loginout() {
	    return "logout";  // No .jsp, no path prefix
	}
	@PostMapping("/log")
	
		public String log(HttpServletRequest hr)
		{
			String email=hr.getParameter("email");
			ls.logout(email);
			return "redirect:/home";
			
		}
	@GetMapping("/homepage")
	public String page() {
	    return "homepage";  // No .jsp, no path prefix
	}
	
	
}