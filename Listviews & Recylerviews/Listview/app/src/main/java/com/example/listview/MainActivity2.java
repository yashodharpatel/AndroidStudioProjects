package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
	TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);

		Intent intent = getIntent();
		String courseName = intent.getStringExtra(MainActivity.EXTRA_COURSE_NAME);

		textView = findViewById(R.id.textView2);
		textView.setText(courseName);

		setTitle(courseName);
	}
}