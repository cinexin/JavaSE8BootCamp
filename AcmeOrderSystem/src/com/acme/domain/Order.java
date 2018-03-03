package com.acme.domain;
import com.acme.utils.MyDate;

public class Order {
	MyDate orderDate;
	double orderAmount = 0.00;
	String customer;
	String product;
	int quantity;
	
	public static double taxRate;
	
	static {
		taxRate = 0.05;
	}
	
	public static void setTaxRate (double newRate) {
		taxRate = newRate;
	}
	
	public static void computeTaxOn (double anAmount) {
		System.out.println("The tax for " + anAmount + " is: " + anAmount * Order.taxRate );
	}
	
	public double computeTax () {
		System.out.println("The tax for this order is: " + orderAmount * Order.taxRate);
		return orderAmount * Order.taxRate;
	}
	
	public char jobSize() {
		if (this.quantity <= 25) {
			return 'S';
		} else {
			if (this.quantity > 25 && this.quantity <= 75) {
				return 'M';
			} else {
				if (this.quantity > 75 && this.quantity <= 150) {
					return 'L';
				} else {
					return 'X';
				}
			}
		}
	}
	
	/**
	 * Computes the total price of the order according to formula:
	 * Order total = order amount - discount (if applicable) + tax (if applicable)
	 * @return the total price of the order 
	 */
	public double computeTotal()  {
		double finalAmount = 0.0;
		double orderTax = this.orderAmount > 1500 ? 0.0 : this.computeTax();
		char orderSize = jobSize();
		double discount = 0.0; 
		
		switch (orderSize) {
			case 'S':
				discount = 0.0;
				break;
			case 'M':
				discount = 0.01;
				break;
			case 'L':
				discount = 0.02;
				break;
			case 'X':
				discount = 0.03;
				break;
			default:
				discount = 0.0;
				break;
		}
		
		finalAmount = this.orderAmount - (this.orderAmount * discount) + orderTax;
		return finalAmount;
	}
	
	public Order(MyDate d, double amt, String c, String p, int q){
		orderDate=d;
		orderAmount=amt;
		customer=c;
		product=p;
		quantity=q;
	}
	
	public Order(MyDate d, double amt, String c) {       
		this(d,amt,c,"Anvil", 1);
     
	}
	
	public String toString(){
		return quantity + " ea. " + product + " for " + customer; 
	}
}
