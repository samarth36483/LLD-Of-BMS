package com.dev.BookMyShow.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.BookMyShow.exception.InvalidUserException;
import com.dev.BookMyShow.exception.UserNotFoundException;
import com.dev.BookMyShow.models.User;
import com.dev.BookMyShow.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User login(String email, String password) {
		Optional<User> userOptional = userRepository.findByEmail(email);
		if(userOptional.isEmpty()) {
			throw new UserNotFoundException("Invalid user");
		}
		User user = userOptional.get();
		if(user.getPassword().equals(password))
			return user;
		else {
			throw new InvalidUserException("Invalid login id or password");
		}
	}

	@Override
	public User signup(String name, String email, String password) {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		User newUser = userRepository.save(user);
		
		return newUser;
	}

}
