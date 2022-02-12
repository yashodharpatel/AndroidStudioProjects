package com.example.webbrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
	EditText editText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void openWebPage(View view) {
		editText = findViewById(R.id.editText);
		String url = editText.getText().toString();

		Uri webpage = Uri.parse(url);
		Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
		if (intent.resolveActivity(getPackageManager()) != null) {
			startActivity(intent);
			editText.setText("");
		}
		else{
			editText.setError("Please enter a valid URL");
		}
	}
}