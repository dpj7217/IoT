package com.Models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
	//attributes
		//@NotNull is used to validate that the user inputs info 
	
	private int ID; //no need for not null as it will be incremented in the database
	
	@NotNull(message = "Username cannot be null.")
	@Size(min=3, max=30, message="Username must be between 3 and 30 characters.")
	private String username; 
	
	@NotNull(message = "Password cannot be null.")
	@Size(min=3, max=30, message="Password must be between 3 and 30 characters.")
	private String password;
	
	
	//constructors 
	public User() {
		this.ID = 0;
		this.username = "";
		this.password = "";
	}

	public User(int iD,
				@NotNull(message = "Username cannot be null.") @Size(min = 3, max = 30, message = "Username must be between 3 and 30 characters.") String username,
				@NotNull(message = "Password cannot be null.") @Size(min = 3, max = 30, message = "Password must be between 3 and 30 characters.") String password
				) {
			super();
			ID = iD;
			this.username = username;
			this.password = password;
		}



	//getters and setters 
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
