package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomAdapter extends ArrayAdapter<String> {
	TextView courseName;
	private final String[] courseList;

	public CustomAdapter(@NonNull Context context, int resource, @NonNull String[] courseList) {
		super(context, resource, courseList);
		this.courseList = courseList;
	}

	@Nullable
	@Override
	public String getItem(int position) {
		return courseList[position];
	}

	@NonNull
	@Override
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
		View currentItemView = convertView;
		currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list_view, parent, false);
		courseName = currentItemView.findViewById(R.id.courseName);
		courseName.setText(getItem(position));
		return currentItemView;
	}
}