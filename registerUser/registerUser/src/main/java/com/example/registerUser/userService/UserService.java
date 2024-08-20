package com.example.registerUser.userService;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.registerUser.entity.User;
import com.example.registerUser.repository.UserRepository;

import jakarta.validation.Valid;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public User registerUser(@Valid User user) {

		if(user.getDateOfBirth()==null) {
			throw new IllegalArgumentException("Date of Birth must be provided");
		}
		LocalDate currentDate=LocalDate.now();
		Period period=Period.between(user.getDateOfBirth(), currentDate);
		
		if(period.getYears()<18) {
			throw new IllegalArgumentException("User must be 18 years above");
		}
		
		return userRepository.save(user);
		
	}

}
