package com.feedback.Demo.Entity;

import javax.persistence.*;

@Entity
@Table(name="registration")
public class Users {
	@Id
	private String emp_id;
	private String name;
	private String password;
	public String getEmp_id() {
		return emp_id;
	}
	public Users() {
		super();
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Users(String emp_id, String name, String password) {
		super();
		this.emp_id = emp_id;
		this.name = name;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Users [emp_id=" + emp_id + ", name=" + name + ", password=" + password + "]";
	}
	
	
	
}
