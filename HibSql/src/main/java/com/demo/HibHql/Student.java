package com.demo.HibHql;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	private String name;
	
	@Id
	private int rollno;
	private int marks;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [ rollno=" + rollno + ",name=" + name + ", marks=" + marks + "]";
	}
	
	
}
