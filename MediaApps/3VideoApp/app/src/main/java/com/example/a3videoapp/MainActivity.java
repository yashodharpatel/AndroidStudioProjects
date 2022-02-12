package com.example.a3videoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
	List<Video> videoList;
	ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		videoList = new ArrayList<>();
		listView = findViewById(R.id.listView);

		videoList.add(new Video(R.raw.coding));
		videoList.add(new Video(R.raw.heartrate));
		videoList.add(new Video(R.raw.keyboard));
		videoList.add(new Video(R.raw.sourcecode));

		Adapter ad = new Adapter(this, R.layout.video_layout, videoList);
		listView.setAdapter(ad);
	}
}