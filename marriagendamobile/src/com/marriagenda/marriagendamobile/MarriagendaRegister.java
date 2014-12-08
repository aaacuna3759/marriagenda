package com.marriagenda.marriagendamobile;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MarriagendaRegister extends Activity {

	EditText mUsernameField, mPWField, mConfirmPWField;
	Button mRegisterButton;

	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup_marriagenda);

	}

}
