package com.acme.utils;

public class InvalidDateException extends Exception{
	
	public InvalidDateException(int day, int month, int year) {
		super("The date " + day + "/" + month + "/" + year  + " is not valid");
	}
}
