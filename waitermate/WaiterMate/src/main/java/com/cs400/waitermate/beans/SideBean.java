package com.cs400.waitermate.beans;

import java.util.List;
import java.util.ArrayList;
import com.cs400.waitermate.beans.IngredientBean;

public class SideBean {
	private int ID;
	private String name;	
	private float price;
	private List<IngredientBean> ingredientsList;
	
	
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
	public List<IngredientBean> getIngredientsList() {
		return ingredientsList;
	}
	public void setIngredientsList(List<IngredientBean> ingredientsList) {
		this.ingredientsList = ingredientsList;
	}
	
	
}
