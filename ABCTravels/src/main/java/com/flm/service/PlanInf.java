package com.flm.service;

import java.util.List;

import com.flm.dto.PlanJourneydto;

public interface PlanInf {
public boolean bookJourney(PlanJourneydto pdto);
public boolean updateBooking(String id,PlanJourneydto pdto);
public void deleteBooking(String id);
public List<PlanJourneydto> getBookingByUser(String id);
public List<PlanJourneydto> getBookingByBus(String id);
public List<PlanJourneydto> getBookingsAll();
public PlanJourneydto getBookingsById(String id);
public boolean updatePassangers(String id,int no);
public boolean conform_payment(String id);
public PlanJourneydto  findBookingsReceipt(String id);
public boolean cancelBooking(String id);
}
