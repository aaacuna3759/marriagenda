package com.marriagenda.marriagendamobile;

import java.util.ArrayList;

import marriagenda.controller.utilities.Event;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * Fragment to be displayed on MarriagendaActivity when the "My Events" tab is
 * selected.
 * 
 * @author Andres
 * 
 */
public class Admin_Fragment extends Fragment {

	private static final String TAG = "Admin_Fragment";

	private ListView eventList;
	private ArrayList<Event> mEventList = new ArrayList<Event>();
	private ArrayList<String> mEventNames = new ArrayList<String>();
	// set to the next empty space, if there is 3 objects (0,1,2), index = 3
	private int mEventIndex;
	private boolean newEvent;

	private Event createdEvent = null;

	Button mNewEventButton;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "OnCreate() Called");

		Log.d(TAG, "Size of mEventList is " + mEventList.size());

		if (mEventList.size() == 0) {
			Event spacer = new Event();
			spacer.setName("Events Shown Below");
			mEventList.add(spacer);
		}

		newEvent = getArguments().getBoolean("MadeNewEvent", false);

		if (newEvent) {
			createdEvent = (Event) getActivity().getIntent()
					.getSerializableExtra("CreatedEvent");
			mEventList.add(createdEvent);
		}

		updateList();

	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		Log.d(TAG, "OnCreateView() Called");

		View v = inflater.inflate(R.layout.admin_fragment_layout, container,
				false);

		// setting the layout
		eventList = (ListView) v.findViewById(R.id.list);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, mEventNames);

		eventList.setAdapter(adapter);

		// Taking care of the button
		mNewEventButton = (Button) v.findViewById(R.id.new_event_button);
		mNewEventButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent i = new Intent(getActivity(), NewEvent.class);
				startActivity(i);

			}
		});

		return v;

	}

	private void updateList() {
		for (Event ev : mEventList) {
			mEventNames.add(ev.getName());
		}

		mEventIndex = mEventList.size();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

		outState.putSerializable("key", mEventList);
	}

	@Override
	public void onStart() {
		super.onStart();
		Log.d(TAG, "onStart() called");
	}

	@Override
	public void onPause() {
		super.onPause();
		Log.d(TAG, "onPause() called");
	}

	@Override
	public void onResume() {
		super.onResume();
		Log.d(TAG, "onResume() called");
	}

	@Override
	public void onStop() {
		super.onStop();
		Log.d(TAG, "onStop() called");

	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d(TAG, "onDestroy() called");
	}

}
