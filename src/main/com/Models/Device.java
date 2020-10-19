package main.com.Models;

public class Device {
	//id	serialnumber
	private int id;
	private int serialnumber;
	//for creation
	public Device(int serialnumber) {		
		this.id = 0;
		this.serialnumber = serialnumber;
	}
	//for fetching
	public Device(int id, int serialnumber) {
		super();
		this.id = id;
		this.serialnumber = serialnumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSerialnumber() {
		return serialnumber;
	}
	public void setSerialnumber(int serialnumber) {
		this.serialnumber = serialnumber;
	}
}
