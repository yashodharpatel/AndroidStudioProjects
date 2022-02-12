package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
	public static final String EXTRA_SCORE = "com.example.quizapp.SCORE";
	public static final String EXTRA_QUESTION_LENGTH = "com.example.quizapp.QUESTION_LENGTH";
	public static final String EXTRA_PERCENTAGE = "com.example.quizapp.PERCENTAGE";

	TextView question;
	Button yes;
	Button no;

	String[] questions = {
			"Array indexes start with 1 in java.",
			"In Java, it is possible to inherit attributes and methods from one class to another.",
			"Java doesn't support multiple inheritance.",
			"The value of a string variable can be surrounded by single quotes in java.",
			"Java is short for \"JavaScript\".",
			"In an instance method or a constructor, \"this\" is a reference to the current object in java.",
			"Garbage Collection is manual process in java.",
			"Constructor overloading is possible in java.",
			"Assignment operator is evaluated Right to Left in java.",
			"Java is created by \"Yashodhar Patel\" in India."
	};

	boolean[] answers = {false, true, true, false, false, true, false, true, true, false};

	int index = 0;
	int score = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);
		question = findViewById(R.id.question);
		question.setText(questions[index]);
	}

	public void displayScoreboard(){
		Intent intent = new Intent(this, MainActivity3.class);

		double percentage = (score*100)/questions.length;
		String sendQuelen = Integer.toString(questions.length);
		String sendScore = Integer.toString(score);
		String sendPercentage = Double.toString(percentage);

		intent.putExtra(EXTRA_QUESTION_LENGTH, sendQuelen);
		intent.putExtra(EXTRA_SCORE, sendScore);
		intent.putExtra(EXTRA_PERCENTAGE, sendPercentage);
		startActivity(intent);
	}

	public void setYes(View view){
		yes = findViewById(R.id.yes);

		//if array is not going out of bounds
		if(index <= questions.length-1){
			//if your answer is correct
			if(answers[index]){
				score++;
			}
			// Go to the next question
			index++;
			if(index <= questions.length-1){
				question.setText(questions[index]);
			}
			else{
				displayScoreboard();
			}
		}
		else{
			Toast.makeText(this, "Restart the quiz to play again", Toast.LENGTH_SHORT).show();
		}
	}

	public void setNo(View view){
		no = findViewById(R.id.no);

		//if array is not going out of bounds
		if(index <= questions.length-1){
			//if your answer is correct
			if(!answers[index]){
				score++;
			}
			// Go to the next question
			index++;
			if(index <= questions.length-1){
				question.setText(questions[index]);
			}
			else{
				displayScoreboard();
			}
		}
		else{
			Toast.makeText(this, "Restart the quiz to play again", Toast.LENGTH_SHORT).show();
		}
	}
}