package com.flm.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import com.flm.dto.Busdetailsdto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
@Entity
public class PlanJourney {
	@Id
	private  String bookingid;
	private String source;
	private String destination;
	private LocalDate date;
	private int passangers;
	public int getPassangers() {
		return passangers;
	}
	public void setPassangers(int passangers) {
		this.passangers = passangers;
	}
	

	public PlanJourney(String source, String destination, LocalDate date, String day, LocalTime time, String status,
			UserRegistration user,int passangers) {
		super();
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.day = day;
		this.time = time;
		this.status = status;
		this.user = user;
		this.passangers=passangers;
	}
	@Override
	public String toString() {
		return "PlanJourney [bookingid=" + bookingid + ", source=" + source + ", destination=" + destination + ", date="
				+ date + ", passangers=" + passangers + ", day=" + day + ", time=" + time + ", status=" + status
				+ ", user=" + user + ", bus=" + bus + ", totalamount=" + totalamount + ", paymentstatus="
				+ paymentstatus + "]";
	}
	public PlanJourney() {
		super();
	}
	public PlanJourney(String bookingid, String source, String destination, LocalDate date, String day,
			LocalTime time, String status, UserRegistration user,int passangers) {
		super();
		this.bookingid = bookingid;
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.day = day;
		this.time = time;
		this.status = status;
		this.user = user;
		this.passangers=passangers;
		
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
	public UserRegistration getUser() {
		return user;
	}
	public void setUser(UserRegistration user) {
		this.user = user;
	}
	private String day;
	private LocalTime time;
	private String status;
	@ManyToOne
    @JoinColumn(name = "user_id") // this will create a 'user_id' column in the journey table
    private UserRegistration user;
	@ManyToOne
	@JoinColumn(name = "busid") // Foreign key column in JourneyDetails table
	private Busdetails bus;
	public Busdetails getBus() {
		return bus;
	}
	public void setBus(Busdetails bus) {
		this.bus = bus;
	}
	public PlanJourney(String bookingid, String source, String destination, LocalDate date, String day,
			LocalTime time, String status, UserRegistration user, Busdetails bus,int passangers) {
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
	public PlanJourney(String source, String destination, LocalDate date, int passangers, String day, LocalTime time,
			String status, UserRegistration user, Busdetails bus) {
		super();
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.passangers = passangers;
		this.day = day;
		this.time = time;
		this.status = status;
		this.user = user;
		this.bus = bus;
	}
	@PrePersist
	public void generateid() {
	    // Generate a short random bus ID using UUID
	    this.bookingid = "abc" + UUID.randomUUID().toString().substring(0, 4).toLowerCase();
	}
private int totalamount;
private String paymentstatus;
		// TODO Auto-generated method stub
public int getTotalAmount() {
	return totalamount;
}












public PlanJourney(String source, String destination, LocalDate date, String day, LocalTime time,
		String status, int passangers, UserRegistration user, Busdetails bus, int totalamount, String paymentstatus) {
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
public PlanJourney(String bookingid, String source, String destination, LocalDate date, 
				String day, LocalTime time, String status, int passangers,UserRegistration user, Busdetails bus, int totalamount,
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
public void setTotalamount(int totalamount) {
	this.totalamount = totalamount;
}
public PlanJourney(String source, String destination, LocalDate date,String day, LocalTime time,  int passangers, 
		UserRegistration user, Busdetails bus) {
	super();
	this.source = source;
	this.destination = destination;
	this.date = date;
	this.passangers = passangers;
	this.day = day;
	this.time = time;
	this.user = user;
	this.bus = bus;
}
public String getPaymentstatus() {
	return paymentstatus;
}
public void setPaymentstatus(String paymentstatus) {
	this.paymentstatus = paymentstatus;
}
		
}
