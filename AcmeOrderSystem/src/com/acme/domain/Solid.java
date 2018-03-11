/**
 * 
 */
package com.acme.domain;

/**
 * @author migui
 *
 */
public class Solid extends Good {
	private double width;
	private double length;
	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}
	/**
	 * @return the length
	 */
	public double getLength() {
		return length;
	}
	/**
	 * @param length the length to set
	 */
	public void setLength(double length) {
		this.length = length;
	}
	
	public Solid(String name, int modelNumber, double height, UnitOfMeasureType uoM, boolean flammable, double wgtPerUofM, double width, double length) 
	{   
		super(name, modelNumber, height, uoM, flammable, wgtPerUofM);   
		this.width = width;   
		this.length = length; 
	}
	
	public double volume() 
	{
		return width * length * getHeight(); 
	}
	
	public String toString() 
	{   
		return super.toString() + " that is " + volume() + " " + getUnitOfMeasure() + " in size"; 
	} 
}
