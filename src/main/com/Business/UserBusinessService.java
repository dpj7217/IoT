package main.com.Business;

import org.springframework.beans.factory.annotation.Autowired;
import main.com.Data.UserDataService;
import main.com.Models.User;

public class UserBusinessService implements UserBusinessInterface {
	@SuppressWarnings("rawtypes")
	@Autowired
	UserDataService dao;
	

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