package com.example.isangeet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
	RecyclerView recyclerView;

	//	Method which returns all mp3 files from a storage
	public ArrayList<File> fetchSongs(File file) {
		ArrayList arrayList = new ArrayList();
		File [] songs = file.listFiles();
		if(songs != null) {
			for (File myFile : songs) {
				if(!myFile.isHidden() && myFile.isDirectory()) {
					arrayList.addAll(fetchSongs(myFile));
				}
				else {
					if(myFile.getName().endsWith(".mp3") && !myFile.getName().startsWith(".")) {
						arrayList.add(myFile);
					}
				}
			}
		}
		return arrayList;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		recyclerView = findViewById(R.id.recyclerView);

		Dexter.withContext(this)
				.withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
				.withListener(new PermissionListener() {
					@Override
					public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
						ArrayList<File> songs = fetchSongs(Environment.getExternalStorageDirectory());
						String[] songList = new String[songs.size()];
						for (int i = 0; i < songs.size(); i++){
							songList[i] = songs.get(i).getName().replace(".mp3", "");
						}
						Adapter adapter = new Adapter(MainActivity.this, songList, songs);
						recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
						recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL));
						recyclerView.setAdapter(adapter);
					}

					@Override
					public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

					}

					@Override
					public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
						permissionToken.continuePermissionRequest();
					}
				})
				.check();
	}
}