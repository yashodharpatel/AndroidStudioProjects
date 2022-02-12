package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

	private final String[] courseList;

	//	Provide a reference to the type of views that you are using (custom ViewHolder)
	public static class ViewHolder extends RecyclerView.ViewHolder{
		private final TextView courseName;

		public ViewHolder(View view) {
			super(view);
			// Defining click listener for the ViewHolder's View
			view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					Toast.makeText(courseName.getContext(), "Opening "+courseName.getText()+" course...", Toast.LENGTH_SHORT).show();
				}
			});

			courseName = (TextView) view.findViewById(R.id.courseName);
		}

		public TextView getTextView() {
			return courseName;
		}
	}

//	Returns the size of your courseList (invoked by the layout manager)
	@Override
	public int getItemCount() {
		return courseList.length;
	}

//	Step 1: Initialize the courseList of the Adapter.
//	@param courseList String[] containing the data to populate views to be used by RecyclerView.
	public CustomAdapter(String[] courseList) {
		this.courseList = courseList;
	}

//	Step 2: Create new views (invoked by the layout manager)
	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
		// Create a new view, which defines the UI of the list item
		View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_recycler_view, viewGroup, false);
		return new ViewHolder(view);
	}

//	Step 3: Replace the contents of a view (invoked by the layout manager)
	@Override
	public void onBindViewHolder(ViewHolder viewHolder, final int position) {
		// Get element from your courseList at this position and replace the contents of the view with that element
		viewHolder.getTextView().setText(courseList[position]);
	}
}