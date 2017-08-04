package com.swen90007.mvc.service;

import com.swen90007.mvc.model.User;

public class LoginService {
    
    // Activity 1
    public boolean authenticate(String username, String password) {
	if (password != null && !password.isEmpty()) {
	    return true;
	}
	return false;
    }
    
    // Activity 2.1
    public User getUserDetails(String password) {
	User dummyUser = new User("Joe Do", "1234");
	
	if (password.contentEquals(dummyUser.getPassword())) {
	    return dummyUser;
	}
	
	// for Activity 1
	return new User("", password);
    }
}
