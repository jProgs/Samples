package com.cs400.waitermate.beans;

public class TableBean {
	private int ID;
	private Boolean occupied;
	private int Waiter;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Boolean getOccupied() {
		return occupied;
	}
	public void setOccupied(Boolean occupied) {
		this.occupied = occupied;
	}
	public int getWaiter() {
		return Waiter;
	}
	public void setWaiter(int waiter) {
		Waiter = waiter;
	}
	
}
