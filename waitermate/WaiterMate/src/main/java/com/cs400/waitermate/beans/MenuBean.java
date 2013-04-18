package com.cs400.waitermate.beans;

import java.util.List;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import com.cs400.waitermate.beans.MenuItemBean;
import com.cs400.waitermate.beans.OrderBean;


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

		this.menuCategoriesList.clear();
		////////////////
		for (MenuItemBean mib : menu) {
			this.addCategoryIfNotOnList(mib);
		}
		
		
		
	}
	
	private void addCategoryIfNotOnList(MenuItemBean mib){
		System.out.println("at add category if not on list");
		boolean alreadyOnList = false;
		for(String s: this.menuCategoriesList)
		{
			System.out.println(s + "   " + mib.getCategory());
			if(s.equalsIgnoreCase(mib.getCategory())){
				alreadyOnList = true;
				
			}
		}
		
		if(alreadyOnList ==  false)
		{
			this.menuCategoriesList.add(mib.getCategory());
		}
		
		
	}
	
	public void addMenuItem(MenuItemBean mib){
		this.menu.add(mib);
	}
	
	public OrderBean createOrderFromName(String name){
		
		OrderBean ob = new OrderBean();
		ob.setName(name);
		
		
		// NEED TO PUT THIS IN SOME KIND OF TRY CATCH FOR IF THE MENU HASNT BEEN CREATED YET
		for(MenuItemBean mib: menu)
		{
			System.out.println(mib.getName());
			if(mib.getName().equalsIgnoreCase(ob.getName()))
			{
				System.out.println("I found a match");
				ob.setCategory(mib.getCategory());
				ob.setPrice(mib.getPrice());
				System.out.println(ob.getPrice() + " it costs ");
				return ob;
			}
		}	
		
		return ob;
	}
	
	public int getOrderMenuItemID(OrderBean ob){
		for(MenuItemBean mib: menu){
			if(ob.getName().equalsIgnoreCase(mib.getName())){
				return mib.getID();
			}
		}
		return 0;
	}

}
