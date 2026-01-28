package com.flm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flm.dto.Logindto;
import com.flm.serviceImp.LoginService;


import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginServlet {

	private LoginService log;

	private Logindto logdto;
@RequestMapping("/login")
public String login()
{
	return "loginpage";
	
}
@Controller
public class LoginController {

    @Autowired
    private LoginService log;

    @PostMapping("/validate")
    public String validateUser(@RequestParam("email") String email,
                               @RequestParam("password") String password,
                               Model mod) {
        Logindto logdto = new Logindto(email, password);
        boolean isValid = log.validateUser(logdto);

        if (isValid) {
            return "homepage";  // Navigate to home page
        } else {
            mod.addAttribute("error", "Invalid email or password");  // Set the error message
            return "loginpage";  // Forward to the login page (WEB-INF/pages/loginpage.jsp)
        }
    }
}

}
