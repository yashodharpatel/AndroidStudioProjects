package com.example.a3songsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {
	TextView textView2;
	SeekBar seekBar;
	Button button;
	MediaPlayer mediaPlayer;

	String[] songs = {"https://paglasongs.com/files/download/id/2977", "https://paglasongs.com/files/download/id/3116", "https://paglasongs.com/files/download/id/3121"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);

		textView2 = findViewById(R.id.textView2);
		seekBar = findViewById(R.id.seekBar);
		button = findViewById(R.id.button);

		Intent intent = getIntent();
		String songName = intent.getStringExtra(MainActivity.EXTRA_SONG_NAME);
		String strPos = intent.getStringExtra(MainActivity.EXTRA_POSITION);

		int position = Integer.parseInt(strPos);

		textView2.setText(songName);

		mediaPlayer = new MediaPlayer();
		try {
			mediaPlayer.setDataSource(songs[position]);
		} catch (IOException e) {
			e.printStackTrace();
		}

		mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
			@Override
			public void onPrepared(MediaPlayer mp) {
				mp.start();

				seekBar.setMax(mediaPlayer.getDuration());
				seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
					@Override
					public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
						if(fromUser){
							mediaPlayer.seekTo(progress);
						}
					}

					@Override
					public void onStartTrackingTouch(SeekBar seekBar) {

					}

					@Override
					public void onStopTrackingTouch(SeekBar seekBar) {

					}
				});
			}
		});
		mediaPlayer.prepareAsync();

		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(mediaPlayer.isPlaying()){
					mediaPlayer.pause();
				}
				else{
					mediaPlayer.start();
				}
			}
		});
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mediaPlayer.stop();
		mediaPlayer.release();
	}
}