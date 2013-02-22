package com.cs400.waitermate.beans;

public class SideBean {
	private int ID;
	private String name;
	private int[] ingredients;
	private String[] ingNames; //Ingredient Names
	private float price;
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
	public int[] getIngredients() {
		return ingredients;
	}
	public void setIngredients(int[] ingredients) {
		this.ingredients = ingredients;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String[] getIngNames() {
		return ingNames;
	}
	public void setIngNames(String[] ingNames) {
		this.ingNames = ingNames;
	}
}
