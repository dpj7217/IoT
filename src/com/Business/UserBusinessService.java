package com.Business;

import org.springframework.beans.factory.annotation.Autowired;

import com.Data.UserDataInterface;
import com.Models.User;

public class UserBusinessService implements UserBusinessInterface {
	@SuppressWarnings("rawtypes")
	@Autowired
	UserDataInterface dao;
	

	@Override
	public boolean register(User user) {
		//returns if the user creation was successful
		return dao.create(user);
	}

	@Override
	public User login(User user) {
		//return the user found 
		return (User)dao.read(user);
	}
}