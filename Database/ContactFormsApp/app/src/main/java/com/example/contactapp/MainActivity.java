package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
	Button button;
	EditText editTextTextPersonName;
	EditText editTextPhone;
	EditText editTextTextEmailAddress;
	EditText editTextTextMultiLine;
	DBHandler dbHandler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		button = findViewById(R.id.button);
		editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
		editTextPhone = findViewById(R.id.editTextPhone);
		editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
		editTextTextMultiLine = findViewById(R.id.editTextTextMultiLine);

		dbHandler = new DBHandler(MainActivity.this);
	}

	public void onClick(View view) {
		String name = editTextTextPersonName.getText().toString();
		String phone = editTextPhone.getText().toString();
		String email = editTextTextEmailAddress.getText().toString();
		String concern = editTextTextMultiLine.getText().toString();

		if(TextUtils.isEmpty(name) || TextUtils.isEmpty(phone) || TextUtils.isEmpty(email) || TextUtils.isEmpty(concern)){
			Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
		}
		else {
			dbHandler.addNewContact(name, phone, email, concern);
			Intent intent = new Intent(this, MainActivity2.class);
			startActivity(intent);
			editTextTextPersonName.setText("");
			editTextPhone.setText("");
			editTextTextEmailAddress.setText("");
			editTextTextMultiLine.setText("");
		}
	}
}