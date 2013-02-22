package com.cs400.waitermate.beans;

public class FoodBean {
	private int ID;
	private String name;
	private int[] ingredients;
	private String[] ingNames; //Ingredient names	
	private float Price;
	private String category;
	private int sideID;
	
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
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getSideID() {
		return sideID;
	}
	public void setSideID(int sideID) {
		this.sideID = sideID;
	}
	public String[] getIngNames() {
		return ingNames;
	}
	public void setIngNames(String[] ingNames) {
		this.ingNames = ingNames;
	}
}
