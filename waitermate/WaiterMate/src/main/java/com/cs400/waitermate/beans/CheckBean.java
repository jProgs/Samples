package com.cs400.waitermate.beans;

public class CheckBean {
	private int ID;
	private int table;
	private Boolean closed;
	private float bill;
	private float tip;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getTable() {
		return table;
	}
	public void setTable(int table) {
		this.table = table;
	}
	public Boolean getClosed() {
		return closed;
	}
	public void setClosed(Boolean closed) {
		this.closed = closed;
	}
	public float getBill() {
		return bill;
	}
	public void setBill(float bill) {
		this.bill = bill;
	}
	public float getTip() {
		return tip;
	}
	public void setTip(float tip) {
		this.tip = tip;
	}
	
}
