/**
 * 
 */
package com.acme.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author migui
 * Class to model the product in an order
 *
 */
public abstract class Good implements Product{
	public enum UnitOfMeasureType {LITER, GALLON, CUBIC_METER, CUBIC_FEET}
	
	private String name; 
	private int modelNumber; 
	private double height; 
	private UnitOfMeasureType unitOfMeasure; 
	private boolean flammable = true;
	private double weightPerUofM;
	private static List catalog;
	
	static {
		Liquid glue = new Liquid("Acme Glue", 2334, 4, UnitOfMeasureType.LITER,false, 15, 6);
		Liquid paint = new Liquid("Acme Invisible Paint", 2490, 0.65,UnitOfMeasureType.GALLON, true, 0.70, 12);
		Solid anvil = new Solid("Acme Anvil", 1668, 0.3,UnitOfMeasureType.CUBIC_METER, false, 500, 0.25, 0.3);
		Solid safe = new Solid("Acme Safe", 1672, 1.0,UnitOfMeasureType.CUBIC_METER, false, 300, 0.5, 0.5);
		Solid balloon = new Solid("Acme Balloon", 1401, 15,UnitOfMeasureType.CUBIC_FEET, false, 10, 5, 5);
		Solid pistol = new Solid("Acme Disintegrating Pistol", 1587, 0.1,UnitOfMeasureType.CUBIC_FEET, false, 1, 0.5, 2);
		Liquid nitro = new Liquid("Acme Nitroglycerin", 4289, 1.0,UnitOfMeasureType.CUBIC_METER, true, 1.5, 0.25);
		Liquid oil = new Liquid("Acme Oil", 4275, 1.0,UnitOfMeasureType.CUBIC_METER, true, 1.5, 0.25);
		
		catalog = new ArrayList<>();
		catalog.add(anvil);
		catalog.add(safe);
		catalog.add(balloon);
		catalog.add(pistol);
		catalog.add(nitro);
		catalog.add(oil);
		catalog.add(glue);
		catalog.add(paint);
	}
	
	/**
	 * @return the catalog
	 */
	public static List getCatalog() {
		return catalog;
	}
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
	
	public abstract double volume(); 

	
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
	
	public static Set flammablesList() {
		Set flammables = new HashSet<>();
		Iterator i = Good.getCatalog().iterator();
		while (i.hasNext()) {
			Good good = (Good) i.next();
			if (good.isFlammable()) {
				flammables.add(good);
			}
		}
		
		return flammables;
	}
}
