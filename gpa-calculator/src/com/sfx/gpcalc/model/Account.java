package com.sfx.gpcalc.model;

import com.j256.ormlite.field.DatabaseField;

public class Account {
	@DatabaseField(id = true)
    private String name;
    @DatabaseField
    private String password;
    @DatabaseField
    private String email;
    @DatabaseField
    private double gpa;
    
    public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public Account() {
        // ORMLite needs a no-arg constructor 
    }
    public Account(String name, String password) {
        this.name = name;
        this.password = password;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
