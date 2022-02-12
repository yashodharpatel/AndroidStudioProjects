package com.example.contactapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
	private static final String DB_NAME = "contactDb";
	private static final int DB_VERSION = 1;
	private static final String TABLE_NAME = "myContacts";

	public DBHandler(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String query = "CREATE TABLE " + TABLE_NAME + "(" +
				"name TEXT," +
				"phone TEXT," +
				"email TEXT PRIMARY KEY," +
				"concern TEXT)";
		db.execSQL(query);
	}

	public void addNewContact(String name, String phone, String email, String concern){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put("name", name);
		values.put("phone", phone);
		values.put("email", email);
		values.put("concern", concern);

		db.insert(TABLE_NAME, null, values);
		db.close();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(db);
	}
}
