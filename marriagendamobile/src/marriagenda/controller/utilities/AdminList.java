package marriagenda.controller.utilities;

/*
 * marriAGENDA AdminList class
 * Author: Robyn Cute
 * 
 * This class allows three admins to be
 * set for the event.
 */

public class AdminList {

	private User bride;
	private User groom;
	private User planner;
	
	public AdminList(User bride, User groom, User planner ){
		
		this.bride = bride;
		this.groom = groom;
		this.planner = planner;
		
	}
	//Getter for bride
	public User getBride() {
		 
		return this.bride;
	}
	
	//Setter for bride
	public void setBride(User bride) {
		
		this.bride = bride;
	}
	
	//Getter for groom
	public User getGroom() {
		
		return this.groom;
	}
	
	//Setter for groom
	public void setGroom(User groom) {
		
		this.groom = groom;
		
	}
	
	//Getter for planner
	public User getPlanner() {
		
		return this.planner;
	}
	
	//Setter for planner
	public void setPlanner(User planner) {
		
		this.planner = planner;
	}
}