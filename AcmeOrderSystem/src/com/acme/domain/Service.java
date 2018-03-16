/**
 * 
 */
package com.acme.domain;

/**
 * @author migui
 *
 */
public class Service implements Product {
	private String name;
	private int estimatedTaskDuration;
	private boolean timeAndMaterials;
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
	 * @return the estimatedTaskDuration
	 */
	public int getEstimatedTaskDuration() {
		return estimatedTaskDuration;
	}
	/**
	 * @param estimatedTaskDuration the estimatedTaskDuration to set
	 */
	public void setEstimatedTaskDuration(int estimatedTaskDuration) {
		this.estimatedTaskDuration = estimatedTaskDuration;
	}
	/**
	 * @return the timeAndMaterials
	 */
	public boolean isTimeAndMaterials() {
		return timeAndMaterials;
	}
	/**
	 * @param timeAndMaterials the timeAndMaterials to set
	 */
	public void setTimeAndMaterials(boolean timeAndMaterials) {
		this.timeAndMaterials = timeAndMaterials;
	}
	
	public Service(String name, int duration, boolean timeAndMaterials) {   
		this.estimatedTaskDuration = duration;   
		this.name = name;   
		this.timeAndMaterials = timeAndMaterials; 
	} 
	
	public String toString() {
		return this.name + " with an ETA of: " + this.estimatedTaskDuration;
	}
}
