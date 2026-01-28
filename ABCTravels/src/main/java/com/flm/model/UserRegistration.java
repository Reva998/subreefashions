package com.flm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;

@Entity
public class UserRegistration {
	@Id
	
	private String userid;
	
public UserRegistration(String userid, String firstname, String secondname, String phone, String gender, String email,
			String password, int failedcount, String status) {
		super();
		this.userid = userid;
		this.firstname = firstname;
		this.secondname = secondname;
		this.phone = phone;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.failedcount = failedcount;
		this.status = status;
	}
public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
private String firstname;
private String secondname;
private String phone;
private String gender;
private String email;
private String password;
private int failedcount;
private String status;
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getSecondname() {
	return secondname;
}
public void setSecondname(String secondname) {
	this.secondname = secondname;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getFailedcount() {
	return failedcount;
}
public void setFailedcount(int failedcount) {
	this.failedcount = failedcount;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public UserRegistration(String firstname, String secondname, String phone, String gender, String email, String password,
		int failedcount, String status) {
	super();
	this.firstname = firstname;
	this.secondname = secondname;
	this.phone = phone;
	this.gender = gender;
	this.email = email;
	this.password = password;
	this.failedcount = failedcount;
	this.status = status;
}
public UserRegistration() {
	super();
}
@Override
public String toString() {
	return "UserRegistration [userid=" + userid + ", firstname=" + firstname + ", secondname=" + secondname + ", phone=" + phone
			+ ", gender=" + gender + ", email=" + email + ", password=" + password + ", failedcount=" + failedcount
			+ ", status=" + status + "]";
}
@PrePersist
public void generateid() {
    // Generate a short random bus ID using UUID
    this.userid = "USER-" + UUID.randomUUID().toString().substring(0, 5).toUpperCase();
}
@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
private List<PlanJourney> journeys = new ArrayList<>();

public List<PlanJourney> getJourneys() {
	return journeys;
}
public void setJourneys(List<PlanJourney> journeys) {
	this.journeys = journeys;
}


}
