package com.flm.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.flm.builder.BusBuilder;
import com.flm.builder.PlanBuilder;
import com.flm.builder.UserBuilder;
import com.flm.dto.Busdetailsdto;
import com.flm.dto.PlanJourneydto;
import com.flm.dto.UserRegistrationdto;
import com.flm.model.Busdetails;
import com.flm.model.PlanJourney;
import com.flm.model.UserRegistration;
import com.flm.repo.BusRepo;
import com.flm.repo.PlanRepo;
import com.flm.repo.UserRegistrationRepo;
import com.flm.service.PlanInf;

import jakarta.transaction.Transactional;

@Service
public class Planservice implements PlanInf{

private final PlanRepo pr;

private final PlanBuilder pb;

private PlanJourney pj;

private PlanJourneydto pdto;

private final BusRepo br;

private final BusService bs;

private Busdetailsdto bd;

private UserRegistration ur;

private UserRegistrationdto udto;

private final UserBuilder ub;

private final BusBuilder bb;
private final UserRegistrationRepo urp;
@Autowired
public Planservice(UserBuilder ub, BusService bs, BusRepo br, PlanRepo pr, PlanBuilder pb, BusBuilder bb,UserRegistrationRepo urp) {
    this.ub = ub;   // Spring will inject the UserBuilder here
    System.out.println("UserBuilder injected: " + ub);
    this.bs = bs;
    this.br = br;
    this.pr = pr;
    this.pb = pb;
    this.bb=bb;
    this.urp=urp;
}
@Transactional
	@Override
	public boolean bookJourney(PlanJourneydto pdto) {
		bd=bs.getBus(pdto.getBus().getBusid());
		
		if(bd!=null)
		{
			if((pdto.getDate().isEqual(bd.getDate()))&&(pdto.getDay().equalsIgnoreCase(bd.getDay()))&&(pdto.getTime().equals(bd.getArrivaltime())))
					{
				pj=pb.toEn_save(pdto);
				
			
				if(pj!=null)
				{
					boolean flag=updatePassangers(bd.getBusid(),pdto.getPassangers());
					if(flag==true)
					{
						int sum=bd.getAmount()*pdto.getPassangers();
						String status="booked";
						String paystatus="pending";
						PlanJourney pjr=new PlanJourney(pj.getSource(),pj.getDestination(),pj.getDate(),pj.getDay(),pj.getTime(),status,pj.getPassangers(),pj.getUser(),pj.getBus(),sum,paystatus);
					PlanJourney plj =pr.save(pjr);
						if(plj!=null)
						{
						return true;
						
						}else
						{
							System.out.println("task failed");
							return false;
						}
					}
					else
					{
						System.out.println("NO seats found");
						return false;
					}
				}else
				{
					System.out.println("error in saving");
					return false;
				}
					}else
					{
						System.out.println("wrong date/day/time, please check bus details for date and time");
						return false;
					}
		}else
		{
			System.out.println("such bus with source and destination not found");	
			return false;
		}
		
	}
@Override
public boolean updatePassangers(String id, int no) {
    Busdetailsdto bd = bs.getBus(id);
    if (bd.getVaccancies() >= no) {
    	System.out.println(bd.getVaccancies());
    	System.out.println( no);
        int sum = bd.getVaccancies() - no;
        int row = br.updatevacc(sum, bd.getBusid());
        return row>0;
    } else {
        System.out.println("No seats");
        return false;
    }
}

@Transactional
@Override
public boolean updateBooking(String id, PlanJourneydto pdo) {
    PlanJourneydto pdto = getBookingsById(id);
    if (pdto == null) {
        System.out.println("No such booking id found");
        return false;
    }
    Optional<UserRegistration> optionalUser = urp.findById(pdto.getUser().getUserid());
    Optional<Busdetails> optionalBus = br.findById(pdo.getBus().getBusid());

    if (!optionalUser.isPresent() || !optionalBus.isPresent()) {
        System.out.println("Either user or bus not found in DB.");
        return false;
    }

    UserRegistration user = optionalUser.get();
    Busdetails bus = optionalBus.get();

    if (user == null || bus == null) {
        System.out.println("User or Bus not found!");
        // Don't proceed to update
    }
    System.out.println("User ID: " + user.getUserid());
    System.out.println("Bus ID: " + bus.getBusid());
    System.out.println("Booking ID: " + pdo.getBookingid());
   

    // Check if source, destination, and bus match
    if (pdto.getSource().equalsIgnoreCase(pdo.getSource()) && 
        pdto.getDestination().equalsIgnoreCase(pdo.getDestination()) && 
        pdto.getBus().getBusid() == pdo.getBus().getBusid()) {
        
        // Check if date, day, and time match
        if (pdto.getDate().isEqual(pdo.getDate()) && 
            pdto.getDay().equalsIgnoreCase(pdo.getDay()) && 
            pdto.getTime().equals(pdo.getBus().getArrivaltime())) {
            
            if (pdto.getPassangers() == pdo.getPassangers()) {
                int row = pr.updateBooking(pdo.getSource(), pdo.getDestination(), pdo.getDate(), 
                                           pdo.getDay(), pdo.getTime(), pdo.getStatus(), 
                                          user, bus, 
                                           pdo.getPassangers(), pdo.getBookingid());
                if (row > 0) {
                    System.out.println("Successfully Updated");
                    return true;
                } else {
                    System.out.println("Problem in update");
                    return false;
                }
            } else {
                // Update bus availability
                Busdetailsdto bd = bs.getBus(pdto.getBus().getBusid());
                int sum = bd.getVaccancies() + pdto.getPassangers();
                br.updatevacc(sum, pdto.getBus().getBusid());

                // Update passenger count
                bd = bs.getBus(pdo.getBus().getBusid());
                
                boolean flag = updatePassangers(bd.getBusid(), pdo.getPassangers());
                if (flag) {
                	
                    // Continue with updating the booking
                	  int row = pr.updateBooking(pdo.getSource(), pdo.getDestination(), pdo.getDate(), 
                              pdo.getDay(), pdo.getTime(), pdo.getStatus(), 
                             user, bus, 
                              pdo.getPassangers(), pdo.getBookingid());
                    if (row>0) {
                    	int res=pdo.getPassangers()*pdo.getBus().getAmount();
                        pr.updateAmount(res, pdo.getBookingid());
                        System.out.println("Successfully Updated");
                        return true;
                    } else {
                        System.out.println("Update failed in pr.updateBooking-----");
                        return false;
                    }
                } else {
                    System.out.println("No seats available");
                    return false;
                }
            }
        } else {
            // Check availability based on date/day/time
           List<Busdetails> row= br.findByDateAndDayAndArrivalTime(pdo.getDate(), pdo.getDay(), pdo.getTime());
            if (row != null) {
            	  int rows = pr.updateBooking(pdo.getSource(), pdo.getDestination(), pdo.getDate(), 
                          pdo.getDay(), pdo.getTime(), pdo.getStatus(), 
                         user, bus, 
                          pdo.getPassangers(), pdo.getBookingid());
                System.out.println("Successfully Updated");
                return true;
            } else {
                System.out.println("No date/day/time slot found");
                return false;
            }
        }
    } else {
        // Check availability based on source, destination, and bus
        List<Busdetails> row = br.findBySourceDestinationBus(pdo.getSource(), pdo.getDestination(), pdo.getBus().getBusid());
        if (row != null) {
         pr.updateBooking(pdo.getSource(), pdo.getDestination(), pdo.getDate(), 
                      pdo.getDay(), pdo.getTime(), pdo.getStatus(), 
                     user, bus, 
                      pdo.getPassangers(), pdo.getBookingid());
            System.out.println("Successfully Updated");
            return true;
        } else {
            System.out.println("No source/destination/bus found");
            return false;
        }
    }
}

@Transactional
	@Override
	public void deleteBooking(String id) {
		PlanJourneydto pdto = null;
		pdto=getBookingsById(id);
		if(pdto!=null)
		{
		pr.deleteById(id);
		}
		else
			System.out.println("not found to delete");
		}
		
	

