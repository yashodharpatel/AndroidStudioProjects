package com.example.firstmultiscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
	EditText editText;
	String message;
	public static final String EXTRA_MESSAGE = "com.example.firstmultiscreenapp.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void sendMessage(View view){
		editText = findViewById(R.id.editText);
		message = editText.getText().toString();

		if(TextUtils.isEmpty(editText.getText())){
			editText.setError("Please type a message");
		}
		else{
			Toast.makeText(this, "Sending Message...", Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(this, MainActivity2.class);
			intent.putExtra(EXTRA_MESSAGE, message);
			startActivity(intent);
			editText.setText("");
		}
	}
}