package com.marriagenda.marriagendamobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MarriagendaRegister extends Activity {

	EditText mUsernameField, mPWField, mConfirmPWField;
	Button mRegisterButton;

	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup_marriagenda);

		mUsernameField = (EditText) findViewById(R.id.usernameField);
		mPWField = (EditText) findViewById(R.id.passwordField);
		mConfirmPWField = (EditText) findViewById(R.id.ConfirmPWField);
		mRegisterButton = (Button) findViewById(R.id.register_button);

		mRegisterButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (mPWField.getText().toString()
						.equals(mConfirmPWField.getText().toString())) {
					String toast = "Thank you for signing up "
							+ mUsernameField.getText().toString();
					Toast.makeText(MarriagendaRegister.this, toast,
							Toast.LENGTH_SHORT).show();

					Intent i = new Intent(MarriagendaRegister.this,
							marriagendaLogin.class);
					i.putExtra("username", mUsernameField.getText().toString());
					i.putExtra("password", mPWField.getText().toString());
					i.putExtra("LastActivity", "MarriagendaRegister");
					startActivity(i);
				} else {
					String toast = "Passwords dont match!!";
					Toast.makeText(MarriagendaRegister.this, toast,
							Toast.LENGTH_LONG).show();
				}
			}
		});

	}
}
