package com.cs400.waitermate.beans;

import java.util.List;

public class DrinkBean{

	private double abv;
	private int ID;
	private String name;
	private float price;
	private String category;
	private List<IngredientBean> ingredientsList;
	
	

	public List<IngredientBean> getIngredientsList() {
		return ingredientsList;
	}
	public void setIngredientsList(List<IngredientBean> ingredientsList) {
		this.ingredientsList = ingredientsList;
	}
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

	public double getAbv() {
		return abv;
	}

	public void setAbv(double abv) {
		this.abv = abv;
	}
	
	
	
}
