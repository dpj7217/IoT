package com.Data;

public interface DataAccessInterface<T> {
	/**
	 * Method to create a new object (T) in the database 
	 * @param new object with needed attributes to be created
	 * @return true, if successful; false, if unsuccessful
	 */
	public boolean create(T t); 
	
	/**
	 * Method to read a single object (T) in the database 
	 * @param object or attribute of the object to allow to be found
	 * @return object found
	 */
	public T read(T t); 

}
