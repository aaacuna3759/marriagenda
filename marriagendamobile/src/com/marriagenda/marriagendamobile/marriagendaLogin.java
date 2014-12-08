package com.marriagenda.marriagendamobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class marriagendaLogin extends Activity {

	private Button mLoginButton;
	private Button mRegisterButton;
	private EditText mUsername;
	private EditText mPassword;
	private TextView mMessage;

	private String mPW;
	private String mUN;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_marriagenda);

		mLoginButton = (Button) findViewById(R.id.login_button);
		mRegisterButton = (Button) findViewById(R.id.register_button);
		mUsername = (EditText) findViewById(R.id.usernameField);
		mPassword = (EditText) findViewById(R.id.passwordField);
		mMessage = (TextView) findViewById(R.id.messages);

		Intent i = getIntent();
		String lastScreen = i.getStringExtra("LastActivity");

		if (lastScreen.equals("MarriagendaSplash")) {
			mPW = "admin";
			mUN = "Admin";
		} else if (lastScreen.equals("MarriagendaRegister")) {
			mPW = i.getStringExtra("password");
			mUN = i.getStringExtra("username");
		}

		mLoginButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (mUsername.getText().toString().equals(mUN)
						&& mPassword.getText().toString().equals(mPW)) {
					Intent i = new Intent(marriagendaLogin.this,
							MarriagendaActivity.class);
					i.putExtra("PreviousActivity", "marriagendaLogin");
					startActivity(i);

					finish();
				} else {
					mMessage.setText("Invalid Login");
				}
			}
		});

		mRegisterButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(marriagendaLogin.this,
						MarriagendaRegister.class);
				startActivity(i);

				finish();
			}
		});

	}

	public void connect() {

	}
}
