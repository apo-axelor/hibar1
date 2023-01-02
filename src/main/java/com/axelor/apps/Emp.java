package com.axelor.apps;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Emp{
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	


	
	public String getName() {
		return name;
	}
	public void setName(String string) {
		this.name = string;
	} 
	
	
}