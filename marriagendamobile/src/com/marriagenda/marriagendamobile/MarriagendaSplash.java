package com.marriagenda.marriagendamobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MarriagendaSplash extends Activity {

	private static int SPLASH_TIME = 3000;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.marriagenda_splash);

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {

				Intent i = new Intent(MarriagendaSplash.this,
						MarriagendaActivity.class);
				startActivity(i);

				finish();
			}
		}, SPLASH_TIME);

	}

}
