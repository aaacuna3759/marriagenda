package marriagenda.controller.utilities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import android.util.Log;

public class Event implements Serializable {

	private UUID eventID;
	private String eventName, eventDescription;
	private AdminList eventAdmins;
	public GuestList eventGuests;
	private Calendar eventDate;
	private Location eventVenue;
	private ArrayList<String> comments = new ArrayList<String>();

	public Event(UUID eID, String name, String description,/* User[3] admins, */
			Calendar date, Location venue) {
		eventID = eID;
		eventName = name;
		eventDescription = description;
		Calendar eventDate = date;
		Location eventVenue = new Location(venue.getName(), venue.getAddress(),
				venue.getCity(), venue.getState(), venue.getZip(),
				venue.getComments());
	}

	public Event() {

	}

	public UUID getEventID() {
		return eventID;
	}

	public void addGuest(User u) {
		eventGuests.addGuest(u);
	}

	public Calendar getDate() {
		return this.eventDate;
	}

	public Location getVenue() {
		return eventVenue;
	}

	public String toString() {
		return this.eventName;
	}

	public String getName() {
		return this.eventName;
	}

	public void setName(String n) {
		eventName = n;
	}

	public String getDescription() {
		return this.eventDescription;
	}

	public void addDescription(String d) {
		this.eventDescription = d;
	}

	public void setDate(Calendar d) {
		this.eventDate = d;
	}

	public void setVenue(Location v) {
		this.eventVenue = v;
	}

	public GuestList getGuests() {
		return this.eventGuests;
	}

	public void setDecision(User u, String dec) {
		eventGuests.setDecision(u, dec);
	}

	public ArrayList<String> getComments() {
		return this.comments;
	}

}
