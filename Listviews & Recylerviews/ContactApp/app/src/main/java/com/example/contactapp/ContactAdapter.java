package com.example.contactapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
	public static final String EXTRA_NAME = "com.example.contactapp.NAME";
	public static final String EXTRA_PHONE = "com.example.contactapp.PHONE";

	private static Context context;
	private final Contact[] contacts;

	public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
		private final TextView Name;
		private final TextView mobileNo;

		public ViewHolder(View view) {
			super(view);

			view.setOnClickListener(this);

			Name = (TextView) view.findViewById(R.id.Name);
			mobileNo = (TextView) view.findViewById(R.id.mobileNo);
		}

		public TextView getName() {
			return Name;
		}

		public TextView getMobileNo() {
			return mobileNo;
		}

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(context, MainActivity2.class);
			String sendName = Name.getText().toString();
			String sendPhone = mobileNo.getText().toString();
			intent.putExtra(EXTRA_NAME, sendName);
			intent.putExtra(EXTRA_PHONE, sendPhone);
			context.startActivity(intent);
		}
	}

	@Override
	public int getItemCount() {
		return contacts.length;
	}

	public ContactAdapter(Context context, Contact[] contacts) {
		this.context = context;
		this.contacts = contacts;
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
		View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contact, viewGroup, false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ViewHolder viewHolder, final int position) {
		viewHolder.getName().setText(contacts[position].getName());
		viewHolder.getMobileNo().setText(contacts[position].getMobileNo());
	}
}