package com.flm.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BankStatement {
@Id
private String transid;
private String account_number;
private String upi_id;
private String sender_upi;
private int amount;
private LocalDate date;
private int balance;
public String getTransid() {
	return transid;
}
public void setTransid(String transid) {
	this.transid = transid;
}
public String getAccount_number() {
	return account_number;
}
public void setAccount_number(String account_number) {
	this.account_number = account_number;
}
public String getUpi_id() {
	return upi_id;
}
public void setUpi_id(String upi_id) {
	this.upi_id = upi_id;
}
public String getSender_upi() {
	return sender_upi;
}
public void setSender_upi(String sender_upi) {
	this.sender_upi = sender_upi;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public int getBalance() {
	return balance;
}
public void setBalance(int balance) {
	this.balance = balance;
}
public BankStatement(String transid, String account_number, String upi_id, String sender_upi, int amount,
		LocalDate date, int balance) {
	super();
	this.transid = transid;
	this.account_number = account_number;
	this.upi_id = upi_id;
	this.sender_upi = sender_upi;
	this.amount = amount;
	this.date = date;
	this.balance = balance;
}
public BankStatement() {
	super();
}
@Override
public String toString() {
	return "BankStatement [transid=" + transid + ", account_number=" + account_number + ", upi_id=" + upi_id
			+ ", sender_upi=" + sender_upi + ", amount=" + amount + ", date=" + date + ", balance=" + balance + "]";
}

}
