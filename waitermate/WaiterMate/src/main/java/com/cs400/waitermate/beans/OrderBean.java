package com.cs400.waitermate.beans;

public class OrderBean {

	
	private int ID;
	private String name;
	private float price;
	private String category;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public OrderBean()
	{
		this.ID = 0;
		this.name = "";
		this.price = 0;
		this.category = "";
					
	}
	
	public OrderBean(int id, String name, float price, String category){
		this.ID = id;
		this.name = name;
		this.price = price;
		this.category = category;
	}
	
	public OrderBean(String name){
		this.ID = 0;
		this.name = name;
		this.price = 0;
		this.category = "";
	
	}
	
}
