package com.marriagenda.marriagendamobile;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.UUID;

import marriagenda.controller.utilities.Event;
import marriagenda.controller.utilities.Location;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class NewEvent extends Activity {

	UUID eventID;
	Calendar eventDate = new GregorianCalendar();
	Location eventLocation;

	DatePickerDialog dpd;
	TimePickerDialog tpd;

	Event event;

	Button mCreateButton, mSetDateButton, mSetTimeButton;

	TextView mDateDisplay, mTimeDisplay;

	EditText mEventName, mEventAddress, mEventCity, mEventState, mEventZIP,
			mEventDescription;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_event);

		mEventName = (EditText) findViewById(R.id.event_name);
		mEventAddress = (EditText) findViewById(R.id.event_address);
		mEventCity = (EditText) findViewById(R.id.event_city);
		mEventState = (EditText) findViewById(R.id.event_state);
		mEventZIP = (EditText) findViewById(R.id.event_zip);
		mEventDescription = (EditText) findViewById(R.id.username_invite);

		mDateDisplay = (TextView) findViewById(R.id.date_display);
		mTimeDisplay = (TextView) findViewById(R.id.time_display);

		mSetDateButton = (Button) findViewById(R.id.select_date_button);
		mSetDateButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				dpd = new DatePickerDialog(NewEvent.this,
						new DatePickerDialog.OnDateSetListener() {
							@Override
							public void onDateSet(DatePicker view, int year,
									int monthOfYear, int dayOfMonth) {
								mDateDisplay.setText(dayOfMonth + "-"
										+ (monthOfYear + 1) + "-" + year);
								eventDate.set(year, monthOfYear, dayOfMonth);

							}

						}, 2016, 1, 1);
				dpd.show();

			}
		});

		mSetTimeButton = (Button) findViewById(R.id.select_time_button);
		if (mSetTimeButton != null) {
			Log.d("NewEvent", "mSetTimeButton not set to null");
		}
		mSetTimeButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				tpd = new TimePickerDialog(NewEvent.this, 0,
						new TimePickerDialog.OnTimeSetListener() {
							@Override
							public void onTimeSet(TimePicker view,
									int hourOfDay, int minute) {

								mTimeDisplay.setText(hourOfDay + ":" + minute);

							}
						}, 0, 0, true);
				tpd.show();
			}
		});

		mCreateButton = (Button) findViewById(R.id.create_event_button);
		mCreateButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				setLocation();
				generateUUID();

				Log.d("NewEvent", eventID.toString());
				Log.d("NewEvent", mEventName.getText().toString());
				Log.d("NewEvent", mEventDescription.getText().toString());
				Log.d("NewEvent", eventDate.toString());
				Log.d("NewEvent", eventLocation.toString());

				event = new Event(eventID, mEventName.getText().toString(),
						mEventDescription.getText().toString(), eventDate,
						eventLocation);

				Intent i = new Intent(NewEvent.this, MarriagendaActivity.class);
				i.putExtra("PreviousActivity", "NewEvent");
				i.putExtra("CreatedEvent", event);
				i.putExtra("Location", eventLocation);
				startActivity(i);
			}
		});
	}

	public void generateUUID() {
		eventID = UUID.randomUUID();
	}

	public void setLocation() {
		eventLocation = new Location("", mEventAddress.getText().toString(),
				mEventCity.getText().toString(), mEventState.getText()
						.toString(), Integer.parseInt(mEventZIP.getText()
						.toString()), "");
	}

}
