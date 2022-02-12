package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
	public static final String EXTRA_COURSE_NAME = "com.example.myfirstapp.COURSE_NAME";
	ListView listview;
	String[] courseList = {"C-Programming", "Data Structure", "Database", "Python", "Java", "Operating System",
			"Compiler Design", "Android Development", "Web Development", "MongoDB", "MySQL", "Software Engineering"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listview = findViewById(R.id.listview);

//		Using built in ArrayAdapter
//		ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, courseList);
//		listview.setAdapter(ad);
//		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//			@Override
//			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//				Toast.makeText(MainActivity.this, "Opening "+courseList[position]+" course...", Toast.LENGTH_SHORT).show();
//			}
//		});
//
//		Using basic ArrayAdapter
//		ArrayAdapter<String> ad = new ArrayAdapter<String>(this, R.layout.item_view, R.id.textView, courseList);
//		listview.setAdapter(ad);

//		Using custom ArrayAdapter
		CustomAdapter ad = new CustomAdapter(this, R.layout.custom_list_view, courseList);
		listview.setAdapter(ad);
//		if onClickListener doesn't work then add onClickListener before returning the view in CustomAdapter.java in getView()
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(MainActivity.this, "Opening "+courseList[position]+" course...", Toast.LENGTH_SHORT).show();
				startNextActivity(courseList, position);
			}
		});
	}

	public void startNextActivity(String[] courseList, int n){
		Intent intent = new Intent(this, MainActivity2.class);
		intent.putExtra(EXTRA_COURSE_NAME, courseList[n]);
		startActivity(intent);
	}
}