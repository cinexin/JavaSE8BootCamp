/**
 * 
 */
package com.acme.domain;

/**
 * @author migui
 *
 */
public class Liquid extends Good {

	private double radius;

	/**
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public Liquid(String name, int modelNumber, double height, UnitOfMeasureType uoM, boolean flammable, double wgtPerUofM, double radius) 
	{   
		super(name, modelNumber, height, uoM, flammable, wgtPerUofM);   
		this.radius = radius; 
	}
	
	public double volume()  {
		return Math.PI * Math.pow(this.radius , 2) * getHeight();
	}
	
	public String toString() {   
		return super.toString() + " (liquid) " + volume() + " " + getUnitOfMeasure(); 
	} 
}
