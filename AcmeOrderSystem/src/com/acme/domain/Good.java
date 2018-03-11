/**
 * 
 */
package com.acme.domain;

/**
 * @author migui
 * Class to model the product in an order
 *
 */
public class Good {
	public enum UnitOfMeasureType {LITER, GALLON, CUBIC_METER, CUBIC_FEET}
	
	private String name; 
	private int modelNumber; 
	private double height; 
	private UnitOfMeasureType unitOfMeasure; 
	private boolean flammable = true;
	private double weightPerUofM;
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the modelNumber
	 */
	public int getModelNumber() {
		return modelNumber;
	}
	/**
	 * @param modelNumber the modelNumber to set
	 */
	public void setModelNumber(int modelNumber) {
		this.modelNumber = modelNumber;
	}
	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	/**
	 * @return the unitOfMeasure
	 */
	public UnitOfMeasureType getUnitOfMeasure() {
		return unitOfMeasure;
	}
	/**
	 * @param unitOfMeasure the unitOfMeasure to set
	 */
	public void setUnitOfMeasure(UnitOfMeasureType unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}
	/**
	 * @return the flammable
	 */
	public boolean isFlammable() {
		return flammable;
	}
	/**
	 * @param flammable the flammable to set
	 */
	public void setFlammable(boolean flammable) {
		this.flammable = flammable;
	}
	/**
	 * @return the weightPerUofM
	 */
	public double getWeightPerUofM() {
		return weightPerUofM;
	}
	/**
	 * @param weightPerUofM the weightPerUofM to set
	 */
	public void setWeightPerUofM(double weightPerUofM) {
		this.weightPerUofM = weightPerUofM;
	} 

	public Good(String name, int modelNumber, double height, UnitOfMeasureType unitOfMeasure, boolean flammable, double weightPerUofM )
	{
		this.name = name;
		this.modelNumber = modelNumber;
		this.height = height;
		this.unitOfMeasure = unitOfMeasure;
		this.flammable = flammable;
		this.weightPerUofM = weightPerUofM;
	}
	
	public String toString() 
	{   
		return name + "-" + modelNumber; 
	}
	
	public double volume() 
	{   
		return 0.0; 
	}
	
	public double weight() 
	{   
		return volume() * weightPerUofM; 
	}
	
	public final boolean canShipViaPostOffice() 
	{
		if (!this.isFlammable() && this.weight() < 200) {
			return true;
		} else {
			return false;
		}
			
	}
}
