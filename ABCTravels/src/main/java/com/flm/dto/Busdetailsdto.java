package com.flm.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class Busdetailsdto {
	private String busid;
	private String source;
	private String destination;
	private LocalDate date;
	private String day;
	private LocalTime arrivaltime;
	private LocalTime depaturetime;
	private int vaccancies;
	private int amount;
	public Busdetailsdto(String source, String destination, LocalDate date, String day, LocalTime arrivaltime,
			LocalTime depaturetime, int vaccancies, int amount) {
		super();
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.day = day;
		this.arrivaltime = arrivaltime;
		this.depaturetime = depaturetime;
		this.vaccancies = vaccancies;
		this.amount = amount;
	}
	public Busdetailsdto(String busid, String source, String destination, LocalDate date, String day,
			LocalTime arrivaltime, LocalTime depaturetime, int vaccancies, int amount) {
		super();
		this.busid = busid;
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.day = day;
		this.arrivaltime = arrivaltime;
		this.depaturetime = depaturetime;
		this.vaccancies = vaccancies;
		this.amount = amount;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Busdetailsdto(String source, String destination, LocalDate date, String day, LocalTime arrivaltime,
			LocalTime depaturetime, int vaccancies) {
		super();
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.day = day;
		this.arrivaltime = arrivaltime;
		this.depaturetime = depaturetime;
		this.vaccancies = vaccancies;
	}
	public Busdetailsdto() {
		super();
	}
	public Busdetailsdto(String busid, String source, String destination, LocalDate date, String day,
			LocalTime arrivaltime, LocalTime depaturetime, int vaccancies) {
		super();
		this.busid = busid;
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.day = day;
		this.arrivaltime = arrivaltime;
		this.depaturetime = depaturetime;
		this.vaccancies = vaccancies;
	}
	@Override
	public String toString() {
		return "Busdetailsdto [busid=" + busid + ", source=" + source + ", destination=" + destination + ", date="
				+ date + ", day=" + day + ", arrivaltime=" + arrivaltime + ", depaturetime=" + depaturetime
				+ ", vaccancies=" + vaccancies + ", amount=" + amount + "]";
	}
	public String getBusid() {
		return busid;
	}
	public void setBusid(String busid) {
		this.busid = busid;
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
	public LocalTime getArrivaltime() {
		return arrivaltime;
	}
	public void setArrivaltime(LocalTime arrivaltime) {
		this.arrivaltime = arrivaltime;
	}
	public LocalTime getDepaturetime() {
		return depaturetime;
	}
	public void setDepaturetime(LocalTime depaturetime) {
		this.depaturetime = depaturetime;
	}
	public int getVaccancies() {
		return vaccancies;
	}
	public void setVaccancies(int vaccancies) {
		this.vaccancies = vaccancies;
	}
}
