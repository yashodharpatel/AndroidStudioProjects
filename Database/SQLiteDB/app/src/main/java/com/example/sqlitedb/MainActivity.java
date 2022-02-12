package com.example.sqlitedb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Employee employee = new Employee(01, "Yashodhar", 34.90);
		DBHandler dbHandler = new DBHandler(MainActivity.this);
		dbHandler.addEmployee(employee);
		dbHandler.getEmployee(01);
		dbHandler.close();
	}
}