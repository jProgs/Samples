package com.cs400.waitermate.beans;

import java.util.List;
import java.util.ArrayList;
import com.cs400.waitermate.beans.MenuItemBean;

public class CheckBean {
	private long ID;
	private int table;
	private Boolean open;
	private float subtotal;
	private float tip;
	private float tax;
	private List<MenuItemBean> menuItemsList;
	
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public int getTable() {
		return table;
	}
	public void setTable(int table) {
		this.table = table;
	}
	
	public Boolean getOpen() {
		return open;
	}
	public void setOpen(Boolean open) {
		this.open = open;
	}
	
	public float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	public float getTax() {
		return tax;
	}
	public void setTax(float tax) {
		this.tax = tax;
	}
	public float getTip() {
		return tip;
	}
	public void setTip(float tip) {
		this.tip = tip;
	}
	
	public CheckBean(int table){
		this.open = true;
		this.subtotal = 0;
		this.tax = 0;
		this.tip = 0;
		this.table = table;
		this.ID = 0;
				
	}
	
}
