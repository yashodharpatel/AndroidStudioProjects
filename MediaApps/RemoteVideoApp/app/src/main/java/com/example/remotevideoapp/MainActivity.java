package com.example.remotevideoapp;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
	private VideoView videoView;
	private MediaController mediaController;
	private String videotoplay = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		videoView = findViewById(R.id.videoView);

		mediaController = new MediaController(this);
		mediaController.setAnchorView(this.videoView);

		videoView.setMediaController(mediaController);
		videoView.setVideoURI(Uri.parse(videotoplay));
		videoView.requestFocus();
		videoView.start();

		videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				videoView.setVideoURI(Uri.parse(videotoplay));
				videoView.start();
			}
		});
	}
}