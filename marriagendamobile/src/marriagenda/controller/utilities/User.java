package marriagenda.controller.utilities;

import java.util.Date;

public class User {

	private String firstName, lastName, userName, email;
	Date dob = new Date();

	// Integer userID;

	public User(String fName, String lName, Date dob, String email) {
		setFirstName(fName);
		setLastName(lName);
		setDOB(dob);
		setEmail(email);
	}

	public User() {
		this.firstName = null;
		this.lastName = null;
		this.dob = null;
		this.email = null;
	}

	String getUsername() {
		return this.userName;
	}

	String getFirstName() {
		return this.firstName;
	}

	String getLastName() {
		return this.lastName;
	}

	Date getDOB() {
		return dob;
	}

	// Integer getUserID(){
	// return userID;
	// }

	void setUsername(String u) {
		this.userName = u;
	}

	void setFirstName(String fN) {
		this.firstName = fN;
	}

	void setLastName(String lN) {
		this.lastName = lN;
	}

	void setDOB(Date d) {
		dob = d;
	}

	void setEmail(String m) {
		this.email = m;
	}

}
