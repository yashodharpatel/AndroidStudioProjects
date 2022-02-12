package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
	TextView textViewScore;
	TextView textViewPercentage;
	TextView message;
	TextView textView3;
	Button restart;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main3);

		textViewScore = findViewById(R.id.textViewScore);
		textViewPercentage = findViewById(R.id.textViewPercentage);
		message = findViewById(R.id.message);
		textView3 = findViewById(R.id.textView3);

		Intent intent = getIntent();
		String queLen = intent.getStringExtra(MainActivity2.EXTRA_QUESTION_LENGTH);
		String score = intent.getStringExtra(MainActivity2.EXTRA_SCORE);
		String percentage = intent.getStringExtra(MainActivity2.EXTRA_PERCENTAGE);

		textViewScore.setText("Score: "+score+" of "+queLen);
		textViewPercentage.setText("Percentage: "+percentage+"%");

		int scoreInt = Integer.parseInt(score);
		if ((scoreInt >= 0 ) && (scoreInt <= 3)) {
			message.setText("You must study much harder!");
			textView3.setText("Always read question carefully before answer. There is no time limit");
		} else if ((scoreInt >= 4 ) && (scoreInt <= 6)) {
			message.setText("Not Sufficent! You must study more!");
			textView3.setText("Always read question carefully before answer. There is no time limit");
		} else if ((scoreInt >= 7 ) && (scoreInt <= 8)) {
			message.setText("Almost! Study a little more and take the test again!");
			textView3.setText("Always read question carefully before answer. There is no time limit");
		} else if ((scoreInt >= 9 ) && (scoreInt <= 10)) {
			message.setText("You can be proud of yourself!");
		}
	}

	public  void restartQuiz(View view){
		restart = findViewById(R.id.restartQuiz);
		Intent intent = new Intent(this, MainActivity2.class);
		startActivity(intent);
	}
}