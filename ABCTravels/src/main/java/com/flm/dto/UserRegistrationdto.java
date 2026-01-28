package com.flm.dto;

public class UserRegistrationdto {
private String userid;
private String firstname;
private String secondname;
private String phone;
private String gender;
private String email;
private String  password;
private int failedcouts;
private String status;
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
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
public int getFailedcouts() {
	return failedcouts;
}
public void setFailedcouts(int failedcouts) {
	this.failedcouts = failedcouts;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public UserRegistrationdto(String userid, String firstname, String secondname, String phone, String gender,
		String email, String password, int failedcouts, String status) {
	super();
	this.userid = userid;
	this.firstname = firstname;
	this.secondname = secondname;
	this.phone = phone;
	this.gender = gender;
	this.email = email;
	this.password = password;
	this.failedcouts = failedcouts;
	this.status = status;
}
@Override
public String toString() {
	return "UserRegestrationdto [userid=" + userid + ", firstname=" + firstname + ", secondname=" + secondname
			+ ", phone=" + phone + ", gender=" + gender + ", email=" + email + ", password=" + password
			+ ", failedcouts=" + failedcouts + ", status=" + status + "]";
}
public UserRegistrationdto() {
	super();
}
public UserRegistrationdto(String firstname, String secondname, String phone, String gender, String email,
		String password, int failedcouts, String status) {
	super();
	this.firstname = firstname;
	this.secondname = secondname;
	this.phone = phone;
	this.gender = gender;
	this.email = email;
	this.password = password;
	this.failedcouts = failedcouts;
	this.status = status;
}
}
