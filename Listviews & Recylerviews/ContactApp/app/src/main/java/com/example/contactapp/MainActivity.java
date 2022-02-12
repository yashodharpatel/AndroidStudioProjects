package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
	RecyclerView recyclerView;

	Contact contact0 = new Contact("Yash", "9767532611");
	Contact contact1 = new Contact("Prerna", "7499207035");
	Contact contact2 = new Contact("Abhi", "7499207030");
	Contact contact3 = new Contact("Sanjay", "9767532611");
	Contact contact4 = new Contact("Seema", "9767532611");
	Contact contact5 = new Contact("Pooja", "9767532611");
	Contact contact6 = new Contact("Mohan", "9767532611");
	Contact contact7 = new Contact("Rohan", "9767532611");
	Contact contact8 = new Contact("Ajeetesh", "9767532611");
	Contact contact9 = new Contact("Anil", "9767532611");
	Contact contact10 = new Contact("Hemal", "9767532611");

	Contact[] contacts = {contact0, contact1, contact2, contact3, contact4, contact5, contact6, contact7, contact8, contact9, contact10};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ContactAdapter ad = new ContactAdapter(this, contacts);
		recyclerView = findViewById(R.id.recyclerView);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
		recyclerView.setAdapter(ad);
	}
}