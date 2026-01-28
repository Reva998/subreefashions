package com.flm.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flm.dto.AccountDetailsdto;
import com.flm.dto.BankStatementdto;
import com.flm.serviceinf.AccountServiceInf;
import com.flm.serviceinf.BankServiceInf;
import com.flm.serviceinf.UserServiceInf;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
private	UserServiceInf ui;
	@Autowired
	private AccountServiceInf ai;

	private AccountDetailsdto adt;
	@Autowired
	private BankServiceInf bi;

	private BankStatementdto bdto;
	@GetMapping("/home")
	public String loginPage() {
	    return "loginpage";  // No .jsp, no path prefix
	}
	@PostMapping("/login")
	 public String loginUser(@RequestParam String email,
             @RequestParam String password,HttpSession session,
             Model model) {
Boolean res= ui.getuser(email, password);

// Example logic
if(res) {
	session.setAttribute("email", email);
return "homepage";   // home.jsp
} else {
model.addAttribute("error", "Invalid Email or Password");
return "loginpage";  // login.jsp
}
}
	@GetMapping("/checkbalance")
	public String checkbalance(HttpSession session, Model model)
	{
	 String email = (String) session.getAttribute("email");
	 List<String> accounts=ui.accountlist(email);
	 model.addAttribute("accounts",accounts);
	 return "balancepage";
	 
}
	@PostMapping("/getbalance")
	public String getbalance(HttpSession session,HttpServletRequest hr,Model mod)
	{
		String accno=hr.getParameter("accountnumber");
		int res=ai.checkbal(accno);
		mod.addAttribute("accno",accno);
		mod.addAttribute("res",res);
		return"showbalance";
	}
	@GetMapping("/homepage")
	public String homepage()
	{
		return "homepage";
	}
	@GetMapping("/addaccount")
	public String addaccount()
{
		return "accountadd";
		}
	@PostMapping("/saveaccount")
	public String saveaccount(HttpServletRequest hr, Model mod) {

	    String accno = hr.getParameter("accountnumber");
	    String ifsc = hr.getParameter("ifsc");
	    String bankname = hr.getParameter("bank");
	    String branch = hr.getParameter("branch");

	    // Validate whether account can be added
	    adt = ai.getAccount(accno, ifsc, bankname, branch);

	    if (adt != null) {
	        boolean flag = ai.addAccount(accno);

	        if (flag) {
	            mod.addAttribute("msg", "Account added successfully");
	        } else {
	            mod.addAttribute("msg", "Sorry, issue in adding account");
	        }
	    } else {
	        mod.addAttribute("msg", "Invalid account details");
	    }

	    return "addaccountresult";  // <-- JSP to show message
	}
	@GetMapping("/myaccount")
	public String myaccount(HttpSession session,Model mod)
	{
		String email=(String) session.getAttribute("email");
		List<AccountDetailsdto> adlist=ui.listaccount(email);
		mod.addAttribute("adlist",adlist);
		return "showmy";
	}
	@GetMapping("/transfer")
	public String transfer()
	{
		return "paymentpage";
	}
	@PostMapping("/paypage")
	public String paypage(HttpServletRequest hr,Model mod)

	{
		// Generate random Transaction ID
	    String tid = "TXN" + (int)(Math.random() * 1000000000);

	    // Current Date & Time
	    LocalDate tdate = LocalDate.now();
	    String ttd = LocalDateTime.now().format(
	            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
	    );

		String accno=hr.getParameter("account_number");
		String upi=hr.getParameter("upi_id");
		String supi=hr.getParameter("sender_upi");
		int am=Integer.parseInt(hr.getParameter("amount"));
		int balance=(ai.checkbal(accno)-am);
		bdto=new BankStatementdto(tid,accno,upi,supi,am,tdate,balance);
		Boolean boo=bi.addtrans(bdto);
		if(boo)
		{
			mod.addAttribute("tid",tid);
			mod.addAttribute("upi",upi);
			mod.addAttribute("supi",supi);
			mod.addAttribute("am",am);
			mod.addAttribute("ttd",ttd);
			 mod.addAttribute("msg", "Payment Done successfully");
		}else
		{
			mod.addAttribute("tid",tid);
			mod.addAttribute("upi",upi);
			mod.addAttribute("supi",supi);
			mod.addAttribute("am",am);
			mod.addAttribute("ttd",ttd);
			 mod.addAttribute("msg", "Sorry,Payment failed");
		}
		return"completepayment";
	}
	@GetMapping("/statement")
	public String statement(HttpSession session,Model mod)
	{
		String email=(String)session.getAttribute("email");
		 List<String> accounts=ui.accountlist(email);
		 mod.addAttribute("accounts",accounts);
		 return "statepage";
	}
	@PostMapping("/getstatement")
	public String getstatement(HttpServletRequest hr,Model mod)
	{
		String accno=hr.getParameter("accountnumber");
		List<BankStatementdto> bs= bi.getStatement(accno);
		mod.addAttribute("statementlist",bs);
		return "showstate";
	}
	@GetMapping("/logout")
	public String logout()
	{
		return "redirect:/home";
	}
	}

