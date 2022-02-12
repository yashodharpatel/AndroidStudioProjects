package com.example.unitconverter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class GridviewAdapter extends ArrayAdapter<Unit> {
	Context context;
	ArrayList<Unit> unitArrayList;

	public GridviewAdapter(@NonNull Context context, ArrayList<Unit> unitArrayList) {
		super(context, 0, unitArrayList);
		this.context = context;
		this.unitArrayList = unitArrayList;
	}

	@NonNull
	@Override
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
		View currentItemView = convertView;

		if (currentItemView == null) {
			currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.grid_layout, parent, false);
		}

		Unit unit = getItem(position);

		ImageView imageView = currentItemView.findViewById(R.id.imageView);
		imageView.setImageResource(unit.getUnitLogo());

		TextView textView = currentItemView.findViewById(R.id.textView);
		textView.setText(unit.getUnitName());

		currentItemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, ConvertActivity.class);
				String title = textView.getText().toString();
				intent.putExtra("title", title);
				intent.putExtra("position", position);
				context.startActivity(intent);
			}
		});

		return currentItemView;
	}
}