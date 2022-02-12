package com.example.isangeet;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import java.io.File;
import java.util.ArrayList;

public class PlaySong extends AppCompatActivity {
	TextView textView;
	SeekBar seekBar;
	Thread updateSeek;
	TextView currentTimeText, totalTimeText;
	ImageView previousButton, PlayPauseButton, nextButton;
	String songName;
	int position;
	ArrayList<File> songs;
	Uri uri;
	MediaPlayer mediaPlayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play_song);

		textView = findViewById(R.id.textView);
		seekBar = findViewById(R.id.seekBar);
		currentTimeText = findViewById(R.id.currentTimeText);
		totalTimeText = findViewById(R.id.totalTimeText);
		previousButton = findViewById(R.id.previousButton);
		PlayPauseButton = findViewById(R.id.PlayPauseButton);
		nextButton = findViewById(R.id.nextButton);

		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		songName = intent.getStringExtra("EXTRA_SONG_NAME");
		position = intent.getIntExtra("EXTRA_SONG_POSITION", 0);
		songs = (ArrayList) bundle.getParcelableArrayList("EXTRA_SONGS");

		textView.setText(songName);
		textView.setSelected(true);
		setTitle(songName);

		startMediaPlayer();

		mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				nextButton.callOnClick();
			}
		});

		seekBar.setMax(mediaPlayer.getDuration());
		seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append(mediaPlayer.getCurrentPosition());
				stringBuilder.append(" and ");
				stringBuilder.append(mediaPlayer.getDuration());
				if (mediaPlayer.getCurrentPosition() >= -200 + mediaPlayer.getDuration()) {
					nextButton.callOnClick();
				}
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				mediaPlayer.seekTo(seekBar.getProgress());
			}
		});

		updateSeek = new Thread() {
			@Override
			public void run() {
				int currentPosition = 0;
				try {
					while (currentPosition < mediaPlayer.getDuration()) {
						currentPosition = mediaPlayer.getCurrentPosition();
						seekBar.setProgress(currentPosition);
						sleep(500);
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		updateSeek.start();

		String totalTime = createTimeLabel(mediaPlayer.getDuration());
		totalTimeText.setText(totalTime);

		final Handler handler = new Handler();
		final int delay = 1000;

		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				String currentTime = createTimeLabel(mediaPlayer.getCurrentPosition());
				currentTimeText.setText(currentTime);
				handler.postDelayed(this, delay);
			}
		}, delay);
	}

	public void startMediaPlayer(){
		uri = Uri.parse(songs.get(position).toString());
		mediaPlayer = MediaPlayer.create(this, uri);
		mediaPlayer.start();
	}

	public String createTimeLabel(int duration) {
		String timeLabel = "";
		int min = duration / 1000 / 60;
		int sec = duration / 1000 % 60;

		timeLabel += min + ":";
		if (sec < 10) timeLabel += "0";
		timeLabel += sec;

		return timeLabel;
	}

	public void setPlayPauseButton(View view) {
		if(mediaPlayer.isPlaying()) {
			PlayPauseButton.setImageResource(R.drawable.play);
			mediaPlayer.pause();
		}
		else {
			PlayPauseButton.setImageResource(R.drawable.pause);
			mediaPlayer.start();
		}
	}

	public void setPreviousButton(View view) {
		mediaPlayer.stop();
		mediaPlayer.release();
		if(position != 0) {
			position = position - 1;
		}
		else{
			position = songs.size() - 1;
		}

		startMediaPlayer();

		PlayPauseButton.setImageResource(R.drawable.pause);

		songName = songs.get(position).getName().toString();
		textView.setText(songName);
		setTitle(songName);
	}

	public void setNextButton(View view) {
		mediaPlayer.stop();
		mediaPlayer.release();
		if(position != songs.size()-1) {
			position = position + 1;
		}
		else{
			position = 0;
		}

		startMediaPlayer();

		PlayPauseButton.setImageResource(R.drawable.pause);

		songName = songs.get(position).getName().toString();
		textView.setText(songName);
		setTitle(songName);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mediaPlayer.stop();
		mediaPlayer.reset();
		mediaPlayer.release();
		updateSeek.interrupt();
	}
}