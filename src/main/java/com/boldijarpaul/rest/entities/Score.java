package com.boldijarpaul.rest.entities;

public class Score {
	
	private long value;
	private long currentDate;
	private String username;
	
	
	public Score(){
		
	}
	
	public Score(long value, long currentDate, String username) {
		super();
		this.value = value;
		this.currentDate = currentDate;
		this.username = username;
	}

	public long getValue() {
		return value;
	}
	public void setValue(long value) {
		this.value = value;
	}
	public long getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(long currentDate) {
		this.currentDate = currentDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
