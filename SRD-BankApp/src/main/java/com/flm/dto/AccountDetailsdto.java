package com.flm.dto;

public class AccountDetailsdto {
	
	private String account_number;
	private String username;

	private String ifsc;
	private String upi_id;
	private String bankname;
	private String branch;
	private String phone;
	private String email;
	private String address;
	private int balance;
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public String getUpi_id() {
		return upi_id;
	}
	public void setUpi_id(String upi_id) {
		this.upi_id = upi_id;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public AccountDetailsdto(String account_number, String username, String ifsc, String upi_id, String bankname,
			String branch, String phone, String email, String address, int balance) {
		super();
		this.account_number = account_number;
		this.username = username;
		this.ifsc = ifsc;
		this.upi_id = upi_id;
		this.bankname = bankname;
		this.branch = branch;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.balance = balance;
	}
	public AccountDetailsdto() {
		super();
	}
	@Override
	public String toString() {
		return "AccountDetailsdto [account_number=" + account_number + ", username=" + username + ", ifsc=" + ifsc
				+ ", upi_id=" + upi_id + ", bankname=" + bankname + ", branch=" + branch + ", phone=" + phone + ", email="
				+ email + ", address=" + address + ", balance=" + balance + "]";
	}

}
