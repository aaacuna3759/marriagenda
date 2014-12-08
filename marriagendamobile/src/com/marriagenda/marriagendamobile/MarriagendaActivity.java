package com.marriagenda.marriagendamobile;

import marriagenda.controller.utilities.Event;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MarriagendaActivity extends FragmentActivity {

	private FragmentTabHost mTabHost;
	private Event createdEvent;
	private String mPreviousScreen;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Log.d("MarriagendaActivity", "about to get Previous Screen");
		mPreviousScreen = getIntent().getStringExtra("PreviousActivity");
		Log.d("MarriagendaActivity", "previous screen is " + mPreviousScreen);

		Bundle b = new Bundle();

		if (mPreviousScreen.equals("marriagendaLogin")) {
			createdEvent = (Event) getIntent().getSerializableExtra(
					"CreatedEvent");
			b.putSerializable("CreatedEvent", createdEvent);
		} else if (mPreviousScreen.equals("NewEvent")) {
			b.putBoolean("MadeNewEvent", true);
		}

		setContentView(R.layout.activity_marriagenda);

		Log.d("MarriagendaActivity", "about to make tabs");

		mTabHost = (FragmentTabHost) findViewById(R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

		mTabHost.addTab(
				mTabHost.newTabSpec("adminTab").setIndicator("My Events"),
				Admin_Fragment.class, b);
		mTabHost.addTab(
				mTabHost.newTabSpec("guestTab").setIndicator("My Invites"),
				Guest_Fragment.class, b);

		Log.d("MarriagendaActivity", "Tab making completed");

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.marriagenda, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
