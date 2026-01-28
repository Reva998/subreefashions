package com.flm.dto;

public class Kanchisareesdto {
private int code;
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
public Kanchisareesdto(String image, int price, String imgdesc) {
	super();
	this.image = image;
	this.price = price;
	this.imgdesc = imgdesc;
}
@Override
public String toString() {
	return "Kanchisareesdto [code=" + code + ", image=" + image + ", price=" + price + ", imgdesc=" + imgdesc + "]";
}
public Kanchisareesdto() {
	super();
}
public Kanchisareesdto(int code, String image, int price, String imgdesc) {
	super();
	this.code = code;
	this.image = image;
	this.price = price;
	this.imgdesc = imgdesc;
}
public String getImgdesc() {
	return imgdesc;
}
public void setImgdesc(String imgdesc) {
	this.imgdesc = imgdesc;
}
}
