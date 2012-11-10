/**
 * Package: com.project5.dataElements
 */
package com.project5.dataElements;

/**
 * @author Svetoslav Kostadinov
 *
 *The Curler Player Class is specifying the model for objects Player. 
 *
 *data elements: firstName(String), lastName(String) and position(CurlerPosition)
 */
public class CurlerPlayer {

	private String firstName;
	private String lastName;
	private CurlerPosition position; 
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the position
	 */
	public CurlerPosition getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(CurlerPosition position) {
		this.position = position;
	}
	
	/**
	 * CurlerPlayer constructor
	 * @param firstName
	 * @param lastName
	 * @param position
	 */
	public CurlerPlayer(String firstName, String lastName, CurlerPosition position) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
	}
	
	/**
	 * toString method, required by the specification. 
	 */
	public String toString(){
		return this.firstName + " " + this.lastName + ": "+ this.position;
	}
	
	
}
