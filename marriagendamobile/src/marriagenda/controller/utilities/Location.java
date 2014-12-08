package marriagenda.controller.utilities;

import java.io.Serializable;

/*
 * marriAGENDA Location class
 * Author: Robyn Cute
 * 
 * This class sets the location of the event, as
 * input by an administrator.
 */

public class Location implements Serializable {

	private String name;
	private String address;
	private String city;
	private String state;
	private Integer zip;
	private String comments;

	public Location(String name, String address, String city, String state,
			Integer zip, String comments) {

		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.comments = comments;

	}

	// Sets the initial values to be blank
	public Location() {
		name = "";
		address = "";
		city = "";
		state = "";
		zip = 00000;
		comments = "";

	}

	// Getter for name
	public String getName() {

		return name;
	}

	// Setter for name
	public void setName(String name) {

		this.name = name;
	}

	// Getter for address
	public String getAddress() {

		return address;
	}

	// Setter for address
	public void setAddress(String address) {

		this.address = address;
	}

	// Getter for city
	public String getCity() {

		return city;

	}

	// Setter for city
	public void setCity(String city) {

		this.city = city;
	}

	// Getter for State
	public String getState() {

		return state;
	}

	// Setter for State
	public void setState(String state) {

		this.state = state;
	}

	// Getter for zip
	public int getZip() {

		return zip;
	}

	// Setter for zip
	public void setZip(Integer zip) {

		this.zip = zip;
	}

	// Getter for comments
	public String getComments() {

		return comments;

	}

	// Setter for comments
	public void setComments(String comments) {

		this.comments = comments;
	}

	public String toString() {
		return name + "\n" + address + "\n" + city + ", " + state + " " + zip;

	}

}
