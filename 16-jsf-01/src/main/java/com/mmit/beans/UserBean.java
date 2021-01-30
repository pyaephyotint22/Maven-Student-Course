package com.mmit.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named("user_bean")
public class UserBean {

	private String name;
	private String password;
	private int age;
	private String dob;
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	private String township;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTownship() {
		return township;
	}

	public void setTownship(String township) {
		this.township = township;
	}
	
	
}
