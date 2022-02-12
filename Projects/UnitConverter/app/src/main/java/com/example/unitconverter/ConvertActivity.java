package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class ConvertActivity extends AppCompatActivity {
	Spinner fromDropdownList, toDropdownList;
	EditText valueEditText;
	Button calculateButton;
	TextView resultTextView, detailedResultTextView;
	ImageView shuffleButton;
	String title;
	int position;
	String[] fromItems;
	String[] toItems;
	ArrayAdapter<String> fromAdapter;
	ArrayAdapter<String> toAdapter;
	double value = 0, result = 0;
	String fromItemSelected, toItemSelected;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_convert);

		fromDropdownList = findViewById(R.id.fromDropdownList);
		toDropdownList = findViewById(R.id.toDropdownList);
		valueEditText = findViewById(R.id.valueEditText);
		calculateButton = findViewById(R.id.calculateButton);
		resultTextView = findViewById(R.id.resultTextView);
		detailedResultTextView = findViewById(R.id.detailedResultTextView);
		shuffleButton = findViewById(R.id.shuffleButton);

		Intent intent = getIntent();

		title = intent.getStringExtra("title");
		setTitle(title);

		position = intent.getIntExtra("position", 0);

		switch (position) {
			case 0:
//				Mass
				fromItems = new String[]{"Kilogram", "Pound", "Gram", "Milligram", "Ounce", "Grain", "Stone", "Ton (metric)", "Ton (US/short)"};
				fromAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, fromItems);
				fromDropdownList.setAdapter(fromAdapter);
				fromDropdownList.setSelection(0);

				toItems = new String[]{"Kilogram", "Pound", "Gram", "Milligram", "Ounce", "Grain", "Stone", "Ton (metric)", "Ton (US/short)"};
				toAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, toItems);
				toDropdownList.setAdapter(toAdapter);
				toDropdownList.setSelection(1);
				break;

			case 1:
//				Length
				fromItems = new String[]{"Kilometre", "Miles", "Metre", "Centimetre (cm)", "Millimetre (mm)", "Micrometre", "Nanometre", "Yard", "Feet", "Inch"};
				fromAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, fromItems);
				fromDropdownList.setAdapter(fromAdapter);
				fromDropdownList.setSelection(0);

				toItems = new String[]{"Kilometre", "Miles", "Metre", "Centimetre (cm)", "Millimetre (mm)", "Micrometre", "Nanometre", "Yard", "Feet", "Inch"};
				toAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, toItems);
				toDropdownList.setAdapter(toAdapter);
				toDropdownList.setSelection(2);
				break;

			case 2:
//				Area
				fromItems = new String[]{"Sq Kilometer", "Sq Meter", " Sq Centimetre", "Hectare", "Sq Mile", "Sq Yard", "Sq Foot", "Sq Inch", "Acre"};
				fromAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, fromItems);
				fromDropdownList.setAdapter(fromAdapter);
				fromDropdownList.setSelection(0);

				toItems = new String[]{"Sq Kilometer", "Sq Meter", "Sq Centimetre", "Hectare", "Sq Mile", "Sq Yard", "Sq Foot", "Sq Inch", "Acre"};
				toAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, toItems);
				toDropdownList.setAdapter(toAdapter);
				toDropdownList.setSelection(1);
				break;

			case 3:
//				Data Storage
				fromItems = new String[]{"Bit", "Byte", "Kilobit", "Kilobyte", "Megabit", "Megabyte", "Gigabit", "Gigabyte", "Terabit", "Terabyte", "Petabit", "Petabyte"};
				fromAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, fromItems);
				fromDropdownList.setAdapter(fromAdapter);
				fromDropdownList.setSelection(0);

				toItems = new String[]{"Bit", "Byte", "Kilobit", "Kilobyte", "Megabit", "Megabyte", "Gigabit", "Gigabyte", "Terabit", "Terabyte", "Petabit", "Petabyte"};
				toAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, toItems);
				toDropdownList.setAdapter(toAdapter);
				toDropdownList.setSelection(1);
				break;

			case 4:
//				Speed
				fromItems = new String[]{"Kilometer/hour", "Mile/hour", "Metre/second", "Foot/second", "Knot"};
				fromAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, fromItems);
				fromDropdownList.setAdapter(fromAdapter);
				fromDropdownList.setSelection(0);

				toItems = new String[]{"Kilometer/hour", "Mile/hour", "Metre/second", "Foot/second", "Knot"};
				toAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, toItems);
				toDropdownList.setAdapter(toAdapter);
				toDropdownList.setSelection(1);
				break;

			case 5:
//				Time
				fromItems = new String[]{"Year", "Month", "Week", "Day", "Hour", "Minute", "Second", "Millisecond", "Nanosecond"};
				fromAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, fromItems);
				fromDropdownList.setAdapter(fromAdapter);
				fromDropdownList.setSelection(0);

				toItems = new String[]{"Year", "Month", "Week", "Day", "Hour", "Minute", "Second", "Millisecond", "Nanosecond"};
				toAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, toItems);
				toDropdownList.setAdapter(toAdapter);
				toDropdownList.setSelection(1);
				break;

			case 6:
//				Temperature
				fromItems = new String[]{"Celsius", "Fahrenheit", "Kelvin", "Rankine", "Delisle", "Newton", "Reaumur", "Romer"};
				fromAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, fromItems);
				fromDropdownList.setAdapter(fromAdapter);
				fromDropdownList.setSelection(0);

				toItems = new String[]{"Celsius", "Fahrenheit", "Kelvin", "Rankine", "Delisle", "Newton", "Reaumur", "Romer"};
				toAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, toItems);
				toDropdownList.setAdapter(toAdapter);
				toDropdownList.setSelection(1);
				break;

			case 7:
//				Cooking
				fromItems = new String[]{"Teaspoon", "Tablespoon",  "Cup", "Fluid Ounce (US)", "Fluid Ounce (UK)", "Pint (US)", "Pint (UK)", "Quart (US)", "Quart (UK)", "Gallon (US)", "Gallon (UK)", "Millilitre", "litre"};
				fromAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, fromItems);
				fromDropdownList.setAdapter(fromAdapter);
				fromDropdownList.setSelection(0);

				toItems = new String[]{"Teaspoon", "Tablespoon",  "Cup", "Fluid Ounce (US)", "Fluid Ounce (UK)", "Pint (US)", "Pint (UK)", "Quart (US)", "Quart (UK)", "Gallon (US)", "Gallon (UK)", "Millilitre", "litre"};
				toAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, toItems);
				toDropdownList.setAdapter(toAdapter);
				toDropdownList.setSelection(1);
				break;
		}
	}

	public void calculateMass() {
		fromItemSelected = String.valueOf(fromDropdownList.getSelectedItem());
		toItemSelected = String.valueOf(toDropdownList.getSelectedItem());

		switch (fromItemSelected) {
			case "Kilogram":
				switch (toItemSelected) {
					case "Kilogram":
						result = value;
						break;

					case "Pound":
						result = value*2.205;
						break;

					case "Gram":
						result = value*1000;
						break;

					case "Milligram":
						result = value*1e+6;
						break;

					case "Ounce":
						result = value*35.274;
						break;

					case "Grain":
						result = value*15432;
						break;

					case "Stone":
						result = value/6.35;
						break;

					case "Ton (metric)":
						result = value/1000;
						break;

					case "Ton (US/short)":
						result = value/907;
						break;
				}
				break;

			case "Pound":
				switch (toItemSelected) {
					case "Kilogram":
						result = value/2.205;
						break;

					case "Pound":
						result = value;
						break;

					case "Gram":
						result = value*454;
						break;

					case "Milligram":
						result = value*453592;
						break;

					case "Ounce":
						result = value*16;
						break;

					case "Grain":
						result = value*7000;
						break;

					case "Stone":
						result = value/14;
						break;

					case "Ton (metric)":
						result = value/2205;
						break;

					case "Ton (US/short)":
						result = value/2000;
						break;
				}
				break;

			case "Gram":
				switch (toItemSelected) {
					case "Kilogram":
						result = value/1000;
						break;

					case "Pound":
						result = value/454;
						break;

					case "Gram":
						result = value;
						break;

					case "Milligram":
						result = value*1000;
						break;

					case "Ounce":
						result = value/28.35;
						break;

					case "Grain":
						result = value*15.432;
						break;

					case "Stone":
						result = value/6350;
						break;

					case "Ton (metric)":
						result = value/1e+6;
						break;

					case "Ton (US/short)":
						result = value/907185;
						break;
				}
				break;

			case "Milligram":
				switch (toItemSelected) {
					case "Kilogram":
						result = value/1e+6;
						break;

					case "Pound":
						result = value/453592;
						break;

					case "Gram":
						result = value/1000;
						break;

					case "Milligram":
						result = value;
						break;

					case "Ounce":
						result = value/28350;
						break;

					case "Grain":
						result = value/64.799;
						break;

					case "Stone":
						result = value/6.35e+6;
						break;

					case "Ton (metric)":
						result = value/1e+9;
						break;

					case "Ton (US/short)":
						result = value/9.072e+8;
						break;
				}
				break;

			case "Ounce":
				switch (toItemSelected) {
					case "Kilogram":
						result = value/35.274;
						break;

					case "Pound":
						result = value/16;
						break;

					case "Gram":
						result = value*28.35;
						break;

					case "Milligram":
						result = value*28350;
						break;

					case "Ounce":
						result = value;
						break;

					case "Grain":
						result = value*438;
						break;

					case "Stone":
						result = value/224;
						break;

					case "Ton (metric)":
						result = value/35274;
						break;

					case "Ton (US/short)":
						result = value/32000;
						break;
				}
				break;

			case "Grain":
				switch (toItemSelected) {
					case "Kilogram":
						result = value/15432;
						break;

					case "Pound":
						result = value/7000;
						break;

					case "Gram":
						result = value/15.432;
						break;

					case "Milligram":
						result = value*64.799;
						break;

					case "Ounce":
						result = value/438;
						break;

					case "Grain":
						result = value;
						break;

					case "Stone":
						result = value/98000;
						break;

					case "Ton (metric)":
						result = value/1.543e+7;
						break;

					case "Ton (US/short)":
						result = value/1.4e+7;
						break;
				}
				break;

			case "Stone":
				switch (toItemSelected) {
					case "Kilogram":
						result = value*6.35;
						break;

					case "Pound":
						result = value*14;
						break;

					case "Gram":
						result = value*6350;
						break;

					case "Milligram":
						result = value*6.35e+6;
						break;

					case "Ounce":
						result = value*224;
						break;

					case "Grain":
						result = value*98000;
						break;

					case "Stone":
						result = value;
						break;

					case "Ton (metric)":
						result = value/157;
						break;

					case "Ton (US/short)":
						result = value/143;
						break;
				}
				break;

			case "Ton (metric)":
				switch (toItemSelected) {
					case "Kilogram":
						result = value*1000;
						break;

					case "Pound":
						result = value*2205;
						break;

					case "Gram":
						result = value*1e+6;
						break;

					case "Milligram":
						result = value*1e+9;
						break;

					case "Ounce":
						result = value*35274;
						break;

					case "Grain":
						result = value*1.543e+7;
						break;

					case "Stone":
						result = value*157;
						break;

					case "Ton (metric)":
						result = value;
						break;

					case "Ton (US/short)":
						result = value*1.102;
						break;
				}
				break;

			case "Ton (US/short)":
				switch (toItemSelected) {
					case "Kilogram":
						result = value*907;
						break;

					case "Pound":
						result = value*2000;
						break;

					case "Gram":
						result = value*907185;
						break;

					case "Milligram":
						result = value*9.072e+8;
						break;

					case "Ounce":
						result = value*32000;
						break;

					case "Grain":
						result = value*1.4e+7;
						break;

					case "Stone":
						result = value*143;
						break;

					case "Ton (metric)":
						result = value/1.102;
						break;

					case "Ton (US/short)":
						result = value;
						break;
				}
				break;
		}
	}

	public void calculateLength() {
		fromItemSelected = String.valueOf(fromDropdownList.getSelectedItem());
		toItemSelected = String.valueOf(toDropdownList.getSelectedItem());

		switch (fromItemSelected) {
			case "Kilometre":
				switch (toItemSelected) {
					case "Kilometre":
						result = value;
						break;

					case "Miles":
						result = value*0.621371;
						break;

					case "Metre":
						result = value*1000;
						break;

					case "Centimetre (cm)":
						result = value*100000;
						break;

					case "Millimetre (mm)":
						result = value*1e+6;
						break;

					case "Micrometre":
						result = value*1e+9;
						break;

					case "Nanometre":
						result = value*1e+12;
						break;

					case "Yard":
						result = value*1093.61;
						break;

					case "Feet":
						result = value*3280.84;
						break;

					case "Inch":
						result = value*39370.1;
						break;
				}
				break;

			case "Miles":
				switch (toItemSelected) {
					case "Kilometre":
						result = value*1.60934;
						break;

					case "Miles":
						result = value;
						break;

					case "Metre":
						result = value*1609.34;
						break;

					case "Centimetre (cm)":
						result = value*160934;
						break;

					case "Millimetre (mm)":
						result = value*1.609e+6;
						break;

					case "Micrometre":
						result = value*1.609e+9;
						break;

					case "Nanometre":
						result = value*1.609e+12;
						break;

					case "Yard":
						result = value*1760;
						break;

					case "Feet":
						result = value*5280;
						break;

					case "Inch":
						result = value*63360;
						break;
				}
				break;

			case "Metre":
				switch (toItemSelected) {
					case "Kilometre":
						result = value*0.001;
						break;

					case "Miles":
						result = value*0.000621371;
						break;

					case "Metre":
						result = value;
						break;

					case "Centimetre (cm)":
						result = value*100;
						break;

					case "Millimetre (mm)":
						result = value*1000;
						break;

					case "Micrometre":
						result = value*1e+6;
						break;

					case "Nanometre":
						result = value*1e+9;
						break;

					case "Yard":
						result = value*1.09361;
						break;

					case "Feet":
						result = value*3.28084;
						break;

					case "Inch":
						result = value*39.3701;
						break;
				}
				break;

			case "Centimetre (cm)":
				switch (toItemSelected) {
					case "Kilometre":
						result = value*1e-5;
						break;

					case "Miles":
						result = value*6.2137e-6;
						break;

					case "Metre":
						result = value*0.01;
						break;

					case "Centimetre (cm)":
						result = value;
						break;

					case "Millimetre (mm)":
						result = value*10;
						break;

					case "Micrometre":
						result = value*10000;
						break;

					case "Nanometre":
						result = value*1e+7;
						break;

					case "Yard":
						result = value*0.0109361;
						break;

					case "Feet":
						result = value*0.0328084;
						break;

					case "Inch":
						result = value*0.393701;
						break;
				}
				break;

			case "Millimetre (mm)":
				switch (toItemSelected) {
					case "Kilometre":
						result = value*1e-6;
						break;

					case "Miles":
						result = value*6.2137e-7;
						break;

					case "Metre":
						result = value*0.001;
						break;

					case "Centimetre (cm)":
						result = value*0.1;
						break;

					case "Millimetre (mm)":
						result = value;
						break;

					case "Micrometre":
						result = value*10000;
						break;

					case "Nanometre":
						result = value*1e+6;
						break;

					case "Yard":
						result = value*0.00109361;
						break;

					case "Feet":
						result = value*0.00328084;
						break;

					case "Inch":
						result = value*0.0393701;
						break;
				}
				break;

			case "Micrometre":
				switch (toItemSelected) {
					case "Kilometre":
						result = value*1e-9;
						break;

					case "Miles":
						result = value*6.2137e-10;
						break;

					case "Metre":
						result = value*1e-6;
						break;

					case "Centimetre (cm)":
						result = value*1e-4;
						break;

					case "Millimetre (mm)":
						result = value*0.001;
						break;

					case "Micrometre":
						result = value;
						break;

					case "Nanometre":
						result = value*1000;
						break;

					case "Yard":
						result = value*1.0936e-6;
						break;

					case "Feet":
						result = value*3.2808e-6;
						break;

					case "Inch":
						result = value*3.937e-5;
						break;
				}
				break;

			case "Nanometre":
				switch (toItemSelected) {
					case "Kilometre":
						result = value*1e-12;
						break;

					case "Miles":
						result = value*6.2137e-13;
						break;

					case "Metre":
						result = value*1e-9;
						break;

					case "Centimetre (cm)":
						result = value*1e-7;
						break;

					case "Millimetre (mm)":
						result = value*1e-6;
						break;

					case "Micrometre":
						result = value*0.001;
						break;

					case "Nanometre":
						result = value;
						break;

					case "Yard":
						result = value*1.0936e-9;
						break;

					case "Feet":
						result = value*3.2808e-9;
						break;

					case "Inch":
						result = value*3.937e-8;
						break;
				}
				break;

			case "Yard":
				switch (toItemSelected) {
					case "Kilometre":
						result = value*0.0009144;
						break;

					case "Miles":
						result = value*0.000568182;
						break;

					case "Metre":
						result = value*0.9144;
						break;

					case "Centimetre (cm)":
						result = value*91.44;
						break;

					case "Millimetre (mm)":
						result = value*914.4;
						break;

					case "Micrometre":
						result = value*914400;
						break;

					case "Nanometre":
						result = value*9.144e+8;
						break;

					case "Yard":
						result = value;
						break;

					case "Feet":
						result = value*3;
						break;

					case "Inch":
						result = value*36;
						break;
				}
				break;

			case "Feet":
				switch (toItemSelected) {
					case "Kilometre":
						result = value*0.0003048;
						break;

					case "Miles":
						result = value*0.000189394;
						break;

					case "Metre":
						result = value*0.3048;
						break;

					case "Centimetre (cm)":
						result = value*30.48;
						break;

					case "Millimetre (mm)":
						result = value*304.8;
						break;

					case "Micrometre":
						result = value*304800;
						break;

					case "Nanometre":
						result = value*3.048e+8;
						break;

					case "Yard":
						result = value*0.333333;
						break;

					case "Feet":
						result = value;
						break;

					case "Inch":
						result = value*12;
						break;
				}
				break;

			case "Inch":
				switch (toItemSelected) {
					case "Kilometre":
						result = value*2.54e-5;
						break;

					case "Miles":
						result = value*1.5783e-5;
						break;

					case "Metre":
						result = value*0.0254;
						break;

					case "Centimetre (cm)":
						result = value*2.54;
						break;

					case "Millimetre (mm)":
						result = value*25.4;
						break;

					case "Micrometre":
						result = value*25400;
						break;

					case "Nanometre":
						result = value*2.54e+7;
						break;

					case "Yard":
						result = value*0.0277778;
						break;

					case "Feet":
						result = value*0.0833333;
						break;

					case "Inch":
						result = value;
						break;
				}
				break;
		}

	}

	public void calculateArea() {
		fromItemSelected = String.valueOf(fromDropdownList.getSelectedItem());
		toItemSelected = String.valueOf(toDropdownList.getSelectedItem());

		switch (fromItemSelected) {
			case "Sq Kilometer":
				switch (toItemSelected) {
					case "Sq Kilometer":
						result = value;
						break;

					case "Sq Meter":
						result = value*1000000;
						break;

					case "Sq Centimetre":
						result = value*1e+10;
						break;

					case "Hectare":
						result = value*100;
						break;

					case "Sq Mile":
						result = value*0.386102;
						break;

					case "Sq Yard":
						result = value*1.196e+6;
						break;

					case "Sq Foot":
						result = value*1.076e+7;
						break;

					case "Sq Inch":
						result = value*1.55e+9;
						break;

					case "Acre":
						result = value*247.105;
						break;
				}
				break;

			case "Sq Metre":
				switch (toItemSelected) {
					case "Sq Kilometer":
						result = value*1e-6;
						break;

					case "Sq Meter":
						result = value;
						break;

					case "Sq Centimetre":
						result = value*10000;
						break;

					case "Hectare":
						result = value*1e-4;
						break;

					case "Sq Mile":
						result = value*3.861e-7;
						break;

					case "Sq Yard":
						result = value*1.19599;
						break;

					case "Sq Foot":
						result = value*10.7639;
						break;

					case "Sq Inch":
						result = value*1550;
						break;

					case "Acre":
						result = value*0.000247105;
						break;
				}
				break;

			case "Sq Centimetre":
				switch (toItemSelected) {
					case "Sq Kilometer":
						result = value*1e-10;
						break;

					case "Sq Meter":
						result = value*1e-4;
						break;

					case "Sq Centimetre":
						result = value;
						break;

					case "Hectare":
						result = value*1e-8;
						break;

					case "Sq Mile":
						result = value*3.861e-11;
						break;

					case "Sq Yard":
						result = value*0.000119599;
						break;

					case "Sq Foot":
						result = value*0.00107639;
						break;

					case "Sq Inch":
						result = value*0.155;
						break;

					case "Acre":
						result = value*2.4711e-8;
						break;
				}
				break;

			case "Hectare":
				switch (toItemSelected) {
					case "Sq Kilometer":
						result = value*0.01;
						break;

					case "Sq Meter":
						result = value*10000;
						break;

					case "Sq Centimetre":
						result = value*1e+8;
						break;

					case "Hectare":
						result = value;
						break;

					case "Sq Mile":
						result = value*0.00386102;
						break;

					case "Sq Yard":
						result = value*11959.9;
						break;

					case "Sq Foot":
						result = value*107639;
						break;

					case "Sq Inch":
						result = value*1.55e+7;
						break;

					case "Acre":
						result = value*2.47105;
						break;
				}
				break;

			case "Sq Mile":
				switch (toItemSelected) {
					case "Sq Kilometer":
						result = value*2.58999;
						break;

					case "Sq Meter":
						result = value*2.59e+6;
						break;

					case "Sq Centimetre":
						result = value*2.59e+10;
						break;

					case "Hectare":
						result = value*258.999;
						break;

					case "Sq Mile":
						result = value;
						break;

					case "Sq Yard":
						result = value*3.098e+6;
						break;

					case "Sq Foot":
						result = value*2.788e+7;
						break;

					case "Sq Inch":
						result = value*4.014e+9;
						break;

					case "Acre":
						result = value*640;
						break;
				}
				break;

			case "Sq Yard":
				switch (toItemSelected) {
					case "Sq Kilometer":
						result = value*8.3613e-7;
						break;

					case "Sq Meter":
						result = value*0.836127;
						break;

					case "Sq Centimetre":
						result = value*8361.27;
						break;

					case "Hectare":
						result = value*8.3613e-5;
						break;

					case "Sq Mile":
						result = value*3.2283e-7;
						break;

					case "Sq Yard":
						result = value;
						break;

					case "Sq Foot":
						result = value*9;
						break;

					case "Sq Inch":
						result = value*1296;
						break;

					case "Acre":
						result = value*0.000206612;
						break;
				}
				break;

			case "Sq Foot":
				switch (toItemSelected) {
					case "Sq Kilometer":
						result = value*9.2903e-8;
						break;

					case "Sq Meter":
						result = value*0.092903;
						break;

					case "Sq Centimetre":
						result = value*929.03;
						break;

					case "Hectare":
						result = value*9.2903e-6;
						break;

					case "Sq Mile":
						result = value*3.587e-8;
						break;

					case "Sq Yard":
						result = value*0.111111;
						break;

					case "Sq Foot":
						result = value;
						break;

					case "Sq Inch":
						result = value*144;
						break;

					case "Acre":
						result = value*2.2957e-5;
						break;
				}
				break;

			case "Sq Inch":
				switch (toItemSelected) {
					case "Sq Kilometer":
						result = value*6.4516e-10;
						break;

					case "Sq Meter":
						result = value*0.00064516;
						break;

					case "Sq Centimetre":
						result = value*6.4516;
						break;

					case "Hectare":
						result = value*6.4516e-8;
						break;

					case "Sq Mile":
						result = value*2.491e-10;
						break;

					case "Sq Yard":
						result = value*0.000771605;
						break;

					case "Sq Foot":
						result = value*0.00694444;
						break;

					case "Sq Inch":
						result = value;
						break;

					case "Acre":
						result = value*1.5942e-7;
						break;
				}
				break;

			case "Acre":
				switch (toItemSelected) {
					case "Sq Kilometer":
						result = value*0.00404686;
						break;

					case "Sq Meter":
						result = value*4046.86;
						break;

					case "Sq Centimetre":
						result = value*4.047e+7;
						break;

					case "Hectare":
						result = value*0.404686;
						break;

					case "Sq Mile":
						result = value*0.0015625;
						break;

					case "Sq Yard":
						result = value*4840;
						break;

					case "Sq Foot":
						result = value*43560;
						break;

					case "Sq Inch":
						result = value*6.273e+6;
						break;

					case "Acre":
						result = value;
						break;
				}
				break;
		}
	}

	public void calculateDataStorage() {
		fromItemSelected = String.valueOf(fromDropdownList.getSelectedItem());
		toItemSelected = String.valueOf(toDropdownList.getSelectedItem());

		switch (fromItemSelected) {
			case "Bit":
				switch (toItemSelected) {
					case "Bit":
						result = value;
						break;

					case "Byte":
						result = value*0.125;
						break;

					case "Kilobit":
						result = value*0.001;
						break;

					case "Kilobyte":
						result = value*0.000125;
						break;

					case "Megabit":
						result = value*1e-6;
						break;

					case "Megabyte":
						result = value*1.25e-7;
						break;

					case "Gigabit":
						result = value*1e-9;
						break;

					case "Gigabyte":
						result = value*1.25e-10;
						break;

					case "Terabit":
						result = value*1e-12;
						break;

					case "Terabyte":
						result = value*1.25e-13;
						break;

					case "Petabit":
						result = value*1e-15;
						break;

					case "Petabyte":
						result = value*1.25e-16;
						break;
				}
				break;

			case "Byte":
				switch (toItemSelected) {
					case "Bit":
						result = value*8;
						break;

					case "Byte":
						result = value;
						break;

					case "Kilobit":
						result = value*0.008;
						break;

					case "Kilobyte":
						result = value*0.001;
						break;

					case "Megabit":
						result = value*8e-6;
						break;

					case "Megabyte":
						result = value*1e-6;
						break;

					case "Gigabit":
						result = value*8e-9;
						break;

					case "Gigabyte":
						result = value*1e-9;
						break;

					case "Terabit":
						result = value*8e-12;
						break;

					case "Terabyte":
						result = value*1e-12;
						break;

					case "Petabit":
						result = value*8e-15;
						break;

					case "Petabyte":
						result = value*1e-15;
						break;
				}
				break;

			case "Kilobit":
				switch (toItemSelected) {
					case "Bit":
						result = value*1000;
						break;

					case "Byte":
						result = value*125;
						break;

					case "Kilobit":
						result = value;
						break;

					case "Kilobyte":
						result = value*0.125;
						break;

					case "Megabit":
						result = value*0.001;
						break;

					case "Megabyte":
						result = value*0.000125;
						break;

					case "Gigabit":
						result = value*1e-6;
						break;

					case "Gigabyte":
						result = value*1.25e-7;
						break;

					case "Terabit":
						result = value*1e-9;
						break;

					case "Terabyte":
						result = value*1.25e-10;
						break;

					case "Petabit":
						result = value*1e-12;
						break;

					case "Petabyte":
						result = value*1.25e-13;
						break;
				}
				break;

			case "Kilobyte":
				switch (toItemSelected) {
					case "Bit":
						result = value*8000;
						break;

					case "Byte":
						result = value*1000;
						break;

					case "Kilobit":
						result = value*8;
						break;

					case "Kilobyte":
						result = value;
						break;

					case "Megabit":
						result = value*0.008;
						break;

					case "Megabyte":
						result = value*0.001;
						break;

					case "Gigabit":
						result = value*8e-6;
						break;

					case "Gigabyte":
						result = value*1e-6;
						break;

					case "Terabit":
						result = value*8e-9;
						break;

					case "Terabyte":
						result = value*1e-9;
						break;

					case "Petabit":
						result = value*8e-12;
						break;

					case "Petabyte":
						result = value*1e-12;
						break;
				}
				break;

			case "Megabit":
				switch (toItemSelected) {
					case "Bit":
						result = value*1e+6;
						break;

					case "Byte":
						result = value*125000;
						break;

					case "Kilobit":
						result = value*1000;
						break;

					case "Kilobyte":
						result = value*125;
						break;

					case "Megabit":
						result = value;
						break;

					case "Megabyte":
						result = value*0.125;
						break;

					case "Gigabit":
						result = value*0.001;
						break;

					case "Gigabyte":
						result = value*0.000125;
						break;

					case "Terabit":
						result = value*1e-6;
						break;

					case "Terabyte":
						result = value*1.25e-7;
						break;

					case "Petabit":
						result = value*1e-9;
						break;

					case "Petabyte":
						result = value*1.25e-10;
						break;
				}
				break;

			case "Megabyte":
				switch (toItemSelected) {
					case "Bit":
						result = value*8e+6;
						break;

					case "Byte":
						result = value*1e+6;
						break;

					case "Kilobit":
						result = value*8000;
						break;

					case "Kilobyte":
						result = value*1000;
						break;

					case "Megabit":
						result = value*8;
						break;

					case "Megabyte":
						result = value;
						break;

					case "Gigabit":
						result = value*0.008;
						break;

					case "Gigabyte":
						result = value*0.001;
						break;

					case "Terabit":
						result = value*8e-6;
						break;

					case "Terabyte":
						result = value*1e-6;
						break;

					case "Petabit":
						result = value*8e-9;
						break;

					case "Petabyte":
						result = value*1e-9;
						break;
				}
				break;

			case "Gigabit":
				switch (toItemSelected) {
					case "Bit":
						result = value*1e+9;
						break;

					case "Byte":
						result = value*1.25e+8;
						break;

					case "Kilobit":
						result = value*1e+6;
						break;

					case "Kilobyte":
						result = value*125000;
						break;

					case "Megabit":
						result = value*1000;
						break;

					case "Megabyte":
						result = value*125;
						break;

					case "Gigabit":
						result = value;
						break;

					case "Gigabyte":
						result = value*0.008;
						break;

					case "Terabit":
						result = value*0.001;
						break;

					case "Terabyte":
						result = value*0.000125;
						break;

					case "Petabit":
						result = value*1e-6;
						break;

					case "Petabyte":
						result = value*1.25e-7;
						break;
				}
				break;

			case "Gigabyte":
				switch (toItemSelected) {
					case "Bit":
						result = value*8e+9;
						break;

					case "Byte":
						result = value*1e+9;
						break;

					case "Kilobit":
						result = value*8e+6;
						break;

					case "Kilobyte":
						result = value*1e+6;
						break;

					case "Megabit":
						result = value*8000;
						break;

					case "Megabyte":
						result = value*1000;
						break;

					case "Gigabit":
						result = value*8;
						break;

					case "Gigabyte":
						result = value;
						break;

					case "Terabit":
						result = value*0.008;
						break;

					case "Terabyte":
						result = value*0.001;
						break;

					case "Petabit":
						result = value*8e-6;
						break;

					case "Petabyte":
						result = value*1e-6;
						break;
				}
				break;

			case "Terabit":
				switch (toItemSelected) {
					case "Bit":
						result = value*1e+12;
						break;

					case "Byte":
						result = value*1.25e+11;
						break;

					case "Kilobit":
						result = value*1e+9;
						break;

					case "Kilobyte":
						result = value*1.25e+8;
						break;

					case "Megabit":
						result = value*1e+6;
						break;

					case "Megabyte":
						result = value*1000;
						break;

					case "Gigabit":
						result = value*125000;
						break;

					case "Gigabyte":
						result = value*125;
						break;

					case "Terabit":
						result = value;
						break;

					case "Terabyte":
						result = value*0.125;
						break;

					case "Petabit":
						result = value*0.001;
						break;

					case "Petabyte":
						result = value*0.000125;
						break;
				}
				break;

			case "Terabyte":
				switch (toItemSelected) {
					case "Bit":
						result = value*8e+12;
						break;

					case "Byte":
						result = value*1e+12;
						break;

					case "Kilobit":
						result = value*8e+9;
						break;

					case "Kilobyte":
						result = value*1e+9;
						break;

					case "Megabit":
						result = value*8e+6;
						break;

					case "Megabyte":
						result = value*1e+6;
						break;

					case "Gigabit":
						result = value*8000;
						break;

					case "Gigabyte":
						result = value*1000;
						break;

					case "Terabit":
						result = value*8;
						break;

					case "Terabyte":
						result = value;
						break;

					case "Petabit":
						result = value*0.008;
						break;

					case "Petabyte":
						result = value*0.001;
						break;
				}
				break;

			case "Petabit":
				switch (toItemSelected) {
					case "Bit":
						result = value*1e+15;
						break;

					case "Byte":
						result = value*1.25e+14;
						break;

					case "Kilobit":
						result = value*1e+12;
						break;

					case "Kilobyte":
						result = value*1.25e+11;
						break;

					case "Megabit":
						result = value*1e+9;
						break;

					case "Megabyte":
						result = value*1.25e+8;
						break;

					case "Gigabit":
						result = value*1e+6;
						break;

					case "Gigabyte":
						result = value*125000;
						break;

					case "Terabit":
						result = value*1000;
						break;

					case "Terabyte":
						result = value*125;
						break;

					case "Petabit":
						result = value;
						break;

					case "Petabyte":
						result = value*0.125;
						break;
				}
				break;

			case "Petabyte":
				switch (toItemSelected) {
					case "Bit":
						result = value*8e+15;
						break;

					case "Byte":
						result = value*1e+15;
						break;

					case "Kilobit":
						result = value*8e+12;
						break;

					case "Kilobyte":
						result = value*1e+12;
						break;

					case "Megabit":
						result = value*8e+9;
						break;

					case "Megabyte":
						result = value*1e+9;
						break;

					case "Gigabit":
						result = value*8e+6;
						break;

					case "Gigabyte":
						result = value*1e+6;
						break;

					case "Terabit":
						result = value*8000;
						break;

					case "Terabyte":
						result = value*1000;
						break;

					case "Petabit":
						result = value*8;
						break;

					case "Petabyte":
						result = value;
						break;
				}
				break;
		}

	}

	public void calculateSpeed() {
		fromItemSelected = String.valueOf(fromDropdownList.getSelectedItem());
		toItemSelected = String.valueOf(toDropdownList.getSelectedItem());

		switch (fromItemSelected) {
			case "Kilometer/hour":
				switch (toItemSelected) {
					case "Kilometer/hour":
						result = value;
						break;

					case "Mile/hour":
						result = value*0.621371;
						break;

					case "Metre/second":
						result = value*0.277778;
						break;

					case "Foot/second":
						result = value*0.911344;
						break;

					case "Knot":
						result = value*0.539957;
						break;
				}
				break;

			case "Mile/hour":
				switch (toItemSelected) {
					case "Kilometer/hour":
						result = value*1.60934;
						break;

					case "Mile/hour":
						result = value;
						break;

					case "Metre/second":
						result = value*0.44704;
						break;

					case "Foot/second":
						result = value*1.46667;
						break;

					case "Knot":
						result = value*0.868976;
						break;
				}
				break;

			case "Metre/second":
				switch (toItemSelected) {
					case "Kilometer/hour":
						result = value*3.6;
						break;

					case "Mile/hour":
						result = value*2.23694;
						break;

					case "Metre/second":
						result = value;
						break;

					case "Foot/second":
						result = value*3.28084;
						break;

					case "Knot":
						result = value*1.94384;
						break;
				}
				break;

			case "Foot/second":
				switch (toItemSelected) {
					case "Kilometer/hour":
						result = value*1.09728;
						break;

					case "Mile/hour":
						result = value*0.681818;
						break;

					case "Metre/second":
						result = value*0.3048;
						break;

					case "Foot/second":
						result = value;
						break;

					case "Knot":
						result = value*0.592484;
						break;
				}
				break;

			case "Knot":
				switch (toItemSelected) {
					case "Kilometer/hour":
						result = value*1.852;
						break;

					case "Mile/hour":
						result = value*1.15078;
						break;

					case "Metre/second":
						result = value*0.514444;
						break;

					case "Foot/second":
						result = value*1.68781;
						break;

					case "Knot":
						result = value;
						break;
				}
				break;
		}

	}

	public void calculateTime() {
		fromItemSelected = String.valueOf(fromDropdownList.getSelectedItem());
		toItemSelected = String.valueOf(toDropdownList.getSelectedItem());

		switch (fromItemSelected) {
			case "Year":
				switch (toItemSelected) {
					case "Year":
						result = value;
						break;

					case "Month":
						result = value * 12;
						break;

					case "Week":
						result = value * 52.1429;
						break;

					case "Day":
						result = value * 365;
						break;

					case "Hour":
						result = value * 8760;
						break;

					case "Minute":
						result = value * 525600;
						break;

					case "Second":
						result = value * 3.154e+7;
						break;

					case "Millisecond":
						result = value * 3.154e+10;
						break;

					case "Nanosecond":
						result = value * 3.154e+16;
						break;
				}
				break;

			case "Month":
				switch (toItemSelected) {
					case "Year":
						result = value/12;
						break;

					case "Month":
						result = value;
						break;

					case "Week":
						result = value * 4.345;
						break;

					case "Day":
						result = value * 30.417;
						break;

					case "Hour":
						result = value * 730;
						break;

					case "Minute":
						result = value * 43800;
						break;

					case "Second":
						result = value * 2.628e+6;
						break;

					case "Millisecond":
						result = value * 2.628e+9;
						break;

					case "Nanosecond":
						result = value * 2.628e+15;
						break;
				}
				break;

			case "Week":
				switch (toItemSelected) {
					case "Year":
						result = value / 52.143;
						break;

					case "Month":
						result = value / 4.345;
						break;

					case "Week":
						result = value;
						break;

					case "Day":
						result = value * 7;
						break;

					case "Hour":
						result = value * 168;
						break;

					case "Minute":
						result = value * 10080;
						break;

					case "Second":
						result = value * 604800;
						break;

					case "Millisecond":
						result = value * 6.048e+8;
						break;

					case "Nanosecond":
						result = value * 6.048e+14;
						break;
				}
				break;

			case "Day":
				switch (toItemSelected) {
					case "Year":
						result = value / 365;
						break;

					case "Month":
						result = value / 30.417;
						break;

					case "Week":
						result = value / 7;
						break;

					case "Day":
						result = value;
						break;

					case "Hour":
						result = value * 24;
						break;

					case "Minute":
						result = value * 1440;
						break;

					case "Second":
						result = value * 86400;
						break;

					case "Millisecond":
						result = value * 8.64e+7;
						break;

					case "Nanosecond":
						result = value * 8.64e+13;
						break;
				}
				break;

			case "Hour":
				switch (toItemSelected) {
					case "Year":
						result = value / 8760;
						break;

					case "Month":
						result = value / 730;
						break;

					case "Week":
						result = value / 168;
						break;

					case "Day":
						result = value / 24;
						break;

					case "Hour":
						result = value;
						break;

					case "Minute":
						result = value * 60;
						break;

					case "Second":
						result = value * 3600;
						break;

					case "Millisecond":
						result = value * 3.6e+6;
						break;

					case "Nanosecond":
						result = value * 3.6e+12;
						break;
				}
				break;

			case "Minute":
				switch (toItemSelected) {
					case "Year":
						result = value / 525600;
						break;

					case "Month":
						result = value / 43800;
						break;

					case "Week":
						result = value / 10080;
						break;

					case "Day":
						result = value / 1440;
						break;

					case "Hour":
						result = value / 60;
						break;

					case "Minute":
						result = value;
						break;

					case "Second":
						result = value * 60;
						break;

					case "Millisecond":
						result = value * 60000;
						break;

					case "Nanosecond":
						result = value * 6e+10;
						break;
				}
				break;

			case "Second":
				switch (toItemSelected) {
					case "Year":
						result = value / 3.154e+7;
						break;

					case "Month":
						result = value / 2.628e+6;
						break;

					case "Week":
						result = value / 604800;
						break;

					case "Day":
						result = value / 86400;
						break;

					case "Hour":
						result = value / 3600;
						break;

					case "Minute":
						result = value / 60;
						break;

					case "Second":
						result = value;
						break;

					case "Millisecond":
						result = value * 1000;
						break;

					case "Nanosecond":
						result = value * 1e+9;
						break;
				}
				break;

			case "Millisecond":
				switch (toItemSelected) {
					case "Year":
						result = value / 3.154e+10;
						break;

					case "Month":
						result = value / 2.628e+9;
						break;

					case "Week":
						result = value / 6.048e+8;
						break;

					case "Day":
						result = value / 8.64e+7;
						break;

					case "Hour":
						result = value / 3.6e+6;
						break;

					case "Minute":
						result = value / 6000;
						break;

					case "Second":
						result = value / 1000;
						break;

					case "Millisecond":
						result = value;
						break;

					case "Nanosecond":
						result = value * 1e+6;
						break;
				}
				break;

			case "Nanosecond":
				switch (toItemSelected) {
					case "Year":
						result = value / 3.154e+16;
						break;

					case "Month":
						result = value / 2.628e+15;
						break;

					case "Week":
						result = value / 6.048e+14;
						break;

					case "Day":
						result = value / 8.64e+13;
						break;

					case "Hour":
						result = value / 3.6e+12;
						break;

					case "Minute":
						result = value / 6e+10;
						break;

					case "Second":
						result = value / 1e+9;
						break;

					case "Millisecond":
						result = value / 1e+6;
						break;

					case "Nanosecond":
						result = value;
						break;
				}
				break;
		}
	}

	public void calculateTemperature() {
		fromItemSelected = String.valueOf(fromDropdownList.getSelectedItem());
		toItemSelected = String.valueOf(toDropdownList.getSelectedItem());

		switch (fromItemSelected){
			case "Celsius":
				switch (toItemSelected){
					case "Celsius":
						result = value;
						break;

					case "Fahrenheit":
						result = (value * 9/5) + 32;
						break;

					case "Kelvin":
						result = value  + 273.15;
						break;

					case "Rankine":
						result = value * 9/5 + 491.67 ;
						break;

					case"Delisle":
						result = (100 - value) * 3/2;
						break;

					case "Newton":
						result = value * 33/100;
						break;

					case "Reaumur":
						result = value * 4/5;
						break;

					case"Romer":
						result = value * 21/40 + 7.5;
						break;
				}
				break;

			case "Fahrenheit":
				switch (toItemSelected){
					case "Celsius":
						result = (value - 32) * 5/9;
						break;

					case "Fahrenheit":
						result = value;
						break;

					case "Kelvin":
						result = (value - 32) * 5/9 + 273.15;
						break;

					case "Rankine":
						result = value + 459.67 ;
						break;

					case"Delisle":
						result = (value - 32)* 0.83333-100.00;
						break;

					case "Newton":
						result = (value - 32)* 0.18333;
						break;

					case "Reaumur":
						result = (value - 32)* 0.44444;
						break;

					case"Romer":
						result = -1.5416666666667;
						break;
				}
				break;

			case "Kelvin":
				switch (toItemSelected){
					case "Celsius":
						result = - 273.15;
						break;

					case "Fahrenheit":
						result = (value - 273.15) * 9/5 + 32;
						break;

					case "Kelvin":
						result = value;
						break;

					case "Rankine":
						result = value * 1.8;
						break;

					case"Delisle":
						result = (value - 273.15)* 1.5000-100.00;
						break;

					case "Newton":
						result = (value - 273.15)* 0.33000;
						break;

					case "Reaumur":
						result = (value - 273.15)* 0.80000;
						break;

					case"Romer":
						result = (value - 273.15)* 0.52500+ 7.50;
						break;
				}
				break;

			case "Rankine":
				switch (toItemSelected){
					case "Celsius":
						result = (value - 491.67) * 5/9;
						break;

					case "Fahrenheit":
						result = value - 459.67;
						break;

					case "Kelvin":
						result = value * 5/9;
						break;

					case "Rankine":
						result = value;
						break;

					case"Delisle":
						result = (value - 491.67)* 0.83333-100.00;
						break;

					case "Newton":
						result = (value - 491.67)* 0.18333;
						break;

					case "Reaumur":
						result = (value - 491.67)* 0.44444;
						break;

					case"Romer":
						result = (value - 491.67)* 0.29167+ 7.50;
						break;
				}
				break;

			case "Delisle":
				switch (toItemSelected){
					case "Celsius":
						result = (value + 100)/1.5000;
						break;

					case "Fahrenheit":
						result = (value + 100)* 1.2000+ 32.00;
						break;

					case "Kelvin":
						result = value * 5/9;
						break;

					case "Rankine":
						result = (value + 100)/1.5000+ 273.15;
						break;

					case"Delisle":
						result = value;
						break;

					case "Newton":
						result = (value + 100)* 0.22000;
						break;

					case "Reaumur":
						result = (80 -value)* 8/15;
						break;

					case"Romer":
						result = (60 - value)* 7/20;
						break;
				}
				break;

			case "Newton":
				switch (toItemSelected){
					case "Celsius":
						result = value/0.33000;
						break;

					case "Fahrenheit":
						result = value * 5.4545+ 32.00;
						break;

					case "Kelvin":
						result = (value/0.33000)+ 273.15 ;
						break;

					case "Rankine":
						result =value * 60 / 11 + 491.67;
						break;

					case"Delisle":
						result = ( 33 - value ) * 50 / 11;
						break;

					case "Newton":
						result = value;
						break;

					case "Reaumur":
						result = value * 80/33;
						break;

					case"Romer":
						result = value * 35/22 + 7.5;
						break;
				}
				break;

			case "Reaumur":
				switch (toItemSelected){
					case "Celsius":
						result = value/0.80000;
						break;

					case "Fahrenheit":
						result = value * 2.2500+ 32.00;
						break;

					case "Kelvin":
						result = (value/0.80000)+ 273.15 ;
						break;

					case "Rankine":
						result = value * 2.2500+ 491.67;
						break;

					case"Delisle":
						result = value * 1.8750-100.00;
						break;

					case "Newton":
						result = value * 0.41250;
						break;

					case "Reaumur":
						result = value;
						break;

					case"Romer":
						result = value * 0.65625+ 7.50;
						break;
				}
				break;

			case "Romer":
				switch (toItemSelected){
					case "Celsius":
						result = (value - 7.5) * 40/21;
						break;

					case "Fahrenheit":
						result = (value - 7.5)* 3.4286+ 32.00;
						break;

					case "Kelvin":
						result = (value/0.52500)+ 273.15 ;
						break;

					case "Rankine":
						result = (value - 7.5)* 3.4286+ 491.67;
						break;

					case"Delisle":
						result = (60 - value)* 20/7;
						break;

					case "Newton":
						result = ( value - 7.5)* 22/35;
						break;

					case "Reaumur":
						result = ( value - 7.5)* 32/21;
						break;

					case"Romer":
						result = value;
						break;
				}
				break;
		}
	}

	public void calculateCooking() {
		fromItemSelected = String.valueOf(fromDropdownList.getSelectedItem());
		toItemSelected = String.valueOf(toDropdownList.getSelectedItem());

		switch (fromItemSelected){
			case "Teaspoon" :
				switch (toItemSelected){
					case "Teaspoon":
						result = value;
						break;

					case "Tablespoon":
						result = value*0.3333;
						break;

					case "Cup":
						result = value*0.0208;
						break;

					case "Fluid Ounce (US)":
						result = value*0.1667;
						break;

					case "Fluid Ounce (UK)":
						result = value*0.1735;
						break;

					case "Pint (US)":
						result = value*0.0104;
						break;

					case "Pint (UK)":
						result = value*0.0087;
						break;

					case "Quart (US)":
						result = value*0.0052;
						break;

					case "Quart (UK)":
						result = value*0.0043;
						break;

					case "Gallon (US)":
						result = value*0.0013;
						break;

					case  "Gallon (UK)":
						result = value*0.0011;
						break;

					case  "Millilitre":
						result = value*4.9289;
						break;

					case "litre":
						result = value*0.0049;
						break;
				}
				break;

			case "Tablespoon" :
				switch (toItemSelected){
					case "Teaspoon":
						result = value*3;
						break;

					case "Tablespoon":
						result = value;
						break;

					case "Cup":
						result = value*0.0625;
						break;

					case "Fluid Ounce (US)":
						result = value*0.5;
						break;

					case "Fluid Ounce (UK)":
						result = value*0.5204;
						break;

					case "Pint (US)":
						result = value*0.0312;
						break;

					case "Pint (UK)":
						result = value*0.026;
						break;

					case "Quart (US)":
						result = value*0.0156;
						break;

					case "Quart (UK)":
						result = value*0.013;
						break;

					case "Gallon (US)":
						result = value*0.0039;
						break;

					case  "Gallon (UK)":
						result = value*0.0033;
						break;

					case  "Millilitre":
						result = value*14.7868;
						break;

					case "litre":
						result = value*0.0148;
						break;
				}
				break;

			case "Cup" :
				switch (toItemSelected){
					case "Teaspoon":
						result = value*48;
						break;

					case "Tablespoon":
						result = value*16;
						break;

					case "Cup":
						result = value;
						break;

					case "Fluid Ounce (US)":
						result = value*8;
						break;

					case "Fluid Ounce (UK)":
						result = value*8.3267;
						break;

					case "Pint (US)":
						result = value*0.5;
						break;

					case "Pint (UK)":
						result = value*0.4163;
						break;

					case "Quart (US)":
						result = value*0.25;
						break;

					case "Quart (UK)":
						result = value*0.2082;
						break;

					case "Gallon (US)":
						result = value*0.0625;
						break;

					case  "Gallon (UK)":
						result = value*0.052;
						break;

					case  "Millilitre":
						result = value*236.5882;
						break;

					case "litre":
						result = value*0.2366;
						break;
				}
				break;

			case "Fluid Ounce (US)" :
				switch (toItemSelected){
					case "Teaspoon":
						result = value*6;
						break;

					case "Tablespoon":
						result = value*2;
						break;

					case "Cup":
						result = value*0.125;
						break;

					case "Fluid Ounce (US)":
						result = value;
						break;

					case "Fluid Ounce (UK)":
						result = value*1.0408;
						break;

					case "Pint (US)":
						result = value*0.0625;
						break;

					case "Pint (UK)":
						result = value*0.052;
						break;

					case "Quart (US)":
						result = value*0.0312;
						break;

					case "Quart (UK)":
						result = value*0.026;
						break;

					case "Gallon (US)":
						result = value*0.0078;
						break;

					case  "Gallon (UK)":
						result = value*0.0065;
						break;

					case  "Millilitre":
						result = value*29.5735;
						break;

					case "litre":
						result = value*0.0296;
						break;
				}
				break;

			case "Fluid Ounce (UK)" :
				switch (toItemSelected){
					case "Teaspoon":
						result = value*5.7646;
						break;

					case "Tablespoon":
						result = value*1.9215;
						break;

					case "Cup":
						result = value*0.1201;
						break;

					case "Fluid Ounce (US)":
						result = value*0.9608;
						break;

					case "Fluid Ounce (UK)":
						result = value;
						break;

					case "Pint (US)":
						result = value*0.06;
						break;

					case "Pint (UK)":
						result = value*0.05;
						break;

					case "Quart (US)":
						result = value*0.03;
						break;

					case "Quart (UK)":
						result = value*0.025;
						break;

					case "Gallon (US)":
						result = value*0.0075;
						break;

					case  "Gallon (UK)":
						result = value*0.0062;
						break;

					case  "Millilitre":
						result = value*28.4131;
						break;

					case "litre":
						result = value*0.0284;
						break;
				}
				break;

			case "Pint (US)" :
				switch (toItemSelected){
					case "Teaspoon":
						result = value*96;
						break;

					case "Tablespoon":
						result = value*32;
						break;

					case "Cup":
						result = value*2;
						break;

					case "Fluid Ounce (US)":
						result = value*16;
						break;

					case "Fluid Ounce (UK)":
						result = value*16.6535;
						break;

					case "Pint (US)":
						result = value;
						break;

					case "Pint (UK)":
						result = value*0.8327;
						break;

					case "Quart (US)":
						result = value*0.5;
						break;

					case "Quart (UK)":
						result = value*0.4163;
						break;

					case "Gallon (US)":
						result = value*0.125;
						break;

					case  "Gallon (UK)":
						result = value*0.1041;
						break;

					case  "Millilitre":
						result = value*473.1765;
						break;

					case "litre":
						result = value*0.4732;
						break;
				}
				break;

			case "Pint (UK)" :
				switch (toItemSelected){
					case "Teaspoon":
						result = value*115.2912;
						break;

					case "Tablespoon":
						result = value*38.4304;
						break;

					case "Cup":
						result = value*2.4019;
						break;

					case "Fluid Ounce (US)":
						result = value*19.2152;
						break;

					case "Fluid Ounce (UK)":
						result = value*20;
						break;

					case "Pint (US)":
						result = value*1.2009;
						break;

					case "Pint (UK)":
						result = value;
						break;

					case "Quart (US)":
						result = value*0.6005;
						break;

					case "Quart (UK)":
						result = value*0.5;
						break;

					case "Gallon (US)":
						result = value*0.1501;
						break;

					case  "Gallon (UK)":
						result = value*0.125;
						break;

					case  "Millilitre":
						result = value*568.2612;
						break;

					case "litre":
						result = value*0.5683;
						break;
				}
				break;

			case "Quart (US)" :
				switch (toItemSelected){
					case "Teaspoon":
						result = value*192;
						break;

					case "Tablespoon":
						result = value * 64 ;
						break;

					case "Cup":
						result = value * 4 ;
						break;

					case "Fluid Ounce (US)":
						result = value * 32 ;
						break;

					case "Fluid Ounce (UK)":
						result = value*33.307;
						break;

					case "Pint (US)":
						result = value*2;
						break;

					case "Pint (UK)":
						result = value*1.6653;
						break;

					case "Quart (US)":
						result = value;
						break;

					case "Quart (UK)":
						result = value*0.8327;
						break;

					case "Gallon (US)":
						result = value*0.25;
						break;

					case  "Gallon (UK)":
						result = value*0.2082;
						break;

					case  "Millilitre":
						result = value*946.3529;
						break;

					case "litre":
						result = value*0.9464;
						break;
				}
				break;

			case "Quart (UK)" :
				switch (toItemSelected){
					case "Teaspoon":
						result = value * 230.5824;
						break;

					case "Tablespoon":
						result = value * 76.8608;
						break;

					case "Cup":
						result = value * 4.8038;
						break;

					case "Fluid Ounce (US)":
						result = value * 38.4304;
						break;

					case "Fluid Ounce (UK)":
						result = value * 40;
						break;

					case "Pint (US)":
						result = value * 2.4019 ;
						break;

					case "Pint (UK)":
						result = value*2;

					case "Quart (US)":
						result = value * 1.2009;
						break;

					case "Quart (UK)":
						result = value;
						break;

					case "Gallon (US)":
						result = value*0.3002;
						break;

					case  "Gallon (UK)":
						result = value * 0.25;
						break;

					case  "Millilitre":
						result = value*1136.5225;
						break;

					case "litre":
						result = value*1.1365;
						break;
				}
				break;

			case "Gallon (US)" :
				switch (toItemSelected){
					case "Teaspoon":
						result = value * 768;
						break;

					case "Tablespoon":
						result = value * 256;
						break;

					case "Cup":
						result = value * 16;
						break;

					case "Fluid Ounce (US)":
						result = value * 128;
						break;

					case "Fluid Ounce (UK)":
						result = value * 133.2279;
						break;

					case "Pint (US)":
						result = value * 8 ;
						break;

					case "Pint (UK)":
						result = value*6.6614;
						break;

					case "Quart (US)":
						result = value *4;
						break;

					case "Quart (UK)":
						result = value* 3.3307;
						break;

					case "Gallon (US)":
						result = value;
						break;

					case  "Gallon (UK)":
						result = value * 0.8327;
						break;

					case  "Millilitre":
						result = value*3785.4118;
						break;

					case "litre":
						result = value*3.7854;
						break;
				}
				break;

			case "Gallon (UK)" :
				switch (toItemSelected){
					case "Teaspoon":
						result = value * 922.3295;
						break;

					case "Tablespoon":
						result = value *  307.4432;
						break;

					case "Cup":
						result = value *19.2152;
						break;

					case "Fluid Ounce (US)":
						result = value * 153.7216;
						break;

					case "Fluid Ounce (UK)":
						result = value *160;
						break;

					case "Pint (US)":
						result = value * 9.6076;
						break;

					case "Pint (UK)":
						result = value * 8;
						break;

					case "Quart (US)":
						result = value *4.8038;
						break;

					case "Quart (UK)":
						result = value*4;
						break;

					case "Gallon (US)":
						result = value*1.2009;
						break;

					case  "Gallon (UK)":
						result = value;
						break;

					case  "Millilitre":
						result = value*4546.09;
						break;

					case "litre":
						result = value*4.5461;
						break;
				}
				break;

			case "Millilitre" :
				switch (toItemSelected){
					case "Teaspoon":
						result = value*0.2029;
						break;

					case "Tablespoon":
						result = value*0.0676;
						break;

					case "Cup":
						result = value * 0.0042;
						break;

					case "Fluid Ounce (US)":
						result = value *0.0338;
						break;

					case "Fluid Ounce (UK)":
						result = value * 0.0352;
						break;

					case "Pint (US)":
						result = value *0.0021;
						break;

					case "Pint (UK)":
						result = value * 0.0018;

					case "Quart (US)":
						result = value * 0.0011;
						break;

					case "Quart (UK)":
						result = value*0.0009;
						break;

					case "Gallon (US)":
						result = value*0.0003;
						break;

					case  "Gallon (UK)":
						result = value *0.0002;
						break;

					case  "Millilitre":
						result = value ;
						break;

					case "litre":
						result = value*0.001;
						break;
				}
				break;

			case "litre" :
				switch (toItemSelected){
					case "Teaspoon":
						result = value * 202.8841;
						break;

					case "Tablespoon":
						result = value * 67.628;
						break;

					case "Cup":
						result = value * 4.2268;
						break;

					case "Fluid Ounce (US)":
						result = value *  33.814;
						break;

					case "Fluid Ounce (UK)":
						result = value * 35.1951;
						break;

					case "Pint (US)":
						result = value * 2.1134;
						break;

					case "Pint (UK)":
						result = value * 1.7598;
						break;

					case "Quart (US)":
						result = value * 1.0567;
						break;

					case "Quart (UK)":
						result = value* 0.8799;
						break;

					case "Gallon (US)":
						result = value*0.2642;
						break;

					case  "Gallon (UK)":
						result = value*0.22;
						break;

					case  "Millilitre":
						result = value* 1000;
						break;

					case "litre":
						result = value;
						break;
				}
				break;
		}
	}

	@SuppressLint("SetTextI18n")
	public void setCalculateButton(View view) {
		if(TextUtils.isEmpty(valueEditText.getText().toString())){
			valueEditText.setError("Please enter the corresponding value");
		}
		else {
			value = Double.parseDouble(valueEditText.getText().toString());

			switch (position) {
				case 0:
					calculateMass();
					break;

				case 1:
					calculateLength();
					break;

				case 2:
					calculateArea();
					break;

				case 3:
					calculateDataStorage();
					break;

				case 4:
					calculateSpeed();
					break;

				case 5:
					calculateTime();
					break;

				case 6:
					calculateTemperature();
					break;

				case 7:
					calculateCooking();
					break;
			}

			if (((value % 1) == 0) && ((result % 1) == 0)) {
				resultTextView.setText(String.valueOf((int)result));
				detailedResultTextView.setText((int)value + " " + fromItemSelected + " = " + (int)result + " " + toItemSelected);
			}
			else if ((value % 1) == 0) {
				resultTextView.setText(String.valueOf(result));
				detailedResultTextView.setText((int)value + " " + fromItemSelected + " = " + result + " " + toItemSelected);
			}
			else if ((result % 1) == 0) {
				resultTextView.setText(String.valueOf((int)result));
				detailedResultTextView.setText(value + " " + fromItemSelected + " = " + (int)result + " " + toItemSelected);
			}
			else {
				resultTextView.setText(String.valueOf(result));
				detailedResultTextView.setText(value + " " + fromItemSelected + " = " + result + " " + toItemSelected);
			}

			valueEditText.setText("");
		}
	}

	public void setShuffleButton(View view) {
		fromItemSelected = String.valueOf(fromDropdownList.getSelectedItem());
		toItemSelected = String.valueOf(toDropdownList.getSelectedItem());

		fromDropdownList.setSelection(toAdapter.getPosition(toItemSelected));
		toDropdownList.setSelection(fromAdapter.getPosition(fromItemSelected));
	}
}