	@Override
	public List<PlanJourneydto> getBookingByUser(String id) {
		List<PlanJourney> ug= pr.findBookingsByUser(id);
		List<PlanJourneydto> uddto=new ArrayList<>();
		for(PlanJourney ugr :ug)
		{// TODO Auto-generated method stub
		uddto.add(pb.toDto(ugr));	
		}
		return uddto;
	}

	@Override
	public List<PlanJourneydto> getBookingByBus(String id) {
		List<PlanJourney> ug= pr.findBookingsByBus(id);
		List<PlanJourneydto> uddto=new ArrayList<>();
		for(PlanJourney ugr :ug)
		{// TODO Auto-generated method stub
		uddto.add(pb.toDto(ugr));	
		}
		return uddto;
	}

	@Override
	public List<PlanJourneydto> getBookingsAll() {
		List<PlanJourney> ug= pr.findAll();
		List<PlanJourneydto> uddto=new ArrayList<>();
		for(PlanJourney ugr :ug)
		{// TODO Auto-generated method stub
		uddto.add(pb.toDto(ugr));	
		}
		return uddto;
	}
	
@Transactional
	@Override
	public PlanJourneydto getBookingsById(String bookingid) {
		System.out.println(bookingid);
		PlanJourney pl=pr.getBookingById(bookingid);
		 if (pl != null && pl.getUser() != null && pl.getBus() != null) {
		
		System.out.println(pl);
	    PlanJourneydto booking = pb.toDto(pl);  // Or however you're fetching the booking
	    return booking;  // Make sure this is not null when a valid ID is passed
	}else
		System.out.println("no ");
		return null;
	}
	


	@Override
	public boolean conform_payment(String id) {
		int row=pr.updatePaymentStatus("paid", id);
		if(row>0)
		{
			return true;
		}else
		{
			return false;
		}
		
		
	}

	@Override
	public PlanJourneydto findBookingsReceipt(String id) {
	pj=pr.findBookingsReceipt(id, "paid");
	if(pj!=null)
	{
		pdto= pb.toDto(pj);
	}else
	{
		System.out.println("no records");
	}
	return pdto;
	
}

	@Override
	public boolean cancelBooking(String id) {
		pdto=getBookingsById(id);
		if(pdto!=null)
		{
			int row=pr.cancelBooking("cancelled",id);
			br.updatevacc((pdto.getPassangers()+pdto.getBus().getVaccancies()), pdto.getBus().getBusid());
			if(row>0)
			{
				return true;
			}else
				return false;
		}else
		{
			System.out.println("no booking found");
		return false;
		}
	}
	public int updateBookingstatus(String st,int amt,String ps,String id)
	{
	int row=pr.updateBookingStatus(st, amt,ps,id);
	return row;
	}
}
