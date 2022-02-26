package com.demo.Demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hib {
	
	@Id
	private int id;
	private HibName hibName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public HibName getHibName() {
		return hibName;
	}
	public void setHibName(HibName hibName) {
		this.hibName = hibName;
	}
	//for printing find record
	@Override
	public String toString() {
		return "Hib [id=" + id + ", hibName=" + hibName + "]";
	}
	
	
}
