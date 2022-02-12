package com.example.a3videoapp;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Adapter extends ArrayAdapter<Video> {
	Context context;
	int resource;
	List<Video> videoList;

	public Adapter(@NonNull Context context, int resource, @NonNull List<Video> videoList) {
		super(context, resource, videoList);
		this.context = context;
		this.resource = resource;
		this.videoList = videoList;
	}

	@NonNull
	@Override
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

		View currentItemView = convertView;
		currentItemView = LayoutInflater.from(context).inflate(resource, null, false);

		SurfaceView surfaceView = currentItemView.findViewById(R.id.surfaceView);
		SeekBar seekBar = currentItemView.findViewById(R.id.seekBar);
		Button button = currentItemView.findViewById(R.id.button);

		Video video = videoList.get(position);

		MediaPlayer mediaPlayer = MediaPlayer.create(context, video.getVideo());

		surfaceView.setKeepScreenOn(true);

		surfaceView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(button.getVisibility() == View.INVISIBLE){
					button.setVisibility(View.VISIBLE);
				}
				else {
					button.setVisibility(View.INVISIBLE);
				}
			}
		});

		SurfaceHolder surfaceHolder = surfaceView.getHolder();
		surfaceHolder.addCallback(new SurfaceHolder.Callback() {
			@Override
			public void surfaceCreated(@NonNull SurfaceHolder holder) {
				mediaPlayer.setDisplay(surfaceHolder);
//				mediaPlayer.start();

				mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
					@Override
					public void onCompletion(MediaPlayer mp) {
						mp.start();
					}
				});
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
				button.setVisibility(View.INVISIBLE);
			}
		});

		return currentItemView;
	}
}