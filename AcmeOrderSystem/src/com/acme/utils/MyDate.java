package com.acme.utils;

import java.time.LocalDate;

/**
 * 
 */

/**
 * @author migui
 *
 */
public class MyDate {
	private byte day;
	private byte month;
	private short year;
	private static MyDate[] holidays;
	
	static {
		int year = LocalDate.now().getYear();
		holidays = new MyDate[6];
		holidays[0] = new MyDate(1, 1,year);
		holidays[1] = new MyDate(5,30,year);
		holidays[2] = new MyDate(7,4 ,year);
		holidays[3] = new MyDate(9,5,year);
		holidays[4] = new MyDate(11,24,year);
		holidays[5] = new MyDate(12,25,year);
	}

	
	/**
	 * @return the holidays
	 */
	public static MyDate[] getHolidays() {
		return holidays;
	}

	/**
	 * @param holidays the holidays to set
	 */
	public static void setHolidays(MyDate[] holidays) {
		MyDate.holidays = holidays;
	}

	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
		try {
			valid(this.day, this.month, this.year);
		} catch (InvalidDateException invalidDateEx) {
			System.err.println("Attempting to set an invalid day...");
			System.err.println(invalidDateEx.getMessage());
		}
		{
			this.day = (byte) day;
		}
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.month = (byte) month;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = (short) year;
	}

	private void valid(int day, int month, int year) throws InvalidDateException {
		if (day > 31 || day <1 || month > 12 || month <1) {
			System.out.println("Attempting to create a non-valid date " + month + "/" + day + "/" + year);
			throw new InvalidDateException(day, month, year);
		} 
		
		switch (month) {
		case 4:
		case 6:
		case 9:
		case 11:
			if (day > 30 ) {
				throw new InvalidDateException(day, month, year);
			}
		case 2:
			/* in case it's a leap year..*/
			if (year%4 == 0) {
				if (day > 29) {
					throw new InvalidDateException(day, month, year);
				}
			} else { /* if year is a regular year...*/
				if (day > 28) {
					throw new InvalidDateException(day, month, year);
				}
			}
		}
	}
	
	{
		day = 1;
		month = 1;
		year = 2000;
	}
	
	public MyDate() {
		this(1,1,1900);
	}

	public MyDate(int m, int d, int y) {
		setDate(m, d, y);
	}

	//DONE: return a string with month/day/year like “01/20/1964”  return "";
	public String toString(){  
		String formattedDate;
		
		formattedDate = month + "/" + day + "/" + year;
		return formattedDate;
	}
	
	public boolean equals(Object o) {
		if (o instanceof MyDate) {
			MyDate myDate = (MyDate) o;
			if (this.getDay() == myDate.getDay() && this.getMonth() == myDate.getMonth() && this.getYear() == myDate.getYear()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	// DONE: set the MyDate attributes with m, d, and y values here! 
	public void setDate(int m, int d, int y){
		try {
			valid(d, m, y);
		} catch(InvalidDateException invalidDateEx) {
			System.err.println("Attempting to set an invalid date...");
			System.err.println(invalidDateEx.getMessage());
		}
		{
			this.month = (byte) m;
			this.day = (byte) d;
			this.year = (short) y;
		} 
	}  
	
	/**
	 * This method prints out to "stdout" all leap years between 1752 and 2020
	 */
	public static void leapYears() {
		
		for (int year = 1752; year <= 2020; year++) {
			/* System.out.println("--------------------------------------------");
			System.out.println(year + "- Divisible by 4? " + (year % 4 ==0));
			System.out.println(year + "- Divisible by 100? " + (year % 100 ==0));
			System.out.println(year + "- Divisible by 400? " + (year % 400 ==0));
			System.out.println("--------------------------------------------"); */
			if (year % 4 == 0) {
				if (year % 100 != 0) {
					System.out.println("The year " + year + " is a leap year");
				} else {
					if (year % 400 == 0) {
						System.out.println("The year " + year + " is a leap year");
					}
				}
			}

		}
	}
	
	public static void listHolidays()  {
		for (MyDate day:holidays) {
			System.out.println(day);
		}
	}
}
