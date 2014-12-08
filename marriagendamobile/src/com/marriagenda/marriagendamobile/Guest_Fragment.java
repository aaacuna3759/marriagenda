package com.marriagenda.marriagendamobile;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.UUID;

import marriagenda.controller.utilities.Event;
import marriagenda.controller.utilities.Location;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Guest_Fragment extends Fragment {

	private static final String TAG = "Guest_Fragment";

	private ArrayList<Event> mEvents = new ArrayList<Event>();
	private ArrayList<String> mEventNames = new ArrayList<String>();
	private ArrayList<Calendar> mEventDates = new ArrayList<Calendar>();
	private ArrayList<Location> mEventLocations = new ArrayList<Location>();

	ListView eventList;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Calendar cal = new GregorianCalendar();
		cal.set(2015, 03, 31);
		Location loc = new Location("The Cathedral", "169 Pluto Dr", "Boston",
				"MA", 22134, "Turn right on Planetarium Dr going North");

		mEvents.add(new Event(UUID.randomUUID(), "Dan and Maria's Wedding",
				"Free Alcohol!", cal, loc));
		mEventDates.add(cal);
		mEventLocations.add(loc);

		cal = new GregorianCalendar();
		cal.set(2015, 03, 31);
		loc = new Location("Elmo's House", "123 Sesame Street",
				"New York City", "NY", 11234, "Everyone knows this place");

		mEvents.add(new Event(
				UUID.randomUUID(),
				"Ashley and Tom Tie the Knot",
				"Come join us on this wonderful day, we'd love to have you here",
				cal, loc));

		updateList();

	}

	public View onCreateView(LayoutInflater inflater, ViewGroup parent,
			Bundle savedInstanceState) {

		View v = inflater
				.inflate(R.layout.guest_fragment_layout, parent, false);

		// setting the layout
		eventList = (ListView) v.findViewById(R.id.list);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, mEventNames);

		eventList.setAdapter(adapter);

		eventList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent i = new Intent(getActivity(), ViewEvent.class);
				i.putExtra("Event", mEvents.get(position));
				i.putExtra("Date", mEventDates.get(position));
				i.putExtra("Location", mEventLocations.get(position));
				startActivity(i);
			}
		});

		return v;
	}

	private void updateList() {
		for (Event ev : mEvents) {
			mEventNames.add(ev.getName());
		}
	}

}
