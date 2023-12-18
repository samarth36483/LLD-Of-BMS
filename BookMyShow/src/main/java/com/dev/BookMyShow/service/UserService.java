package com.dev.BookMyShow.service;

import com.dev.BookMyShow.models.User;

public interface UserService {
	
	User login(String email, String password);
	
	User signup(String name, String email, String password);

}
