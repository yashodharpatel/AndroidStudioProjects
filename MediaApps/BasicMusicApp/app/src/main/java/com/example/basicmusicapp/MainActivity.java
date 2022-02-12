package com.example.basicmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
	private MediaPlayer mediaPlayer;
	private Button button;
	private SeekBar seekBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		button = findViewById(R.id.button);
		seekBar = findViewById(R.id.seekBar);

//		MediaPlayer using local source
//		mediaPlayer = MediaPlayer.create(this, R.raw.music);
//		mediaPlayer.start();

//		MediaPlayer using remote source
		mediaPlayer = new MediaPlayer();
		try {
			mediaPlayer.setDataSource("https://paglasongs.com/files/download/id/3042");
		} catch (IOException e) {
			e.printStackTrace();
		}

		mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
			@Override
			public void onPrepared(MediaPlayer mp) {
				mp.start();

//				Code to play the song in the loop
				mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
					@Override
					public void onCompletion(MediaPlayer mp) {
						mp.start();
					}
				});

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
}