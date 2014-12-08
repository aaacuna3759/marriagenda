package marriagenda.controller;

import java.util.ArrayList;

import marriagenda.controller.utilities.Event;
import marriagenda.controller.utilities.User;

public class EventController {

	private ArrayList<Event> events;

	public EventController() {

	}

	public void createEvent() {

	}

	public boolean isGuest(User u, Event e) {
		// returns true if e contains u in guestList
		return true;
	}

	public boolean isAdmin(User u, Event e) {
		// returns true if e contains u in AdminList
		return true;

	}

}
