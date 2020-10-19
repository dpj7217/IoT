package main.com.Business;

import main.com.Models.User;

public interface UserBusinessInterface {
	/**
	 * Method to create(register) a user in the database
	 * @param new user with needed attributes
	 * @return true, if successful; false, if unsuccessful
	 */
	public boolean register(User user);
	
	/**
	 * Method to find(login) a user in the database
	 * @param returning user with matching username and password
	 * @return user
	 */
	public User login(User user);
	
	/**
	 * Method to edit a user in the database 
	 * @param id of user to be edited
	 * @param user with the edited attributes
	 * @return true, if successful; false, if unsuccessful
	 */

}
