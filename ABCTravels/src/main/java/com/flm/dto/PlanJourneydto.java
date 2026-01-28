package com.flm.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.flm.model.Busdetails;
import com.flm.model.UserRegistration;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class PlanJourneydto {
	
	private  String bookingid;
	private String source;
	private String destination;
	private LocalDate date;
	private String day;
	private LocalTime time;
	private String status;
	private int passangers;
	 // this will create a 'user_id' column in the journey table
    private UserRegistrationdto user;
	 public PlanJourneydto(String bookingid, String source, String destination, LocalDate date, String day,
			LocalTime time, String status,int passangers) {
		super();
		this.bookingid = bookingid;
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.day = day;
		this.time = time;
		this.status = status;
		this.passangers=passangers;
	}
	// Foreign key column in JourneyDetails table
	private Busdetailsdto bus;
	public PlanJourneydto(String source, String destination, LocalDate date, String day, LocalTime time,
			String status, UserRegistrationdto user, Busdetailsdto bus,int passangers) {
		super();
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.day = day;
		this.time = time;
		this.status = status;
		this.user = user;
		this.bus = bus;
		this.passangers=passangers;
	}
	public PlanJourneydto(String bookingid, String source, String destination, LocalDate date, String day,
			LocalTime time, String status, UserRegistrationdto user, Busdetailsdto bus,int passangers) {
		super();
		this.bookingid = bookingid;
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.day = day;
		this.time = time;
		this.status = status;
		this.user = user;
		this.bus = bus;
		this.passangers=passangers;
	}
	public int getPassangers() {
		return passangers;
	}
	public void setPassangers(int passangers) {
		this.passangers = passangers;
	}
	
	@Override
	public String toString() {
		return "PlanJourneydto [bookingid=" + bookingid + ", source=" + source + ", destination=" + destination
				+ ", date=" + date + ", day=" + day + ", time=" + time + ", status=" + status + ", passangers="
				+ passangers + ", user=" + user + ", bus=" + bus + ", totalamount=" + totalamount + ", paymentstatus="
				+ paymentstatus + "]";
	}
	public PlanJourneydto() {
		super();
	}
	
	public String getBookingid() {
		return bookingid;
	}
	public void setBookingid(String bookingid) {
		this.bookingid = bookingid;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public UserRegistrationdto getUser() {
		return user;
	}
	public void setUser(UserRegistrationdto user) {
		this.user = user;
	}
	public Busdetailsdto getBus() {
		return bus;
	}
	public void setBus(Busdetailsdto bus) {
		this.bus = bus;
	}
	private int totalamount;
	private String paymentstatus;
	public PlanJourneydto(String source, String destination, LocalDate date, String day, LocalTime time,
			int passangers, UserRegistrationdto user, Busdetailsdto bus) {
		super();
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.day = day;
		this.time = time;
		this.passangers = passangers;
		this.user = user;
		this.bus = bus;
	}
	public PlanJourneydto(String bookingid, String source, String destination, LocalDate date, String day,
			LocalTime time, String status, int passangers, UserRegistrationdto user, Busdetailsdto bus, int totalamount,
			String paymentstatus) {
		super();
		this.bookingid = bookingid;
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.day = day;
		this.time = time;
		this.status = status;
		this.passangers = passangers;
		this.user = user;
		this.bus = bus;
		this.totalamount = totalamount;
		this.paymentstatus = paymentstatus;
	}
	public PlanJourneydto(String source, String destination, LocalDate date, String day, LocalTime time, String status,
			int passangers, UserRegistrationdto user, Busdetailsdto bus, int totalamount, String paymentstatus) {
		super();
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.day = day;
		this.time = time;
		this.status = status;
		this.passangers = passangers;
		this.user = user;
		this.bus = bus;
		this.totalamount = totalamount;
		this.paymentstatus = paymentstatus;
	}
	public int getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(int totalamount) {
		this.totalamount = totalamount;
	}
	public String getPaymentstatus() {
		return paymentstatus;
	}
	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}
}
