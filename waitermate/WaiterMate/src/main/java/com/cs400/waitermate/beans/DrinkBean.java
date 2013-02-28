package com.cs400.waitermate.beans;

import java.util.List;

public class DrinkBean extends OrderBean{

	private double abv;
	
	//private List<IngredientBean> ingredientsList;
	
	
/*
	public List<IngredientBean> getIngredientsList() {
		return ingredientsList;
	}
	public void setIngredientsList(List<IngredientBean> ingredientsList) {
		this.ingredientsList = ingredientsList;
	}
*/
	

	public double getAbv() {
		return abv;
	}

	public void setAbv(double abv) {
		this.abv = abv;
	}
	
	
	
}
