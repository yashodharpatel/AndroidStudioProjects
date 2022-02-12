package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
	Button startQuiz;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void setStartQuiz(View view){
		startQuiz = findViewById(R.id.startQuiz);
		Intent intent = new Intent(this, MainActivity2.class);
		startActivity(intent);
	}
}