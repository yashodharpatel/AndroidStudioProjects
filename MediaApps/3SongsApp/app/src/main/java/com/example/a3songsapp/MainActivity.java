package com.example.a3songsapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
	public static final String EXTRA_SONG_NAME = "com.example.a3songsapp.SONG_NAME";
	public static final String EXTRA_POSITION = "com.example.a3songsapp.POSITION";
	ListView listView;
	String[] songList = {"Brown Munde", "Pani Pani", "Meera Ke Prabhu Giridhar"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listView = findViewById(R.id.listView);

		Adapter ad = new Adapter(this, R.layout.music_list, songList);
		listView.setAdapter(ad);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				String sendPos = Integer.toString(position);
				Intent intent = new Intent(MainActivity.this, MainActivity2.class);
				intent.putExtra(EXTRA_SONG_NAME, songList[position]);
				intent.putExtra(EXTRA_POSITION, sendPos);
				startActivity(intent);
			}
		});
	}
}