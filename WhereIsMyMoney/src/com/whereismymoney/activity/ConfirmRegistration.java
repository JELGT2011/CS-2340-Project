package com.whereismymoney.activity;

/**
 * This class handles the registration screen that new users go to
 * right after they have registered. It includes buttons that 
 * take then to register another account or to the login page.
 */

import com.whereismymoney.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmRegistration extends Activity {

	@SuppressLint("NewApi")
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirm_registration);


		Button login = (Button) findViewById(R.id.button_goToLoginFromConfirmRegistration);
		Button createAnotherNewAccount = (Button) findViewById(R.id.button_goToRegisterFromConfirmRegistration);
	
		//the button that sends the user to the login page
		login.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent goToLogin = new Intent("android.intent.action.LOGIN");
				startActivity(goToLogin);
			}
		});
	
		//the button that sends the user back to the registration page to register another account
		createAnotherNewAccount.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent goToRegister = new Intent("android.intent.action.REGISTER");
				startActivity(goToRegister);
			}
		});	
	}
}