package com.hc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.hc.entities.User;
import com.hc.repositories.UserRepository;

@Service
public class UserService 
{
	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(User user, BindingResult bindingResult)
	{
		if(!user.getuPassword().equals(user.getuConfirmPassword()))
		{
			bindingResult.addError(new FieldError("user","confirmPassword", "Password"));
			return null;
		}
		return userRepository.save(user);
	}
}
