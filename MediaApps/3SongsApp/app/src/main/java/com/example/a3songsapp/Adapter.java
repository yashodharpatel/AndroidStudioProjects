package com.example.a3songsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Adapter extends ArrayAdapter<String> {
	TextView songName;
	private final String[] songList;

	public Adapter(@NonNull Context context, int resource, @NonNull String[] songList) {
		super(context, resource, songList);
		this.songList = songList;
	}

	@Nullable
	@Override
	public String getItem(int position) {
		return songList[position];
	}

	@NonNull
	@Override
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
		View currentItemView = convertView;
		currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.music_list, parent, false);
		songName = currentItemView.findViewById(R.id.songName);
		songName.setText(getItem(position));
		return currentItemView;
	}
}