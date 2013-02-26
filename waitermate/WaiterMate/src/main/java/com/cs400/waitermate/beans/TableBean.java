package com.cs400.waitermate.beans;

import java.util.List;
import java.util.ArrayList;

public class TableBean {
	private int ID;
	private Boolean occupied;
	private List<CheckBean> checkList;
	
	
	public List<CheckBean> getCheckList() {
		return checkList;
	}
	public void setCheckList(List<CheckBean> checkList) {
		this.checkList = checkList;
	}
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
	
	
}
