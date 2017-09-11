package com.swen90007.security;

import java.io.Serializable;

public class UserRoleDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private int userId;
    private String username;
    private String password;
    private int enabled;
    private int roleId;
    private String role;

    public int getUserId() {
	return userId;
    }

    public void setUserId(int userId) {
	this.userId = userId;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public int getEnabled() {
	return enabled;
    }

    public void setEnabled(int enabled) {
	this.enabled = enabled;
    }

    public int getRoleId() {
	return roleId;
    }

    public void setRoleId(int roleId) {
	this.roleId = roleId;
    }

    public String getRole() {
	return role;
    }

    public void setRole(String role) {
	this.role = role;
    }
}
