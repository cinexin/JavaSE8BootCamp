/**
 * 
 */
package com.acme.utils;

/**
 * @author migui
 *
 */
public class HolidayOrdersNotAllowedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5846536333840616032L;

	public HolidayOrdersNotAllowedException(MyDate date) {
		super("Orders are not allowed to be created on the following date, since it's a holiday: " + date);
	}
}
