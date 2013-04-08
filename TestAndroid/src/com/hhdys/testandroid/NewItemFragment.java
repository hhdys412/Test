package com.hhdys.testandroid;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class NewItemFragment extends Fragment {
	private OnNewItemAddedListener onNewItemAddedListener;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.new_item_fragment, container,
				false);
		final EditText myEditText = (EditText) view
				.findViewById(R.id.editText1);
		final Button btnAdd = (Button) view.findViewById(R.id.button1);
		btnAdd.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String newItem = myEditText.getText().toString();
				onNewItemAddedListener.onNewItemAdded(newItem);
				myEditText.setText("");
			}
		});
		return view;
	}

	public interface OnNewItemAddedListener {
		public void onNewItemAdded(String newItem);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			onNewItemAddedListener = (OnNewItemAddedListener) activity;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
