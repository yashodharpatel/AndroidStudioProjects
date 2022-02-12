package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
	GridView gridView;
	ArrayList<Unit> unitArrayList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		gridView = findViewById(R.id.gridView);

		unitArrayList = new ArrayList<>();
		unitArrayList.add(new Unit(R.drawable.mass, "Mass"));
		unitArrayList.add(new Unit(R.drawable.length, "Length"));
		unitArrayList.add(new Unit(R.drawable.area, "Area"));
		unitArrayList.add(new Unit(R.drawable.datastorage, "Data Storage"));
		unitArrayList.add(new Unit(R.drawable.speed, "Speed"));
		unitArrayList.add(new Unit(R.drawable.time, "Time"));
		unitArrayList.add(new Unit(R.drawable.temperature, "Temperature"));
		unitArrayList.add(new Unit(R.drawable.cooking, "Cooking"));

		GridviewAdapter gridviewAdapter = new GridviewAdapter(this, unitArrayList);
		gridView.setAdapter(gridviewAdapter);
	}
}