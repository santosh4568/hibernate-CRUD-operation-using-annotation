package com.annotion_crud;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class student {
	@Id
	private int roll;
	private String name;
	private String gender;
	public student(int roll, String name, String gender) {
		super();
		this.roll = roll;
		this.name = name;
		this.gender = gender;
	}
	public student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
