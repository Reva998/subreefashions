package com.flm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.flm.entity.Items;
import com.flm.model.ItemsModel;
import com.flm.service.ItemsImp;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class Itemcont {

	private Items it;

	private ItemsModel im;
	@Autowired
	private ItemsImp imp;
	@GetMapping("/")
	public String home()
	{
		return "home";
	}
@GetMapping("/addpro")
public String addpro()
{
return "addpro";	
}
@PostMapping("/savepro")
public String savepro(HttpServletRequest hr)
{
	int cd= Integer.parseInt(hr.getParameter("code"));
	String name=hr.getParameter("proname");
	int rate=Integer.parseInt(hr.getParameter("rate"));
	float gst=Float.parseFloat(hr.getParameter("gst"));
	int tq= Integer.parseInt(hr.getParameter("tq"));
	String supp=hr.getParameter("supplier");
	String supp_add=hr.getParameter("supp_add");
	int qp=Integer.parseInt(hr.getParameter("qp"));
	im= new ItemsModel(cd,name,rate,gst,tq,supp,supp_add,qp);
	imp.addpro(im);
	return "redirect:/showall";
}
@GetMapping("/showall")
public String showall(Model mod)
{
	List<ItemsModel> lst=imp.getall();
	mod.addAttribute("lst",lst);
	return "showall";
}
@GetMapping("/searchpro")
public String searchpro()
{
	return "searchpro";
}
@PostMapping("/search")
public String search(HttpServletRequest hr, Model model) {
    // Reset attributes every time
    model.addAttribute("im", null);
    model.addAttribute("notfound", false);

    int cd;
    try {
        cd = Integer.parseInt(hr.getParameter("code"));
    } catch (NumberFormatException e) {
        model.addAttribute("notfound", true);
        return "searchpro";
    }

    ItemsModel im = imp.getpro(cd);

    if (im != null) {
        model.addAttribute("im", im);
    } else {
        model.addAttribute("notfound", true);
    }

    // Keep last searched code in input box
    model.addAttribute("lastCode", hr.getParameter("code"));

    return "searchpro";
}
@PostMapping("/search1")
public String search1(HttpServletRequest hr, Model model) {
    // Reset attributes every time
    model.addAttribute("im", null);
    model.addAttribute("notfound", false);

    int cd;
    try {
        cd = Integer.parseInt(hr.getParameter("code"));
    } catch (NumberFormatException e) {
        model.addAttribute("notfound", true);
        return "billpage";
    }

    ItemsModel im = imp.getpro(cd);

    if (im != null) {
        model.addAttribute("im", im);
    } else {
        model.addAttribute("notfound", true);
    }

    // Keep last searched code in input box
    model.addAttribute("lastCode", hr.getParameter("code"));

    return "billpage";
}

@GetMapping("/bill")
public String bill()
{
	return "billpage";
}

@PostMapping("/addqun")
public String addQuantity(HttpServletRequest request, Model mod) {
    int code = Integer.parseInt(request.getParameter("code"));
    int quantity = Integer.parseInt(request.getParameter("qun"));

    ItemsModel im = imp.getpro(code);

    // Calculate total with GST
    float subtotal = im.getRate() * quantity;
    float gstAmount = subtotal * im.getGst() / 100;
    float total=subtotal+gstAmount;

    mod.addAttribute("im", im);
    mod.addAttribute("tot", total);
    mod.addAttribute("gst", gstAmount);
mod.addAttribute("qu",quantity);
    return "billpage"; // forward (not redirect)
}
@PostMapping("/addbill")
public String addbill(HttpServletRequest hr, Model mod, HttpSession session) {
    int code = Integer.parseInt(hr.getParameter("code"));
    String pname = hr.getParameter("proname");
    float rateFloat = Float.parseFloat(hr.getParameter("rate"));
    int rate = (int) Math.round(rateFloat);  // rounds 40.8 → 41
    int qun = Integer.parseInt(hr.getParameter("quan"));
    float tgst = Float.parseFloat(hr.getParameter("totgst"));
    float total = Float.parseFloat(hr.getParameter("tot"));  
    float gst = Float.parseFloat(hr.getParameter("gst"));

    // Use List<Object[]> to hold [item, quantity, total]
    List<Object[]> billList = (List<Object[]>) session.getAttribute("billList");
    if (billList == null) {
        billList = new ArrayList<>();
    }

    ItemsModel item = new ItemsModel();
    item.setCode(code);
    item.setProname(pname);
    item.setRate(rate);
    item.setGst(tgst);

    // Add item, quantity, total to list
    billList.add(new Object[] { item, qun, total });

    // Store updated list in session
    session.setAttribute("billList", billList);

    // --- Calculate totals ---
    float totalBeforeGST = 0;
    for (Object[] obj : billList) {
        ItemsModel i = (ItemsModel) obj[0];
        int quantity = (int) obj[1];
        totalBeforeGST += i.getRate() * quantity;
    }
    float totalGST = totalBeforeGST * (gst / 100);
    float grandTotal = totalBeforeGST + totalGST;

    // Send to JSP
    mod.addAttribute("items", billList);
    mod.addAttribute("gstPercent", gst);
    mod.addAttribute("totalBeforeGST", totalBeforeGST);
    mod.addAttribute("totalGST", totalGST);
    mod.addAttribute("grandTotal", grandTotal);

    return "billpage";
}
@GetMapping("/clearbill")
public String clearbill(HttpSession session, Model model) {
    // Remove or clear the bill list
    session.removeAttribute("billList"); // removes old bill list
    // Optionally, reset totals
    model.addAttribute("items", new ArrayList<>()); 
    model.addAttribute("totalBeforeGST", 0f);
    model.addAttribute("totalGST", 0f);
    model.addAttribute("grandTotal", 0f);
    model.addAttribute("gstPercent", 0f);

    return "billpage"; // forward to the JSP
}
@PostMapping("billpay")
public String billpay(HttpServletRequest hr, Model mod, HttpSession session) {
    String status = hr.getParameter("paymentstatus");

    // Get bill list from session
    List<Object[]> billList = (List<Object[]>) session.getAttribute("billList");
    if (billList == null || billList.isEmpty()) {
        mod.addAttribute("status", "No items to print!");
        return "printbill";
    }

    // --- Calculate totals for all products ---
    float totalBeforeGST = 0;
    float tgst = 0;
    
    for (Object[] obj : billList) {
        ItemsModel i = (ItemsModel) obj[0];
        int quantity = (int) obj[1];
        totalBeforeGST += i.getRate() * quantity;
        tgst = i.getGst();  // assuming same GST for all items
    }
    float totalGST = totalBeforeGST * (tgst / 100);
    float grandTotal = totalBeforeGST + totalGST;

    // Update stock **summing quantities per product**
    if (status.equalsIgnoreCase("paid")) {
        List<Integer> processedCodes = new ArrayList<>(); // to avoid updating same product twice
        for (Object[] obj : billList) {
            ItemsModel i = (ItemsModel) obj[0];
            int quantity = (int) obj[1];
            int code = i.getCode();

            if (!processedCodes.contains(code)) {
                // Sum all quantities of this product in the bill
                int totalQuantity = 0;
                for (Object[] o : billList) {
                    ItemsModel imTemp = (ItemsModel) o[0];
                    if (imTemp.getCode() == code) {
                        totalQuantity += (int) o[1];
                    }
                }

                // Update stock once with total quantity
                imp.updatequn(totalQuantity, code);
                processedCodes.add(code); // mark as updated
            }
        }
    }

    // Send to JSP
    mod.addAttribute("items", billList);
    mod.addAttribute("gstPercent", tgst);
    mod.addAttribute("totalBeforeGST", totalBeforeGST);
    mod.addAttribute("totalGST", totalGST);
    mod.addAttribute("grandTotal", grandTotal);
    mod.addAttribute("status", status);

    return "printbill";
}


@GetMapping("/deleteFromBill")
public String deleteFromBill(HttpServletRequest hr, HttpSession session, Model model) {
    int ind = Integer.parseInt(hr.getParameter("index"));
    List<Object[]> billList = (List<Object[]>) session.getAttribute("billList");

    if (billList != null && ind >= 0 && ind < billList.size()) {
        billList.remove(ind); // Remove the selected product
    }

    // Recalculate totals
    float totalBeforeGST = 0f;
    float gstPercent = 0f;
    if (billList != null && !billList.isEmpty()) {
        for (Object[] obj : billList) {
            ItemsModel item = (ItemsModel) obj[0];
            int quantity = (int) obj[1];
            totalBeforeGST += item.getRate() * quantity;
            gstPercent = item.getGst(); // Assuming GST same for all items
        }
    }

    float totalGST = totalBeforeGST * (gstPercent / 100);
    float grandTotal = totalBeforeGST + totalGST;

    // Send updated list and totals back to JSP
    model.addAttribute("items", billList);
    model.addAttribute("totalBeforeGST", totalBeforeGST);
    model.addAttribute("gstPercent", gstPercent);
    model.addAttribute("totalGST", totalGST);
    model.addAttribute("grandTotal", grandTotal);

    return "billpage"; // forward to the same JSP
}

}




