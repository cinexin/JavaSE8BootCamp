/**
 * 
 */
package com.acme.domain;

import com.acme.utils.MyDate;

/**
 * @author migui
 *
 */
public interface Rushable {
	public abstract boolean isRushable(MyDate orderDate, double amount);

}
