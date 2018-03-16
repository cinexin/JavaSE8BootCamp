package com.acme.domain;
import com.acme.domain.Good.UnitOfMeasureType;
import com.acme.utils.MyDate;

public class Order {
	private MyDate orderDate;
	private double orderAmount = 0.00;
	private String customer;
	private Product product;
	private int quantity;
	
	private static double taxRate;
	
		
	/**
	 * @return the orderDate
	 */
	public MyDate getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(MyDate orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the orderAmount
	 */
	public double getOrderAmount() {
		return orderAmount;
	}

	/**
	 * @param orderAmount the orderAmount to set
	 */
	public void setOrderAmount(double orderAmount) {
		if (orderAmount >= 0)
			this.orderAmount = orderAmount;
		else {
			System.out.println("Error: you're trying to set a negative amount, falling to default amount (0)...");
			this.orderAmount = 0; // set a default
		}
	}

	/**
	 * @return the customer
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		if (quantity >= 0) 
		{
			this.quantity = quantity;
		} else 
		{
			System.out.println("Error: you're trying to assign a negative quantity. Falling to default quantity (0)");
			this.quantity = 0;
		}
	}

	/**
	 * @return the taxRate
	 */
	public static double getTaxRate() {
		return taxRate;
	}

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
	
	public Order(MyDate d, double amt, String c, Product p, int q){
		orderDate=d;
		orderAmount=amt;
		customer=c;
		product=p;
		quantity=q;
	}
	
	
	public String toString(){
		return quantity + " ea. " + product + " for " + customer; 
	}
}
