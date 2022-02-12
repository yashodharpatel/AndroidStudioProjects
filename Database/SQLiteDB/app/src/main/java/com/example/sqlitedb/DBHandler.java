package com.example.sqlitedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {
	private static final String DB_NAME = "empDB";
	private static final int DB_VERSION = 1;

	public DBHandler(@Nullable Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String query = "CREATE TABLE employee (" +
				"emp_id INT PRIMARY KEY," +
				"name TEXT," +
				"increment TEXT" +
				")";
		db.execSQL(query);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS employee", new String[]{"employee"});
		onCreate(db);
	}

	public void addEmployee(Employee employee){
		SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put("id", employee.getEmp_id());
		contentValues.put("name", employee.getName());
		contentValues.put("increment", employee.getIncrement());
		sqLiteDatabase.insert("employee", null, contentValues);
		sqLiteDatabase.close();
	}

	public void getEmployee(int emp_id){
		SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
		Cursor cursor = sqLiteDatabase.query("employee", new String[]{"01", "Yashodhar", "34.90"}, "emp_id",
				new String[]{"emp_id"}, null, null, null);
	}

}
