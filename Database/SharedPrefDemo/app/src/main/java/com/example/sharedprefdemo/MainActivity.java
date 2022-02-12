package com.example.sharedprefdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
	EditText editText;
	TextView textView;
	Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		editText = findViewById(R.id.editText);
		textView = findViewById(R.id.textView);
		button = findViewById(R.id.button);

		SharedPreferences sharedPreferences = getSharedPreferences("myPreferences", MODE_PRIVATE);
		String editVal = sharedPreferences.getString("Text", "No value as of now"); // Retrieve Data
		textView.setText(editVal);

		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String val = editText.getText().toString();
				SharedPreferences sharedPreferences = getSharedPreferences("myPreferences", MODE_PRIVATE);
				SharedPreferences.Editor editor = sharedPreferences.edit();
				editor.putString("Text", val); // Storing Data
				editor.apply();
				textView.setText(val);
			}
		});
	}
}