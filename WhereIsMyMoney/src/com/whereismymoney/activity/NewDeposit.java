package com.whereismymoney.activity;

import com.whereismymoney.R;
import com.whereismymoney.model.TransactionManager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * This class handles the activity associated with
 * creating a new deposit.
 */

public class NewDeposit extends Activity{

	private TransactionManager transactionManager;
	Bundle a;
	Button confirm, cancel;
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		this.onCreate(a);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		a = savedInstanceState;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_deposit);
		transactionManager = new TransactionManager();
		
		confirm = (Button) findViewById(R.id.button_confirm_deposit);
		cancel = (Button) findViewById(R.id.button_cancel_deposit);
		
		//this method handles the confirm button being clicked
		confirm.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				EditText source = (EditText) findViewById(R.id.edit_deposit_source);
			    EditText amount = (EditText) findViewById(R.id.edit_deposit_amount);
				EditText effectiveDate = (EditText) findViewById(R.id.edit_deposit_effective_date);
				
				if(source.getText().toString().matches("\\s*")) {
					AlertDialog newDepositFailAlert = new AlertDialog.Builder(NewDeposit.this).create();
			        newDepositFailAlert.setTitle("Deposit Failed");
			        newDepositFailAlert.setMessage("You didn't enter a source");
			        newDepositFailAlert.show();
				} else if(amount.getText().toString().matches("\\s*")) {
					AlertDialog newDepositFailAlert = new AlertDialog.Builder(NewDeposit.this).create();
			        newDepositFailAlert.setTitle("Deposit Failed");
			        newDepositFailAlert.setMessage("You didn't enter an amount");
			        newDepositFailAlert.show();
				} else if(effectiveDate.getText().toString().matches("\\s*")) {
					AlertDialog newDepositFailAlert = new AlertDialog.Builder(NewDeposit.this).create();
			        newDepositFailAlert.setTitle("Deposit Failed");
			        newDepositFailAlert.setMessage("You didn't enter an effective date");
			        newDepositFailAlert.show();
				} else if(amount.getText().toString().matches("[0-9]{0,}.[0-9]{2}")) {
					AlertDialog newDepositFailAlert = new AlertDialog.Builder(NewDeposit.this).create();
			        newDepositFailAlert.setTitle("Deposit Failed");
			        newDepositFailAlert.setMessage("Amount needs to be in the format #...#.##. Ex: 4.25");
			        newDepositFailAlert.show();
			        //this regex only checks for a valid format, doesn't make sure it is actually a valid date
				} else if(effectiveDate.getText().toString().matches("[0-9]{2}\\\\/[0-9]{2}\\\\/[0-9]{4}")) {
					AlertDialog newDepositFailAlert = new AlertDialog.Builder(NewDeposit.this).create();
			        newDepositFailAlert.setTitle("Deposit Failed");
			        newDepositFailAlert.setMessage("Date is not in the correct format. Correct format is mm/dd/yyyy");
			        newDepositFailAlert.show();
				} else if(transactionManager.newDeposit(source.getText().toString(), Double.parseDouble(amount.getText().toString()), effectiveDate.getText().toString())){
					//TODO
					//newDeposit returning true
				} else {
					//TODO
					//newDeposit returning false
				}
			}
		});
		
		//this method handles the cancel button being clicked
		cancel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent goBackToNewTransaction = new Intent("android.intent.action.NEWTRANSACTION");
				startActivity(goBackToNewTransaction);
			}
		});	
	}

}
