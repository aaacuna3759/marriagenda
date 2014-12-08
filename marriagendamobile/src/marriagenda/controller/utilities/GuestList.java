package marriagenda.controller.utilities;

import java.util.ArrayList;

public class GuestList {

	ArrayList<Entry<User>> guestList = new ArrayList<Entry<User>>();

	private class Entry<User> {
		public final static String YES = "Y";
		public final static String NO = "N";
		public final static String DONT_KNOW = "D";

		public User guest;
		public String attending;

		public Entry(User u, String decision) {
			guest = u;
			attending = decision;
		}

	}

	public GuestList() {
		// TODO Auto-generated constructor stub
	}

	void addGuest(User u) {
		guestList.add(new Entry<User>(u, Entry.DONT_KNOW));
	}

	public void removeGuest(User u) {
		guestList.remove(u);
	}

	void setDecision(User u, String dec) {
		Entry<User> temp = new Entry<User>(u, dec);

		guestList.remove(guestList.indexOf(u));
		guestList.add(temp);
	}

}
