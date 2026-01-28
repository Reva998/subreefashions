package com.flm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Kanchisarees {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int code;
public Kanchisarees(String image, int price, String imgdesc) {
	super();
	this.image = image;
	this.price = price;
	this.imgdesc = imgdesc;
}
private String image;
private int price;
private String imgdesc;
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getImgdesc() {
	return imgdesc;
}
public void setImgdesc(String imgdesc) {
	this.imgdesc = imgdesc;
}
public Kanchisarees(int code, String image, int price, String imgdesc) {
	super();
	this.code = code;
	this.image = image;
	this.price = price;
	this.imgdesc = imgdesc;
}
public Kanchisarees() {
	super();
}
@Override
public String toString() {
	return "Kanchisarees [code=" + code + ", image=" + image + ", price=" + price + ", imgdesc=" + imgdesc + "]";
}

}
