package com.dev.BookMyShow.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.dev.BookMyShow.dto.UserSignUpRequestDTO;
import com.dev.BookMyShow.dto.UserSignUpResponseDTO;
import com.dev.BookMyShow.models.User;
import com.dev.BookMyShow.service.UserService;

public class UserController {
	@Autowired
	private UserService userService; // interface
	
	private UserSignUpResponseDTO responseDtoToUser(User user) {
		UserSignUpResponseDTO responseDto = new UserSignUpResponseDTO();
		responseDto.setEmail(user.getEmail());
		responseDto.setId(user.getId());
		responseDto.setName(user.getName());
		responseDto.setTickets(user.getTickets());
		responseDto.setResponseCode(200);
		responseDto.setResponseMessage("SUCCESS");
		return responseDto;
	}
	
	private UserSignUpResponseDTO signUp(UserSignUpRequestDTO requestDto) {
		User newUser; 
		try {
			newUser = userService.signup(requestDto.getName(), requestDto.getEmail(), requestDto.getPassword());
			UserSignUpResponseDTO responseDto = responseDtoToUser(newUser);
			return responseDto;
		}
		catch(Exception e){
			UserSignUpResponseDTO responseDto = new UserSignUpResponseDTO(); 
			responseDto.setResponseCode(500);
			responseDto.setResponseMessage("Internal server error");
			return responseDto;
		}
	}

}
