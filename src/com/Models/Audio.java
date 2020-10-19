package com.Models;

public class Audio {
	//	id	frequency	duration	decibelamplitude	timestamp	devices_id
	private int id;
	private double frequency;
    private double duration;
    private int dba;
    private String timestamp;
    private Device creator;
    //for creation
    public Audio(double frequency, double duration, int dba, Device creator) {
		this.id = 0;
		this.frequency = frequency;
		this.duration = duration;
		this.dba = dba;
		this.timestamp = "";
		this.creator = creator;
	}
    //for fetching
	public Audio(int id, double frequency, double duration, int dba, String timestamp, Device creator) {
		this.id = id;
		this.frequency = frequency;
		this.duration = duration;
		this.dba = dba;
		this.timestamp = timestamp;
		this.creator = creator;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getFrequency() {
		return frequency;
	}
	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public int getDba() {
		return dba;
	}
	public void setDba(int dba) {
		this.dba = dba;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public Device getCreator() {
		return creator;
	}
	public void setCreator(Device creator) {
		this.creator = creator;
	}
    
}
