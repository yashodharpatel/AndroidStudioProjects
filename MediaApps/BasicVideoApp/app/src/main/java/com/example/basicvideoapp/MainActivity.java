package com.example.basicvideoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
	private MediaPlayer mediaPlayer;
	private SurfaceView surfaceView;
	private SeekBar seekBar;
	private Button button;
	private SurfaceHolder surfaceHolder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		surfaceView = findViewById(R.id.surfaceView);
		seekBar = findViewById(R.id.seekBar);
		button = findViewById(R.id.button);

//		MediaPlayer using local source
		mediaPlayer = MediaPlayer.create(this, R.raw.keyboard);

		surfaceView.setKeepScreenOn(true);

		surfaceHolder = surfaceView.getHolder();
		surfaceHolder.addCallback(new SurfaceHolder.Callback() {
			@Override
			public void surfaceCreated(@NonNull SurfaceHolder holder) {
				mediaPlayer.setDisplay(surfaceHolder);
				mediaPlayer.start();
			}

			@Override
			public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

			}

			@Override
			public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

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