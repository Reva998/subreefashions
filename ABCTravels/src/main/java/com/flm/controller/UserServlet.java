package com.flm.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flm.dto.UserRegistrationdto;
import com.flm.model.UserRegistration;
import com.flm.serviceImp.UserService;

import jakarta.servlet.http.HttpServletRequest;



@Controller
public class UserServlet {
@Autowired
	private UserService us;

	private UserRegistrationdto ud;
	
@GetMapping("/userpage")
public String users()
{
	return "userpage";
}
@GetMapping("/showuser")
public String showuser(Model mod)
{
	
	List<UserRegistrationdto> lst=us.getAllUsers();
	mod.addAttribute("lst",lst);
	return "showuser";
	
}
@GetMapping("/savepage")
public String savepage()
{
	return "savepage";
}
@PostMapping("/saveuser")
public String saveuser(HttpServletRequest hr)

{
	String fn=hr.getParameter("firstname");
	String sn=hr.getParameter("secondname");
	String phone =hr.getParameter("phone");
	String gend = hr.getParameter("gender");// Assumes format is yyyy-MM-dd
	String em = hr.getParameter("email");
	String ps = hr.getParameter("password");
	int fc =Integer.parseInt( hr.getParameter("failedcount"));
	String status = hr.getParameter("status");
    ud=new UserRegistrationdto(fn,sn,phone,gend,em,ps,fc,status);
   Boolean row= us.saveUser(ud);
   if(row==true)
   {
	   return "usersuccess";
   }else
	   
	return "notsuccess";
	

	
}
@GetMapping("/search")
public String search()
{
	return "search";
}
@PostMapping("/getone")
public String getone(HttpServletRequest hr, Model mod) {
	String id=hr.getParameter("userid");
    ud = us.getUser(id);
    mod.addAttribute("ud", ud);
    return "oneuser";
}
@GetMapping("/editpage")
public String editpage(HttpServletRequest hr,Model mod)
{
	String id=hr.getParameter("userid");
	ud=us.getUser(id);
	if(ud!=null)
	{
		/*String fn=ud.getFirstname();
		String sn=ud.getSecondname();
		String phone =ud.getPhone();
		String gend = ud.getGender();// Assumes format is yyyy-MM-dd
		String em = ud.getEmail();
		String ps = ud.getPassword();
		String fc =String.valueOf(ud.getFailedcouts());
		String status = ud.getStatus();*/
		mod.addAttribute("ud",ud);
		return "editpage";
	}
	  
	  
	else
	{
		return "notsuccess";
	}
}

@PostMapping("/edituser")
public String edituser(HttpServletRequest hr)

{
	String id=hr.getParameter("userid");
	String fn=hr.getParameter("firstname");
	String sn=hr.getParameter("secondname");
	String phone =hr.getParameter("phone");
	String gend = hr.getParameter("gender");// Assumes format is yyyy-MM-dd
	String em = hr.getParameter("email");
	String ps = hr.getParameter("password");
	int fc =Integer.parseInt( hr.getParameter("failedcount"));
	String status = hr.getParameter("status");
    ud=new UserRegistrationdto(fn,sn,phone,gend,em,ps,fc,status);
   Boolean row= us.editUser(id,ud);
   if(row==true)
   {
	   return "usersuccess";
   }else
	   
	return "notsuccess";

}


@PostMapping("/deleteuser")
public String deleteuser(HttpServletRequest hr)
{
	String id=hr.getParameter("id");
	us.deleteUser(id);
	return "redirect:/showuser";
	
}
}
