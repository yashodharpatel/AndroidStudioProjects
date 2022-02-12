package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
	TextView textView;
	TextView textView2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);

		Intent intent = getIntent();
		String name = intent.getStringExtra(ContactAdapter.EXTRA_NAME);
		String phone = intent.getStringExtra(ContactAdapter.EXTRA_PHONE);

		textView = findViewById(R.id.textView);
		textView2 = findViewById(R.id.textView2);

		textView.setText(name);
		textView2.setText(phone);

		setTitle(name);
	}
}