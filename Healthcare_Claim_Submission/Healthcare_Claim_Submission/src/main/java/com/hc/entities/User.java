package com.hc.entities;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer uId;
	
	@NotBlank(message = "firstName field mandatory")
	@Size(min = 5, max = 20, message = "min 5 and max 20 characters are allowed !!")
	private String uFname;
	
	@NotBlank(message = "lastName field mandatory")
	@Size(min = 5, max = 20, message = "min 5 and max 20 characters are allowed !!")
	private String uLname;
	
	@NotBlank(message = "userName field mandatory")
	@Column(unique = true)
	private String uUserName;

	@NotBlank
	@Pattern(regexp = "^.*(?=.{8,15})(?=.*\\d)(?=.*[a-zA-Z])|(?=.{8,15})(?=.*\\d)(?=.*[!@#$%^&])|(?=.{8,15})(?=.*[a-zA-Z])(?=.*[!@#$%^&]).*$")
	private String uPassword;

	@NotBlank(message = "Confirm Password is mandatory")
	private String uConfirmPassword;
	
	@Embedded
	private Address address;
	
	@NotBlank(message = "Email is required")
	@Email(message = "Email should be valid")
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Email format is invalid")
	@Column(name = "email", unique = true, nullable = false)
	private String uEmail;
	
	@DateTimeFormat(pattern = "MM-DD-YYYY")
	private String uDate;

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public String getuFname() {
		return uFname;
	}

	public void setuFname(String uFname) {
		this.uFname = uFname;
	}

	public String getuLname() {
		return uLname;
	}

	public void setuLname(String uLname) {
		this.uLname = uLname;
	}

	public String getuUserName() {
		return uUserName;
	}

	public void setuUserName(String uUserName) {
		this.uUserName = uUserName;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public String getuConfirmPassword() {
		return uConfirmPassword;
	}

	public void setuConfirmPassword(String uConfirmPassword) {
		this.uConfirmPassword = uConfirmPassword;
	}

	public String getuEmail() {
		return uEmail;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	public String getuDate() {
		return uDate;
	}

	public void setuDate(String uDate) {
		this.uDate = uDate;
	}

	
}
