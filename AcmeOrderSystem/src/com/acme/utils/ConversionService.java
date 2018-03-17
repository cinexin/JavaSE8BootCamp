package com.acme.utils;

public class ConversionService {
	/**
	 * weight conversion rates
	 */
	// conversion rate for 1 kilogram to pounds
	public static double kilogramToPounds = 2.2046;
	// conversion rate for 1 kilogram to grams
	public static int kilogramToGrams = 1000;
	// conversion rate for 1 kilogram to weight ounces
	public static double kilogramToOunces = 35.274;

	/**
	 * volume conversion rates
	 */
	// conversion rate for 1 liter to fluid ounces
	public static float literToFluidOunce = 33.814f;
	// conversion rate for 1 liter to gallons
	public static float literToGallon = 0.2642f;
	// conversion rate for 1 liter to pints
	public static float literToPints = 2.1134f;
	// conversion rate for 1 liter to milliliters
	public static short literToMilliliters = 1_000;

	/**
	 * Converts kilograms (passed as a parameter) to pounds
	 * 
	 * @param kilograms
	 * @return pounds
	 */
	public static double pounds(double kilograms) {
		return kilograms * kilogramToPounds;
	}

	/**
	 * Converts kilograms (passed as a parameter) to grams
	 * 
	 * @param kilograms
	 * @return grams
	 */
	public static int grams(int kilograms) {
		return kilograms * kilogramToGrams;
	}

	/**
	 * Converts kilograms (passed as a parameter) to ounces
	 * 
	 * @param kilograms
	 * @return ounces
	 */
	public static double ounces(double kilograms) {
		return kilograms * kilogramToOunces;
	}

	/**
	 * Converts liters (passed as a parameter) to fluid ounces
	 * 
	 * @param liters
	 * @return fluid ounces
	 */
	public static float fluidOunces(float liters) {
		return liters * literToFluidOunce;
	}

	/**
	 * Converts liters (passed as a parameter) to gallons
	 * 
	 * @param liters
	 * @return gallons
	 */
	public static float gallons(float liters) {
		return liters * literToGallon;
	}

	/**
	 * Converts liters (passed as a parameter) to pints
	 * 
	 * @param liters
	 * @return pints
	 */
	public static float pints(float liters) {
		return liters * literToPints;
	}

	/**
	 * Convert liters (passed as a parameter) to milliliters
	 * 
	 * @param liters
	 * @return milliliters
	 */
	public static int milliLiters(int liters) {
		return liters * literToMilliliters;
	}
	
	/**
	 * 
	 * @param kilogramValues (N values containing kgs to convert)
	 * @return a 2-d array containing the conversions:
	 * 	column 0: kgs
	 * 	column 1: equivalent in pounds
	 */
	public static double[][] allKgToPounds(double... kilogramValues)
	{
		double[][] conversionTable = new double[kilogramValues.length][kilogramValues.length];
		
		for (int i=0; i < kilogramValues.length; i++) {
			conversionTable[i][0] = kilogramValues[i];
			conversionTable[i][1] = pounds(kilogramValues[i]);
		}
		
		return conversionTable;
	}
}
