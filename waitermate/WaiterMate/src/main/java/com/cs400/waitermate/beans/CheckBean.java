package com.cs400.waitermate.beans;

import java.util.List;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import com.cs400.waitermate.beans.MenuItemBean;
import com.cs400.waitermate.beans.OrderBean;


public class CheckBean {
	private long ID;
	private int table;
	private Boolean open;
	private float subtotal;
	private float tip;
	private float tax;
	private List<OrderBean> ordersList;
	private static final double TAXRATE = .09;
	private float total;
	
	public long getID() {
		return ID;
	}
	public void setID(long ID) {
		this.ID = ID;
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
	
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public void setTip(float tip) {
		this.tip = tip;
	}
	public void addOrder(OrderBean order){
		this.ordersList.add(order);
	}
	
	
	
	public List<OrderBean> getOrdersList() {
		return ordersList;
	}
	public void setOrdersList(List<OrderBean> ordersList) {
		this.ordersList = ordersList;
	}
	public CheckBean(int table){
		this.open = true;
		this.subtotal = 0;
		this.tax = 0;
		this.tip = 0;
		this.table = table;
		this.ID = 0;
		ordersList = new ArrayList<OrderBean>();
		this.total = 0;
				
	}
	public CheckBean(int table, long id){
		this.open = true;
		this.subtotal = 0;
		this.tax = 0;
		this.tip = 0;
		this.table = table;
		this.ID = id;
		ordersList = new ArrayList<OrderBean>();
		this.total = 0;
	}
	
	public CheckBean(){
		this.open = true;
		this.subtotal = 0;
		this.tax = 0;
		this.tip = 0;
		this.table = 0;
		this.ID = 0;
		ordersList = new ArrayList<OrderBean>();
		this.total = 0;
	}
	
	public void updateMoneyTotals(){
		this.tax = 0;
		this.subtotal = 0;		
		for(OrderBean order: this.getOrdersList())
		{
			this.subtotal += order.getPrice();
		}
		this.tax = (this.subtotal * Float.parseFloat(String.valueOf(TAXRATE)));		
		DecimalFormat df = new DecimalFormat("#.##");
		df.setMaximumFractionDigits(2);		
		String s = String.valueOf(this.tax);
		Double d = Double.parseDouble(s);
		s = df.format(d);
		this.tax = Float.parseFloat(s);
		this.total = this.subtotal + this.tax;
		System.out.println("tax: " + this.tax);
		System.out.println("subtotal: " + this.subtotal);
		System.out.println("total : " + this.total);
		
	}
	
	
	
	
}
