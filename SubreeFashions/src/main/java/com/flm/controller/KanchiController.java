package com.flm.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flm.builder.KanchiBuilder;
import com.flm.dto.Kanchisareesdto;
import com.flm.entity.Kanchisarees;
import com.flm.serviceinf.Kanchiservice;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class KanchiController {
@Autowired
private Kanchiservice ksr;
@Autowired
private KanchiBuilder kb;
private Kanchisarees ks;
private Kanchisareesdto kdto;
@GetMapping("/home1")
public String home()
{
	return "home1";
}
@GetMapping("/save")
public String save()
{
	return "savepage";
}
@PostMapping("/add")
public String add(HttpServletRequest hr)
{
	
	String img=hr.getParameter("imageurl");
	int prc=Integer.parseInt(hr.getParameter("price"));
	String desc=hr.getParameter("desc");
	kdto=new Kanchisareesdto(img,prc,desc);
	ksr.saveImg(kdto);
	return "redirect:/home1";
	
}
@GetMapping("/coll")
public String coll(Model mod)
{
	List<Kanchisareesdto> kldto=ksr.viewAllkanchi();
	mod.addAttribute("kl",kldto);
	return "coll";
}
}
