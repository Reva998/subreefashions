package com.flm.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.flm.dto.Busdetailsdto;
import com.flm.dto.UserRegistrationdto;
import com.flm.repo.BusRepo;
import com.flm.serviceImp.BusService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BusServlet {
@Autowired
private BusService bs;
@Autowired
private BusRepo br;
private Busdetailsdto bd;
@GetMapping("/buspage")
public String bus()
{
	return "buspage";
}
@GetMapping("/showbus")
public String showbus(Model mod)
{
	
	List<Busdetailsdto> lst=bs.getAllBus();
	mod.addAttribute("lst",lst);
	return "showbus";
	
}
@GetMapping("/savebuspage")
public String savepage()
{
	return "savebuspage";
}
@PostMapping("/savebus")
public String saveuser(HttpServletRequest hr)

{
	String src=hr.getParameter("source");
	String  dst =hr.getParameter("destination");
	LocalDate date = LocalDate.parse(hr.getParameter("date"));
	String day =  hr.getParameter("day");// Assumes format is yyyy-MM-dd
	LocalTime ar = LocalTime.parse(hr.getParameter("arrivaltime"));
	LocalTime dp = LocalTime.parse(hr.getParameter("depaturetime"));
	int vacc =Integer.parseInt( hr.getParameter("vaccancies"));
	int amt=Integer.parseInt(hr.getParameter("amount"));
    bd=new Busdetailsdto(src,dst,date,day,ar,dp,vacc,amt);
   Boolean row= bs.saveBus(bd);
   if(row==true)
   {
	   return "bussuccess";
   }else
	   
	return "notsuccess";
	

	
}
@GetMapping("/searchbus")
public String search()
{
	return "searchbus";
}
@PostMapping("/getonebus")
public String getone(HttpServletRequest hr, Model mod) {
	String id=hr.getParameter("busid");
    bd = bs.getBus(id);
    mod.addAttribute("ud", bd);
    return "onebus";
}@GetMapping("/editbus")
public String edb()
{
	return "editbus";
}
@PostMapping("/editbuspage")
public String editpage(HttpServletRequest hr,Model mod)
{
	String id=hr.getParameter("busid");
	bd=bs.getBus(id);
	if(bd!=null)
	{
		/*String fn=ud.getFirstname();
		String sn=ud.getSecondname();
		String phone =ud.getPhone();
		String gend = ud.getGender();// Assumes format is yyyy-MM-dd
		String em = ud.getEmail();
		String ps = ud.getPassword();
		String fc =String.valueOf(ud.getFailedcouts());
		String status = ud.getStatus();*/
		mod.addAttribute("ud",bd);
		return "editbuspage";
	}
	  
	  
	else
	{
		return "notsuccess";
	}
}

@PostMapping("/editbus")
public String edituser(HttpServletRequest hr)

{
	String id=hr.getParameter("busid");
	String src=hr.getParameter("source");
	String  dst =hr.getParameter("destination");
	LocalDate date = LocalDate.parse(hr.getParameter("date"));
	String day =  hr.getParameter("day");// Assumes format is yyyy-MM-dd
	LocalTime ar = LocalTime.parse(hr.getParameter("arrivaltime"));
	LocalTime dp = LocalTime.parse(hr.getParameter("depaturetime"));
	int vacc =Integer.parseInt( hr.getParameter("vaccancies"));
	int amt=Integer.parseInt(hr.getParameter("amount"));
    bd=new Busdetailsdto(src,dst,date,day,ar,dp,vacc,amt);
	 
   Boolean row= bs.editBus(id, bd);
   if(row==true)
   {
	   return "bussuccess";
   }else
	   
	return "notsuccess";

}

@GetMapping("/deletebuspage")
public String deletp()
{
	return "deletebuspage";
}
@PostMapping("/deleteonebus")
public String deleteone(HttpServletRequest hr, Model mod) {
	String id=hr.getParameter("busid");
    bd = bs.getBus(id);
    mod.addAttribute("ud", bd);
    return "deleteonebus";
}
@PostMapping("/deletebus")
public String deleteuser(HttpServletRequest hr)
{
	String id=hr.getParameter("id");
	bs.deleteBus(id);
	return "redirect:/showbus";
	
}
@PostMapping("/seats")
public String seats(HttpServletRequest hr,Model mod)
{
	String bid=hr.getParameter("busid");
	 bd = bs.getBus(bid);
	 mod.addAttribute("bd",bd);
	return "seatspage";
	}
}


