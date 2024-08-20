package com.example.registerUser.entity;

import java.time.LocalDate;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "UserName is required")
	@Size(min=3,max=25,message="UserName must be between 3 to 25 characters")
	private String userName;
	@NotBlank(message = "Password is required")
	@Size(min=8,message="Password must contain Special characters and numbers")
	private  String password;
	@NotBlank(message = "email is required")
	@Email(message="Email should be valid")
	private String email;
	@Past(message="Date of birth must be in the past")
	private LocalDate dateOfBirth;
	
	public User() {
		super();
	}

	public User(
			@NotBlank(message = "UserName is required") @Size(min = 3, max = 25, message = "UserName must be between 3 to 25 characters") String userName,
			@NotBlank(message = "Password is required") @Size(min = 8, message = "Password must contain Special characters and numbers") String password,
			@NotBlank(message = "email is required") @Email(message = "Email should be valid") String email,
			@Past(message = "Date of birth must be in the past") LocalDate dateOfBirth) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}
	
}
