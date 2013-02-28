package com.cs400.waitermate.beans;

/*
import java.util.List;
import java.util.ArrayList;
*/

public class FoodBean extends OrderBean{
	
//	private List<IngredientBean> ingredientsList;
	private int sideID;	
	
/*
	public List<IngredientBean> getIngredientsList() {
		return ingredientsList;
	}
	public void setIngredientsList(List<IngredientBean> ingredientsList) {
		this.ingredientsList = ingredientsList;
	}
*/
	
	
	public int getSideID() {
		return sideID;
	}
	public void setSideID(int sideID) {
		this.sideID = sideID;
	}
	
}
