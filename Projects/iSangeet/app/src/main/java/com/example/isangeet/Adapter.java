package com.example.isangeet;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.io.File;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

	private static Context context;
	private final String[] songList;
	private static ArrayList<File> songs;

	public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
		private final TextView songName;

		public ViewHolder(View view) {
			super(view);

			view.setOnClickListener(this);

			songName =view.findViewById(R.id.songName);
		}

		public TextView getSongName() {
			return songName;
		}

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(context, PlaySong.class);
			String sendSongName = songName.getText().toString();
			int position = getAdapterPosition();
			intent.putExtra("EXTRA_SONG_NAME", sendSongName);
			intent.putExtra("EXTRA_SONG_POSITION", position);
			intent.putExtra("EXTRA_SONGS", songs);
			context.startActivity(intent);
		}
	}

	@Override
	public int getItemCount() {
		return songList.length;
	}

	public Adapter(Context context, String[] songList, ArrayList<File> songs) {
		this.context = context;
		this.songList = songList;
		this.songs = songs;
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
		View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.song_list, viewGroup, false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ViewHolder viewHolder, final int position) {
		viewHolder.getSongName().setText(songList[position]);
	}
}
