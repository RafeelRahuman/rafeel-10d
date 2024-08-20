package com.example.registerUser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.registerUser.entity.User;
import com.example.registerUser.userService.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@Validated
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public String register(@Valid @RequestBody User user) {
		
		try {
			userService.registerUser(user);
			return "User registered Sucessfully";
		}
		catch(IllegalArgumentException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
