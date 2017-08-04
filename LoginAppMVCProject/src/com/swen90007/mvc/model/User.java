package com.swen90007.mvc.model;

public class User {

    private String userFullName;
    private String password;

    public User() {
	super();
    }

    public User(String userFullName, String password) {
	super();
	this.userFullName = userFullName;
	this.password = password;
    }

    public String getUserFullName() {
	return userFullName;
    }

    public void setUserFullName(String userFullName) {
	this.userFullName = userFullName;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }
}
