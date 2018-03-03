package com.acme.utils;
/**
 * 
 */

/**
 * @author migui
 *
 */
public class MyDate {
	public int day;
	public int month;
	public int year;

	{
		day = 1;
		month = 1;
		year = 2000;
	}
	
	public MyDate() {
		
	}

	public MyDate(int m, int d, int y) {
		day = d;
		month = m;
		year = y;
	}

	//DONE: return a string with month/day/year like “01/20/1964”  return "";
	public String toString(){  
		String formattedDate;
		
		formattedDate = month + "/" + day + "/" + year;
		return formattedDate;
	}
	
	// DONE: set the MyDate attributes with m, d, and y values here! 
	public void setDate(int m, int d, int y){   
		this.month = m;
		this.day = d;
		this.year = y;
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
}
