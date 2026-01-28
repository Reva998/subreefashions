package com.flm.model;

public class ItemsModel {


	
	private int code;
	private String proname;
	private int rate;
	private float gst;
	private int total_quantity;
	private String supplier;
	private String supplier_add;
	private int quantity_per;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public float getGst() {
		return gst;
	}
	public void setGst(float gst) {
		this.gst = gst;
	}
	public int getTotal_quantity() {
		return total_quantity;
	}
	public void setTotal_quantity(int total_quantity) {
		this.total_quantity = total_quantity;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getSupplier_add() {
		return supplier_add;
	}
	public void setSupplier_add(String supplier_add) {
		this.supplier_add = supplier_add;
	}
	public int getQuantity_per() {
		return quantity_per;
	}
	public void setQuantity_per(int quantity_per) {
		this.quantity_per = quantity_per;
	}
	public ItemsModel(int code, String proname, int rate, float gst, int total_quantity, String supplier, String supplier_add,
			int quantity_per) {
		
		this.code = code;
		this.proname = proname;
		this.rate = rate;
		this.gst = gst;
		this.total_quantity = total_quantity;
		this.supplier = supplier;
		this.supplier_add = supplier_add;
		this.quantity_per = quantity_per;
	}
	public ItemsModel() {
		
	}
	@Override
	public String toString() {
		return "Items [code=" + code + ", proname=" + proname + ", rate=" + rate + ", gst=" + gst + ", total_quantity="
				+ total_quantity + ", supplier=" + supplier + ", supplier_add=" + supplier_add + ", quantity_per="
				+ quantity_per + "]";
	}

	}

