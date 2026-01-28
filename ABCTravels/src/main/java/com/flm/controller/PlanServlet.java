package com.flm.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flm.dto.Busdetailsdto;
import com.flm.dto.PlanJourneydto;
import com.flm.dto.UserRegistrationdto;
import com.flm.repo.PlanRepo;
import com.flm.serviceImp.BusService;
import com.flm.serviceImp.Planservice;
import com.flm.serviceImp.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PlanServlet {
@Autowired
private Planservice ps;
@Autowired
private PlanRepo pr;
private PlanJourneydto pd;
private UserRegistrationdto ud;
private Busdetailsdto bd;

@Autowired
private UserService us;
@Autowired
private BusService bs;

@GetMapping("/bookpage")
public String book()
{
	return "bookpage";
}
@GetMapping("/showbooking")
public String showbooking(Model mod)
{
	
	List<PlanJourneydto> lst=ps.getBookingsAll();
	mod.addAttribute("lst",lst);
	return "showbooking";
	
}
@GetMapping("/savejournpage")
public String savejournpage()
{
	return "savejournpage";
}
@PostMapping("/savejourn")
public String savejourn(HttpServletRequest hr) {
    String src = hr.getParameter("source");
    String dst = hr.getParameter("destination");
    
    // Check if source or destination is null or empty
    if (src == null || src.isEmpty() || dst == null || dst.isEmpty()) {
        return "error: source or destination is missing";
    }

    // Check if date or time is null or empty
    String dateString = hr.getParameter("date");
    if (dateString == null || dateString.isEmpty()) {
        return "error: date is missing";
    }
    LocalDate date = LocalDate.parse(dateString);  // Assumes format is yyyy-MM-dd
    
    String day = hr.getParameter("day");
    if (day == null || day.isEmpty()) {
        return "error: day is missing";
    }

    // Check if time is null or empty
    String timeString = hr.getParameter("time");
    if (timeString == null || timeString.isEmpty()) {
        return "error: time is missing";
    }
    LocalTime time = LocalTime.parse(timeString);
    
    String passString = hr.getParameter("passengers");
    if (passString == null || passString.isEmpty()) {
        return "error: passangers is missing";
    }
    int pass = Integer.parseInt(passString);
    try {
        pass = Integer.parseInt(passString);
    } catch (NumberFormatException e) {
        return "error: invalid passangers value";
    }
    // Ensure user ID and bus ID are present
    String userId = hr.getParameter("userid");
    if (userId == null || userId.isEmpty()) {
        return "error: user ID is missing";
    }
    UserRegistrationdto uid = us.getUser(userId);

    String busId = hr.getParameter("busid");
    if (busId == null || busId.isEmpty()) {
        return "error: bus ID is missing";
    }
    Busdetailsdto bid = bs.getBus(busId);
    
    pd = new PlanJourneydto(src, dst, date, day, time, pass, uid, bid);
    Boolean row = ps.bookJourney(pd);

    if (row == true) {
        return "bookingsuccess";
    } else {
        return "notsuccess";
    }
}

@GetMapping("/searchbooking")
public String searchbooking()
{
	return "searchbooking";
}
@PostMapping("/getonebooking")
public String getBookingById(@RequestParam("bookingid") String bookingid, Model model) {
    System.out.println("Fetching booking with ID: " + bookingid);  // Debugging output
    PlanJourneydto booking = ps.getBookingsById(bookingid);  // Assuming ps is your service class
    if (booking == null) {
        System.out.println("No booking found with ID: " + bookingid);
        model.addAttribute("error", "Booking not found");
    } else {
        model.addAttribute("pd", booking);
    }
    return "onebooking";  // Replace with your view name
}

@GetMapping("/editbookingpage")
public String editbookpage(HttpServletRequest hr,Model mod)
{
	String id=hr.getParameter("bookingid");
	pd=ps.getBookingsById(id);
	if(pd!=null)
	{
		/*String fn=ud.getFirstname();
		String sn=ud.getSecondname();
		String phone =ud.getPhone();
		String gend = ud.getGender();// Assumes format is yyyy-MM-dd
		String em = ud.getEmail();
		String ps = ud.getPassword();
		String fc =String.valueOf(ud.getFailedcouts());
		String status = ud.getStatus();*/
		mod.addAttribute("pd",pd);
		return "editbookingpage";
	}
	  
	  
	else
	{
		return "notsuccess";
	}
}

@PostMapping("/editbooking")
public String editbooking(HttpServletRequest hr)

{
	String id=hr.getParameter("bookingid");
	
	String src=hr.getParameter("source");
	String  dst =hr.getParameter("destination");
	LocalDate date = LocalDate.parse(hr.getParameter("date"));
	String day =  hr.getParameter("day");// Assumes format is yyyy-MM-dd
	LocalTime time = LocalTime.parse(hr.getParameter("time"));
	String status = hr.getParameter("status");
	int pass=Integer.parseInt(hr.getParameter("passangers"));
	UserRegistrationdto uid=us.getUser(hr.getParameter("userid"));
	Busdetailsdto bid=bs.getBus(hr.getParameter("busid"));
	
	
	pd=new PlanJourneydto(id,src,dst,date,day,time,status,uid,bid,pass);
   Boolean row= ps.updateBooking(id, pd);
   if(row==true)
   {
	   return "bookingsuccess";
   }else
	   
	return "notsuccess";

}
@GetMapping("/deletebooking")
public String dl(@RequestParam("bookingid") String bookingId,Model model) 

{
	 System.out.println("Fetching booking with ID: " + bookingId);  // Debugging output
	    PlanJourneydto booking = ps.getBookingsById(bookingId);  // Assuming ps is your service class
	    if (booking == null) {
	        System.out.println("No booking found with ID: " + bookingId);
	        model.addAttribute("error", "Booking not found");
	    } else {
	        
	
	ps.deleteBooking(bookingId);
	    }
	return "redirect:/showbooking";
	    }

@GetMapping("/searchbookingbybusid")
public String searchbookbus()
{
	return "searchbookingbybusid";
}
@PostMapping("/getbookingbybus")
public String getonebusid(HttpServletRequest hr, Model mod) {
	String id=hr.getParameter("bookingid");
  List<PlanJourneydto>  pds = ps.getBookingByBus(id);
    mod.addAttribute("ud", pds);
    return "bookingbyid";
}
@GetMapping("/searchbookingbyuserid")
public String searchbookuser()
{
	return "searchbookingbyuserid";
}
@PostMapping("/getbookingbyuser")
public String getoneuser(HttpServletRequest hr, Model mod) {
	String id=hr.getParameter("bookingid");
  List<PlanJourneydto>  pds = ps.getBookingByUser(id);
    mod.addAttribute("ud", pds);
    return "bookingbyid";
}
@GetMapping("/dopayment")
public String dopayment()
{
	return "searchpaybooking";
}
@PostMapping("/getpaybooking")
public String getb(HttpServletRequest hr, Model mod) {
	String id=hr.getParameter("bookingid");
    pd = ps.getBookingsById(id);
    mod.addAttribute("ud", pd);
    return "onebookingpay";
}
@GetMapping("/confirmpayment")
public String payment(HttpServletRequest hr,Model mod)
{
	String id=hr.getParameter("bookingid");
	mod.addAttribute("ids",id);
	return "confirmpayment";
}
@GetMapping("/payment")
public String pay(@RequestParam("bookingid") String bookingId)
{
	
	boolean flag=ps.conform_payment(bookingId);
	if(flag==true)
	{
		return "successandreceipt";
	}
	else
	{
		return "notsuccess";
	}
}
@GetMapping("/receipt")
public String receipt()
{
	return "searchreceipt";
}
@PostMapping("/getreceiptbooking")
public String getreceipt(HttpServletRequest hr, Model mod) {
	String id=hr.getParameter("bookingid");
    pd = ps.findBookingsReceipt(id);
    mod.addAttribute("ud", pd);
    return "receiptpage";
}
@GetMapping("/cancel")
public String cancelById(@RequestParam("bookingid") String bookingId, Model model) {

    System.out.println("Fetching booking with ID: " + bookingId);
    PlanJourneydto booking = ps.getBookingsById(bookingId);

    String str;
    if (booking == null) {
        System.out.println("No booking found with ID: " + bookingId);
        model.addAttribute("error", "Booking not found");
        str = "notsuccess"; // Or another view name for 'not found'
    } else {
        boolean flag = ps.cancelBooking(bookingId);
        if (flag) {
            str = "cancelbooking";
        } else {
            str = "notsuccess";
        }
    }

    return str;
}

}
