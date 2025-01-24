package com.coderhouse.dtos;

public class TimeApiDTO {

	   private int year;
	    private int month;
	    private int day;
	    private int hour;
	    private int minute;
	    
	    private String dateTime;

	    // Constructores	
		public TimeApiDTO() {
			super();
			// TODO Auto-generated constructor stub
		}

		public TimeApiDTO(int year, int month, int day, int hour, int minute, String dateTime) {
			super();
			this.year = year;
			this.month = month;
			this.day = day;
			this.hour = hour;
			this.minute = minute;
			this.dateTime = dateTime;
		}
		
		//Getters and Setters

		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			this.year = year;
		}

		public int getMonth() {
			return month;
		}

		public void setMonth(int month) {
			this.month = month;
		}

		public int getDay() {
			return day;
		}

		public void setDay(int day) {
			this.day = day;
		}

		public int getHour() {
			return hour;
		}

		public void setHour(int hour) {
			this.hour = hour;
		}

		public int getMinute() {
			return minute;
		}

		public void setMinute(int minute) {
			this.minute = minute;
		}

		public String getDateTime() {
			return dateTime;
		}

		public void setDateTime(String dateTime) {
			this.dateTime = dateTime;
		}
		
	    
}
