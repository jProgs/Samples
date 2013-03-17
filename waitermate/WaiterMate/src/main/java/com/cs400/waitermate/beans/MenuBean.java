package com.cs400.waitermate.beans;

import java.util.List;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import com.cs400.waitermate.beans.MenuItemBean;


public class MenuBean {
	private List<MenuItemBean> menu;
	private List<String> menuCategoriesList;
	public List<MenuItemBean> getMenu() {
		return menu;
	}
	public void setMenu(List<MenuItemBean> menu) {
		this.menu = menu;
	}
	public List<String> getMenuCategoriesList() {
		return menuCategoriesList;
	}
	public void setMenuCategoriesList(List<String> menuCategoriesList) {
		this.menuCategoriesList = menuCategoriesList;
	}
	
	
	
	
	public MenuBean(){
		menu = new ArrayList<MenuItemBean>();
		menuCategoriesList = new ArrayList<String>();
	}
	
	public void updateCategoryList() {

		boolean alreadyOnList;
		for (MenuItemBean mib : menu) {
			alreadyOnList = false;
			for (String s : this.menuCategoriesList) {
				if (alreadyOnList == false) {
					if (mib.getCategory() == s) {
						alreadyOnList = true;
					}
				}
				
			}// end menuCategoriesList iteration
			// add it to the category to the list if it wasn't already there
			if (alreadyOnList == false) {
				this.menuCategoriesList.add(mib.getCategory());
			}
		}// end MenuItemBean iteration

	}// end updateCategoryList()
	
	public void addMenuItem(MenuItemBean mib){
		this.menu.add(mib);
	}
	
	

}
