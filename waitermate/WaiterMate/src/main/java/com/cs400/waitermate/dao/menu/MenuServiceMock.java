package com.cs400.waitermate.dao.menu;

import com.cs400.waitermate.beans.MenuBean;
import com.cs400.waitermate.beans.MenuItemBean;

public class MenuServiceMock implements IMenuService {

	@Override
	public MenuBean loadMenu() {		
		MenuBean menu = new MenuBean();
		//MenuItemBean mib1 = new MenuItemBean(1, "Steak Burger", new Float (6.99), "Burgers");
		menu.addMenuItem(new MenuItemBean(1, "Steak Burger", new Float (6.99), "Burgers"));
		menu.addMenuItem(new MenuItemBean(1, "Southwest Burger", new Float (8.99), "Burgers"));
		menu.addMenuItem(new MenuItemBean(1, "BLT", new Float (6.99), "Sandwiches"));
		menu.addMenuItem(new MenuItemBean(1, "Reuben", new Float (7.99), "Sandwiches"));
		menu.addMenuItem(new MenuItemBean(1, "Tilapia", new Float (6.99), "Fish"));
		menu.addMenuItem(new MenuItemBean(1, "Cat Fish", new Float (6.99), "Fish"));
		menu.addMenuItem(new MenuItemBean(1, "Three Cheese Nachoes", new Float (7.29), "Appetizers"));
		menu.addMenuItem(new MenuItemBean(1, "Fried Pickles", new Float (4.99), "Appetizers"));
		menu.addMenuItem(new MenuItemBean(1, "Coca Cola", new Float (1.99), "Non Alcoholic Drinks"));
		menu.addMenuItem(new MenuItemBean(1, "Sprite", new Float (1.99), "Non Alcoholic Drinks"));
		menu.addMenuItem(new MenuItemBean(1, "Guinness", new Float (2.50), "Beers"));
		menu.addMenuItem(new MenuItemBean(1, "Harp", new Float (3.00), "Beers"));
		//menu.addMenuItem(new MenuItemBean(1, "Steak Burger", new Float (6.99), "Burgers"));
		//menu.addMenuItem(new MenuItemBean(1, "Steak Burger", new Float (6.99), "Burgers"));
		//menu.addMenuItem(new MenuItemBean(1, "Steak Burger", new Float (6.99), "Burgers"));
		//menu.addMenuItem(new MenuItemBean(1, "Steak Burger", new Float (6.99), "Burgers"));
		menu.updateCategoryList();
		
		return menu;
	}

}
