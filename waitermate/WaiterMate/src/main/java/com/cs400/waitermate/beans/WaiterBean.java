package com.cs400.waitermate.beans;
import java.util.List;
import java.util.ArrayList;
import com.cs400.waitermate.beans.TableBean;

public class WaiterBean {
	private int ID;
	private String fname;	
	private String lname;	
	private Boolean admin;
	private List<TableBean> currentTables;
	
		
	// getters and setters
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	public List<TableBean> getCurrentTables() {
		return currentTables;
	}
	public void setCurrentTables(List<TableBean> currentTables) {
		this.currentTables = currentTables;
	}
	
	public TableBean getSpecificTable(int tableId){		
		for(TableBean myTable: this.currentTables)
		{
			if(myTable.getID() == tableId)
			{				
				return myTable;					
			}
		}		
		TableBean tb = new TableBean();
		return tb;
	}
	
	// constructors
	public WaiterBean(){
		this.ID = 0;
		this.fname = "";
		this.lname = "";
		this.admin = false;
		currentTables = new ArrayList<TableBean>();
	}
	
	public WaiterBean(int id, String fname, String lname, Boolean admin){
		this.ID = id;
		this.fname = fname;
		this.lname = lname;
		this.admin = admin;
		this.currentTables = new ArrayList<TableBean>();
	}
	
	public WaiterBean(WaiterBean wb){
		this.ID = wb.getID();
		this.fname = wb.getFname();
		this.lname = wb.getLname();
		this.admin = wb.getAdmin();
		this.currentTables = wb.getCurrentTables();
	}
	
	public void addTableToWaiter(TableBean table){
		this.currentTables.add(table);		
	}
	
	public WaiterBean replaceTableById(TableBean table){
		for(TableBean tb: this.getCurrentTables()){
			if(tb.getID() == table.getID())
			{
				tb = table;
				return this;
			}
			
		}
		return this;
	}
	
	public void removeTableFromList(TableBean tb){
		for(TableBean table: this.getCurrentTables()){
			if(tb.getID() == table.getID()){
				this.getCurrentTables().remove(table);
			}
		}
	}
	
}
