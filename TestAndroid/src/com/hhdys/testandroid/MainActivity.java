package com.hhdys.testandroid;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {
	private ListView lv;
	private EditText et;
	ArrayAdapter<String> ad;
	List<String> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		list = new ArrayList<String>();
		ad = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, list);
		et = (EditText) findViewById(R.id.editText1);
		lv = (ListView) findViewById(R.id.listView1);
		lv.setAdapter(ad);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void Add(View v) {
		list.add(0, et.getText().toString());
		ad.notifyDataSetChanged();
		et.setText("");
	}

}
