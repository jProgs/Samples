package com.cs400.waitermate.beans;

import java.util.List;
import java.util.ArrayList;

public class MenuItemBean {
	
	private int ID;
	private String name;
	private float price;
	private String category;
	//private List<IngredientBean> ingredientsList;
	
	
/*
	public List<IngredientBean> getIngredientsList() {
		return ingredientsList;
	}
	public void setIngredientsList(List<IngredientBean> ingredientsList) {
		this.ingredientsList = ingredientsList;
	}
*/
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
	
	public MenuItemBean(){
		this.ID = 0;
		this.name = "";
		this.price = 0;
		this.category = "";
	}
	
	public MenuItemBean(int id, String name, float price, String category)
	{
		this.ID = id;
		this.name = name;
		this.price = price;
		this.category = category;
	}

}
