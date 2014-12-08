package com.marriagenda.marriagendamobile;

import java.util.GregorianCalendar;

import marriagenda.controller.utilities.Event;
import marriagenda.controller.utilities.Location;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EventInvite extends Activity {

	private static final String TAG = "EventInvite";

	TextView mEventTitle;
	TextView mEventDescription;
	TextView mEventDate;
	TextView mEventAddress;
	TextView mEventCity;
	TextView mEventState;
	TextView mEventZip;
	TextView mEventPlace;
	TextView mLocationComment;

	EditText mEmailField;
	EditText mUsernameField;

	Button mInvite;

	Event event;
	GregorianCalendar cal;
	Location loc;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.event_edit);

		Log.d(TAG, "onCreateCalled");

		mEventTitle = (TextView) findViewById(R.id.event_title);
		mEventDescription = (TextView) findViewById(R.id.event_description);
		mEventDate = (TextView) findViewById(R.id.event_date);
		mEventAddress = (TextView) findViewById(R.id.event_address);
		mEventCity = (TextView) findViewById(R.id.event_city);
		mEventState = (TextView) findViewById(R.id.event_state);
		mEventZip = (TextView) findViewById(R.id.event_zip);
		mEventPlace = (TextView) findViewById(R.id.event_place);
		mLocationComment = (TextView) findViewById(R.id.location_comments);

		mEmailField = (EditText) findViewById(R.id.email_invite);
		mUsernameField = (EditText) findViewById(R.id.username_invite);

		mInvite = (Button) findViewById(R.id.invite_button);

		Log.d(TAG, "Succesfully Found all components");

		Intent i = getIntent();

		Log.d(TAG, "Attempting to retrieve passed info");
		event = (Event) i.getSerializableExtra("Event");
		loc = (Location) i.getSerializableExtra("Location");
		Log.d(TAG, "Succesfully retrieved event " + event.getName());

		if (loc == null) {
			Log.d(TAG, "loc is null");
		}

		mInvite.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				String inviteToast = "invite sent to ";
				inviteToast += mUsernameField.getText().toString();

				Toast.makeText(EventInvite.this, inviteToast,
						Toast.LENGTH_SHORT).show();

			}
		});

		mEventTitle.setText("   " + event.getName());
		mEventDescription.setText(event.getDescription());
		Log.d(TAG, "Attempting to set Date");
		mEventDate.setText("12-15-2016");
		mEventAddress.setText("   " + loc.getAddress());
		mEventCity.setText("  " + loc.getCity());
		Log.d(TAG, "1");
		mEventState.setText("  " + loc.getState());
		Log.d(TAG, "2");
		mEventZip.setText("  " + Integer.toString(loc.getZip()));
		Log.d(TAG, "3");
		mEventPlace.setText(loc.getName());
		mLocationComment.setText(loc.getComments());

	}

}
