package com.Data;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.Models.User;


public class UserDataService implements UserDataInterface{
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	/**
	 * Default constructor
	 */
	public UserDataService() {
	}

	/**
	 * Method to create a new user in the database (register)
	 * @param new user with needed attributes
	 * @return true, if successful; false, if unsuccessful
	 * @throws DatabaseException
	 */
	@Override
	public boolean create(User user) {
		//output statement for console
		System.out.println("Entering UserDataService.create()");
		String sql = "INSERT INTO audioscapes.users(username, password) VALUES(?, ?)";

		try {
			//output statement for console
			System.out.println("Entering UserDataService.create() with true");
			//execute sql statement
			int rows = jdbcTemplateObject.update(sql, user.getUsername(), user.getPassword());
			//return result
			return rows == 1 ? true : false;
		}
		
		catch (Exception e) {
			//output statement for console
			System.out.println("Exiting UserDataService.create() with false");
			e.printStackTrace();
			return false; 
		}
	}
	
	/**
	 * Method to read a single user in the database (login)
	 * @param user with needed attributes to be found
	 * @return user found by the attributes given
	 * @throws DatabaseException
	 */		
	@Override
		public User read(User t) {
			//output statement for console
			System.out.println("Entering UserDataService.read()");

			//initialize a user to be used to return the data later
			User user = null;
			
			String sql = "SELECT * FROM audioscapes.users WHERE BINARY username = ? AND password = ?";

			try {
				SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql, t.getUsername(), t.getPassword());
				if(srs.next()) {
					System.out.println("Exit UserDataService.read() with a User returned");
					int ID = srs.getInt("ID");
					String username = srs.getString("username");
					String password = srs.getString("password");
					user = new User(ID, username, password);
				}
				else {
					System.out.println("Exit UserDataService.read() with no User returned");
					};
			}
			catch (Exception e) {
				e.printStackTrace();

			}
			return user;
		}		
	 
		/**
		 * Method to set the bean; IoC helper funcation
		 * @param dataSource, to allow for the springbeans to be set 
		 */
		public void setDataSource(DataSource dataSource) {
			this.dataSource = dataSource;
			this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		}

}
