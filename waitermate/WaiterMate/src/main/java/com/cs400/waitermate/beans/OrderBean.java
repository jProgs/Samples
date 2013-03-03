package com.cs400.waitermate.beans;

public class OrderBean {

	
	private long ID;
	private String name;
	private float price;
	private String category;
	private String comment;
	private long check;
	
	
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
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
	
		
	public long getCheck() {
		return check;
	}
	public void setCheck(long check) {
		this.check = check;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public OrderBean()
	{
		this.ID = 0;
		this.name = "";
		this.price = 0;
		this.category = "";
		this.comment = "";
		this.check = 0;
					
	}
	
	public OrderBean(long check, long id){
		this.ID = id;
		this.check = check;
		this.name = "";
		this.category = "";
		this.comment = "";
				
	}
	
	public OrderBean(long id, String name, float price, String category, String comment, long check){
		this.ID = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.comment = comment;
		this.check = check;
	}
	
	public OrderBean(String name){
		this.ID = 0;
		this.name = name;
		this.price = 0;
		this.category = "";
		this.comment = "";
		this.check = 0;
	
	}
	
}
