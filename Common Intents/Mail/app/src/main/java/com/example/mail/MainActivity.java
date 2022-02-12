package com.example.mail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
	EditText Subject;
	EditText Body;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void composeEmail(View view) {
		Subject = findViewById(R.id.Subject);
		Body = findViewById(R.id.Body);

		String [] address = {"patelyashodhar012@gmail.com"};
		String subject = Subject.getText().toString();
		String content = Body.getText().toString();

		if(TextUtils.isEmpty(Subject.getText()) || TextUtils.isEmpty(Body.getText())){
			Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
		}
		else{
			Intent intent = new Intent(Intent.ACTION_SEND);
			intent.setType("*/*");
			intent.putExtra(Intent.EXTRA_EMAIL, address);
			intent.putExtra(Intent.EXTRA_SUBJECT, subject);
			intent.putExtra(Intent.EXTRA_TEXT, content);
			if (intent.resolveActivity(getPackageManager()) != null) {
				startActivity(intent);
			}
		}
	}
}